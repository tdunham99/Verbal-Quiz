public class Drink {
	private String name;
	private int shaker;
	private int ice;
	private double sugar;
	private char size;
	private int toppings;
	private int label;
	private double syrup;
	private int water;
	
	public double getSyrup() {
		return syrup;
	}

	public void setSyrup(double syrup) {
		this.syrup = syrup;
	}

	public int getWater() {
		return water;
	}

	public void setShaker(int shaker) {
		this.shaker = shaker;
	}

	public void setSugar(double[] sugar, int toppings) {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIce() {
		return ice;
	}

	public void setIce(int ice) {
		this.ice = ice;
	}

	public int getToppings() {
		return toppings;
	}

	public double getSugar() { return this.sugar; }

	public void setSize(char size) {
		this.size = size;
	}

	public void setWater(int water) {
		this.water = water;
	}
	
	public Drink(String name, char size, int ice, double sugar, double syrup, int shaker, int water, int label) {
		this.name = name;
		this.size = size;
		this.shaker = shaker;
		this.ice = ice;
		this.sugar = sugar;
		this.label = label;
	}
	
	public int getLabel() {
		return this.label;
	}

	public void setLabel(int label) {
		this.label = label;
	}
	
	public char getSize() {
		return this.size;
	}

	public String getNormalSize() {
		if(this.size == 'r') {
			return "Regular";
		} else if(this.size == 'l') {
			return "Large";
		} else  {
			return "Invalid size";
		}
	}

	public double getSugar() {
		return this.sugar;
	}
	
	/* public double[] fillSugar() {
		double[] sugar = new double[14];
		for(int i = 0; i < sugar.length; i++) {
			if(i == 4) {
				sugar[i] = 1.8;
			} else if(i == 6 || i == 7) {
				sugar[i] = 2.5 + ((i - 6) * (.5));
			} else {
				sugar[i] = .8 + (.2 * (i + 1));
			}
		}
		return sugar;
	} */



	public int getShaker() {
		if((this.size == 'r' && this.toppings == 0) || (this.size == 'l' && this.toppings > 1) || (this.name == "Roasted MT" && this.size == 'l' && this.toppings == 3)) {
			return 700;
		} else if (this.size == 'r' && this.toppings > 0) {
			return 500;
		} else if (this.size == 'l' && this.toppings == 0) {
			return 1000;
		} else {
			return 0;
		}
	}
	
	public void setToppings(int toppings) {
		this.toppings = toppings;
	}
	
	public String displayAnswer() {
		return getNormalSize() + " " + this.name + " with " + getShaker() + "cc shaker," + this.ice + "% ice and " + getSugar() + "oz";
	}
	
	public boolean equals(Drink other) {
		if(this.sugar == other.sugar && this.syrup == other.syrup && this.shaker == other.shaker && this.water == other.water) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return getNormalSize() + " " + this.name + " with " + this.toppings + " toppings ";
	}
}
