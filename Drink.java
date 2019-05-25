public class Drink {
	private String name;
	private String size;
	private int shaker;
	private int ice;
	private double sugar;
	private double syrup;
	private double newsugar;
	private int water;
	private int toppings;
	
	public Drink(String name, String size, int shaker, double sugar, double syrup, int water) {
		this.name = name;
		this.size = size;
		this.shaker = shaker;
		this.sugar = sugar;
		this.syrup = syrup;
		this.water = water;
	}
	
	public Drink() {
		this.sugar = 0;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getShaker() {
		return shaker;
	}
	public void setShaker(int shaker) {
		this.shaker = shaker;
	}
	public int getIce() {
		return ice;
	}
	public void setIce(int ice) {
		this.ice = ice;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.newsugar = newsugar;
	}
	public double getSyrup() {
		return syrup;
	}
	public void setSyrup(double syrup) {
		this.syrup = syrup;
	}
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water = water;
	}
	
	public int getToppings() {
		return toppings;
	}

	public void setToppings(int toppings) {
		this.toppings = toppings;	
	}
	
	public boolean equals(Drink other) {
		if(this.name == other.name && this.sugar == other.sugar && this.shaker == other.shaker) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return this.shaker + this.size + " " + this.name + " with " + this.sugar + "sugar(s) and " + this.toppings + " toppings.";
	}
	
	
}