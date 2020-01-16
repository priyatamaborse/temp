package assignment.com.yash.training;

public interface TeaCoffeeVendingMachineOperation {

	public void makeDrink(String drinkName,ContainerMaterialDTO containerMaterialDTO, Integer numberOfDrinks, Integer priceOfDrink);
	public void refillContainer(Boolean isRefillCalled);
	public void totalSaleCalculator();
	public void resetContainer();	
}
