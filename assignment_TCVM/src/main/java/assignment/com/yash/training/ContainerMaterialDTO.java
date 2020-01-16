package assignment.com.yash.training;

public class ContainerMaterialDTO {

	private Integer teaQuantity;
	private Integer coffeeQuantity;
	private Integer sugarQuantity;
	private Integer waterQuantity;
	private Integer milkQuantity;
	private Integer wasteTeaQuantity;
	private Integer wasteCoffeeQuantity;
	private Integer wasteSugarQuantity;
	private Integer wasteWaterQuantity;
	private Integer priceOfDrink;
	private Integer wasteMilkQuantity;
	private String drinkName;
	private Integer numberOfCups;
	private Integer priceMultiplyByDrink;
	
	
	public ContainerMaterialDTO(Integer teaQuantity, Integer coffeeQuantity, Integer sugarQuantity,
			Integer waterQuantity, Integer milkQuantity, Integer wasteTeaQuantity, Integer wasteCoffeeQuantity,
			Integer wasteSugarQuantity, Integer wasteWaterQuantity, Integer wasteMilkQuantity) {
		
		super();
		this.teaQuantity = teaQuantity;
		this.coffeeQuantity = coffeeQuantity;
		this.sugarQuantity = sugarQuantity;
		this.waterQuantity = waterQuantity;
		this.milkQuantity = milkQuantity;
		this.wasteTeaQuantity = wasteTeaQuantity;
		this.wasteCoffeeQuantity = wasteCoffeeQuantity;
		this.wasteSugarQuantity = wasteSugarQuantity;
		this.wasteWaterQuantity = wasteWaterQuantity;
		this.wasteMilkQuantity = wasteMilkQuantity;
	}

	public Integer getWasteTeaQuantity() {
		return wasteTeaQuantity;
	}

	public void setWasteTeaQuantity(Integer wasteTeaQuantity) {
		this.wasteTeaQuantity = wasteTeaQuantity;
	}

	public Integer getWasteCoffeeQuantity() {
		return wasteCoffeeQuantity;
	}

	public void setWasteCoffeeQuantity(Integer wasteCoffeeQuantity) {
		this.wasteCoffeeQuantity = wasteCoffeeQuantity;
	}

	public Integer getWasteSugarQuantity() {
		return wasteSugarQuantity;
	}

	public void setWasteSugarQuantity(Integer wasteSugarQuantity) {
		this.wasteSugarQuantity = wasteSugarQuantity;
	}

	public Integer getWasteWaterQuantity() {
		return wasteWaterQuantity;
	}

	public void setWasteWaterQuantity(Integer wasteWaterQuantity) {
		this.wasteWaterQuantity = wasteWaterQuantity;
	}

	public Integer getWasteMilkQuantity() {
		return wasteMilkQuantity;
	}

	public void setWasteMilkQuantity(Integer wasteMilkQuantity) {
		this.wasteMilkQuantity = wasteMilkQuantity;
	}

	public Integer getPriceMultiplyByDrink() {
		this.priceMultiplyByDrink = this.numberOfCups*this.priceOfDrink;
		return this.priceMultiplyByDrink;
	}
	
	public void setPriceOfDrink(Integer priceOfDrink) {
		this.priceOfDrink = priceOfDrink;
	}
	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public Integer getNumberOfCups() {
		return numberOfCups;
	}

	public void setNumberOfCups(Integer numberOfCups) {
		this.numberOfCups = numberOfCups;
	}

	public Integer getTeaQuantity() {
		return teaQuantity;
	}
	
	public Integer getCoffeeQuantity() {
		return coffeeQuantity;
	}
	
	public Integer getSugarQuantity() {
		return sugarQuantity;
	}
	
	public Integer getWaterQuantity() {
		return waterQuantity;
	}
	
	public Integer getMilkQuantity() {
		return milkQuantity;
	}

}
