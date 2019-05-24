public class DrinkV2 {
	
	private String name;
	private String size;
	private double sugar;
	
	public DrinkV2(String name, String size, double sugar) {
		this.name = name;
		this.size = size;
		this.sugar = sugar;
	}

	public String getName() {
		return this.name;
	}

	public String getSize() {
		return this.size;
	}

	public double getSugar() {
		return this.sugar;
	}

	public void setName() {
		this.name = name;
	}

	public void setSize() {
		this.size = size;
	}
	
	public void setSugar() {
		this.sugar = sugar;
	}
}
