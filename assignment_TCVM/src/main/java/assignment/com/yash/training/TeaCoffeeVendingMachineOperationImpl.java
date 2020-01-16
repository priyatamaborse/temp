package assignment.com.yash.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class TeaCoffeeVendingMachineOperationImpl implements TeaCoffeeVendingMachineOperation {

	private static final Logger logger = Logger.getLogger(TeaCoffeeVendingMachineOperationImpl.class.getName());
	private static Integer refillingCounter = 0;
	private Map<String, Integer> mapOfContainer;
	private List<ContainerMaterialDTO> listOfContainerMaterialDTO = new ArrayList<>();
	private MyScanner scanner = new MyScanner();
	
	
	public TeaCoffeeVendingMachineOperationImpl() {
		
		this.mapOfContainer = new HashMap<String, Integer>();
		mapOfContainer.put("Tea Container", 2000);
		mapOfContainer.put("Coffee Container", 2000);
		mapOfContainer.put("Sugar Container", 8000);
		mapOfContainer.put("Water Container", 15000);
		mapOfContainer.put("Milk Container", 10000);
	}

	@Override
	public void makeDrink(String drinkName, ContainerMaterialDTO containerMaterialDTO, Integer numberOfCups,
			Integer priceOfDrink) {

		Map<String, Integer> tempMap = getMapOfContainerWithZeroValues();
		Boolean flag = true;
		for (String key : mapOfContainer.keySet()) {
			if (key.equals("Tea Container"))
				tempMap.put(key, (tempMap.get(key) + (numberOfCups * containerMaterialDTO.getTeaQuantity())));
			if (key.equals("Coffee Container"))
				tempMap.put(key, (tempMap.get(key) + (numberOfCups * containerMaterialDTO.getCoffeeQuantity())));
			if (key.equals("Sugar Container"))
				tempMap.put(key, (tempMap.get(key) + (numberOfCups * containerMaterialDTO.getSugarQuantity())));
			if (key.equals("Water Container"))
				tempMap.put(key, (tempMap.get(key) + (numberOfCups * containerMaterialDTO.getWaterQuantity())));
			if (key.equals("Milk Container"))
				tempMap.put(key, (tempMap.get(key) + (numberOfCups * containerMaterialDTO.getMilkQuantity())));
		}

		for (String key : tempMap.keySet()) {
			if ( (mapOfContainer.get(key) - tempMap.get(key)) < 0) {
				flag = false;
				logger.info(" Enough Quantity of  material is not present in " + key + "!!");
			}
		}
		if (flag) {
			for (String key : tempMap.keySet()) {
				
				mapOfContainer.put(key, (mapOfContainer.get(key) - tempMap.get(key)));
			}
			containerMaterialDTO.setDrinkName(drinkName);
			containerMaterialDTO.setNumberOfCups(numberOfCups);
			containerMaterialDTO.setPriceOfDrink(priceOfDrink);
			containerMaterialDTO.setWasteTeaQuantity(containerMaterialDTO.getWasteTeaQuantity()*numberOfCups);
			containerMaterialDTO.setWasteCoffeeQuantity(containerMaterialDTO.getWasteCoffeeQuantity()*numberOfCups);
			containerMaterialDTO.setWasteSugarQuantity(containerMaterialDTO.getWasteSugarQuantity()*numberOfCups);
			containerMaterialDTO.setWasteWaterQuantity(containerMaterialDTO.getWasteWaterQuantity()*numberOfCups);
			containerMaterialDTO.setWasteMilkQuantity(containerMaterialDTO.getWasteMilkQuantity()*numberOfCups);
			listOfContainerMaterialDTO.add(containerMaterialDTO);
			logger.info(" Number of cups :" + numberOfCups + " With Total price " + priceOfDrink * numberOfCups);
		}

	}

	public void refillContainer(Boolean isRefillCalled) {
		
		Integer sequenceNumberOfContainer;
		Integer maxCapacityOfContainer = null;
		Boolean continueOrNot;
		Integer amountOfDrink;
		String key = null;

		do {
			logger.info(" Which of the below Container you want to Refill ");
			logger.info(" 1. TEA Container With remaning material is " + mapOfContainer.get("Tea Container"));
			logger.info(" 2. COFFEE Container With remaning material is " + mapOfContainer.get("Coffee Container"));
			logger.info(" 3. SUGAR Container With remaning material is " + mapOfContainer.get("Sugar Container"));
			logger.info(" 4. WATER Container With remaning material is " + mapOfContainer.get("Water Container"));
			logger.info(" 5. MILK Container With remaning material is " + mapOfContainer.get("Milk Container"));
			sequenceNumberOfContainer = scanner.nextInt();

			if (sequenceNumberOfContainer == 1) {
				maxCapacityOfContainer = 2000;
				key = "Tea Container";
			} else if (sequenceNumberOfContainer == 2) {

				maxCapacityOfContainer = 2000;
				key = "Coffee Container";
			} else if (sequenceNumberOfContainer == 3) {

				maxCapacityOfContainer = 8000;
				key = "Sugar Container";
			} else if (sequenceNumberOfContainer == 4) {

				maxCapacityOfContainer = 15000;
				key = "Water Container";
			} else if (sequenceNumberOfContainer == 5) {
				maxCapacityOfContainer = 10000;
				key = "Milk Container";
			} else {
				logger.info(" Please enter valid choice !!");
			}

			if ((maxCapacityOfContainer != null)) {

				logger.info(" Enter amount of material you want to Refill ");
				amountOfDrink = scanner.nextInt();

				if ((mapOfContainer.get(key) + amountOfDrink) <= maxCapacityOfContainer) {
					mapOfContainer.put(key, mapOfContainer.get(key) + amountOfDrink);
					logger.info(" Refilled Successfully with amount " + amountOfDrink);
					refillingCounter++;
				} else
					logger.error(" You have enter extra amount of material than container capacity");

			}

			logger.info("  do you want to continue refilling press 1 or 0");
			continueOrNot = scanner.nextInt() == 1 ? true : false;
			isRefillCalled = false;
		} while (continueOrNot);

	}

	public void totalSaleCalculator() {

		Integer totalNumberOfCup = null;
		Integer sumOfTotalPrice = null;

		Map<String, Integer> mapOfDrinkNameAndPrice = listOfContainerMaterialDTO.stream().collect(Collectors.toMap(
				ContainerMaterialDTO::getDrinkName, ContainerMaterialDTO::getPriceMultiplyByDrink, (x, y) -> x + y));
		
		Map<String, Integer> mapOfDrinkNameAndNumberOfCups = listOfContainerMaterialDTO.stream().collect(Collectors
				.toMap(ContainerMaterialDTO::getDrinkName, ContainerMaterialDTO::getNumberOfCups, (x, y) -> x + y));
		
		logger.info("1. Total Tea-Coffee Sale Report Drink Wise  :=>  \n");
		logger.info("Drink Name"+"\t"+"Number of Cups"+"\t"+" Total Price");
		mapOfDrinkNameAndPrice.forEach((x, y) -> logger.info(String.format("%-20s%-20d%-20d",x, mapOfDrinkNameAndNumberOfCups.get(x),y)));

		totalNumberOfCup = listOfContainerMaterialDTO.stream().collect(Collectors.summingInt(ContainerMaterialDTO::getNumberOfCups));
		sumOfTotalPrice = listOfContainerMaterialDTO.stream().collect(Collectors.summingInt((ContainerMaterialDTO::getPriceMultiplyByDrink)));
		logger.info(" \n\n2. Total Tea-Coffee Sale                    :=>  \n");
		logger.info("Total Number of Cups "+"\t\t"+"Sum of Total Price");
		logger.info(totalNumberOfCup+"\t\t\t\t"+sumOfTotalPrice);

		logger.info("\n3. Container Status Report                  :=>  \n");
		mapOfContainer.keySet().forEach(key -> logger.info(key + " : " + mapOfContainer.get(key)));

		logger.info(" \n4. Refilling done                        :=> " + refillingCounter + " times \n");

		logger.info("5. Total Waste Of material                  :=> \n");
		logger.info("Waste Of Tea"+"\t\t"+"Waste Of Coffee"+"\t\t"+" Waste Of Sugar"+"\t\t"+" Waste Of Water"+"\t\t"+" Waste Of Milk");

		
		logger.info(
				listOfContainerMaterialDTO.stream()
						.collect(Collectors.summingInt(ContainerMaterialDTO::getWasteTeaQuantity))
						+"\t\t\t"+
				listOfContainerMaterialDTO.stream()
						.collect(Collectors.summingInt(ContainerMaterialDTO::getWasteCoffeeQuantity))
						+"\t\t\t"+
				listOfContainerMaterialDTO.stream()
						.collect(Collectors.summingInt(ContainerMaterialDTO::getWasteSugarQuantity))
						+"\t\t\t"+
				listOfContainerMaterialDTO.stream()
						.collect(Collectors.summingInt(ContainerMaterialDTO::getWasteWaterQuantity))
						+"\t\t\t"+
				listOfContainerMaterialDTO.stream()
						.collect(Collectors.summingInt(ContainerMaterialDTO::getWasteMilkQuantity))
						);
	}

	public void containerStatus() {
		
		logger.info(" Max Capacity of container :");
		logger.info("Tea Container    : 2000");
		logger.info("Coffee Container : 2000");
		logger.info("Sugar Container  : 8000");
		logger.info("Water Container  : 15000");
		logger.info("Milk Container   : 10000");

		logger.info("\n Remaning quantity of material in container :");
		mapOfContainer.keySet().forEach(key -> logger.info(key + " : " + mapOfContainer.get(key)));

	}

	public void resetContainer() {

		mapOfContainer.put("Tea Container", 2000);
		mapOfContainer.put("Coffee Container", 2000);
		mapOfContainer.put("Sugar Container", 8000);
		mapOfContainer.put("Water Container", 15000);
		mapOfContainer.put("Milk Container", 10000);
		logger.info("Reset Successful !!");
	}

	private static Map<String, Integer> getMapOfContainerWithZeroValues() {
		
		Map<String, Integer> tempMap = new HashMap<String, Integer>();
		tempMap.put("Tea Container", 0);
		tempMap.put("Coffee Container", 0);
		tempMap.put("Sugar Container", 0);
		tempMap.put("Water Container", 0);
		tempMap.put("Milk Container", 0);
		return tempMap;
	}

}
