package assignment.com.yash.training;

import org.apache.log4j.Logger;

public class TeaCoffeeVendingMachineSimulator {

	private static final Logger logger = Logger.getLogger(TeaCoffeeVendingMachineOperationImpl.class.getName());
	private MyScanner scanner = new MyScanner();
	TeaCoffeeVendingMachineOperationImpl teaCoffeeVendingMachineOperationImpl = new TeaCoffeeVendingMachineOperationImpl();
	
	public void menuList()
	{
		Integer menuItem ,numberOfCups = null;
		
		do {
			logger.info("Choose menu item of your choice: ");
			logger.info("1. MAKE COFFEE ");
			logger.info("2. MAKE TEA ");
			logger.info("3. MAKE BLACK COFFEE ");
			logger.info("4. MAKE BLACK TEA ");
			logger.info("5. REFILL CONTAINER ");
			logger.info("6. CHECK TOTAL SALE");
			logger.info("7. CONTAINER STATUS ");
			logger.info("8. RESET CONTAINER ");
			logger.info("0. EXIT TCVM ");
			
			menuItem = scanner.nextInt();

			switch (menuItem) {

			case 1:
				
				logger.info(" How many Cup Of Coffee do you want ? Each cup for RS 15 /-");
				numberOfCups = scanner.nextInt();
				teaCoffeeVendingMachineOperationImpl.makeDrink("Coffee",new ContainerMaterialDTO(0, 4, 15, 20, 80, 0, 1, 2, 3, 8),numberOfCups,15);

				break;

			case 2:

				logger.info(" How many Cup Of Tea do you want ? Each cup for RS 10 /-");
				numberOfCups = scanner.nextInt();
				teaCoffeeVendingMachineOperationImpl.makeDrink("Tea",new ContainerMaterialDTO(5, 0, 15, 60, 40, 1, 0, 2, 5, 4),numberOfCups,10);

				break;

			case 3:

				logger.info("How many Cup Of Black Coffee do you want ? Each cup for RS 10 /-");
				numberOfCups = scanner.nextInt();
				teaCoffeeVendingMachineOperationImpl.makeDrink("Black Coffee",new ContainerMaterialDTO(0, 2, 15, 100, 0, 0, 0, 2, 12, 0),numberOfCups,10);
				break;

			case 4:

				logger.info("How many Cup Of Black Tea do you want ? Each cup for RS 5 /-");
				numberOfCups = scanner.nextInt();
				teaCoffeeVendingMachineOperationImpl.makeDrink("Black Tea",new ContainerMaterialDTO(3, 0, 15, 100, 0, 0, 0, 2, 12, 0),numberOfCups,5);

				break;

			case 5:
				
				teaCoffeeVendingMachineOperationImpl.refillContainer(true);
				break;

			case 6:
				
				teaCoffeeVendingMachineOperationImpl.totalSaleCalculator();

				break;

			case 7:
				
				teaCoffeeVendingMachineOperationImpl.containerStatus();
				break;

			case 8:

				teaCoffeeVendingMachineOperationImpl.resetContainer();
				break;

			case 0:

				break;

			default:
				logger.warn("Invalid choice.");

			}

		} while (menuItem != 0);
	}

}
