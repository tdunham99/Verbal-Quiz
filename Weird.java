import java.util.*;

public class Weird extends Drink {
	private String type;
	private double topping;
	private int ice;
	private int creamer;
	
	Scanner input = new Scanner(System.in);
	
	public Weird(String name, String size, int shaker, double sugar, double syrup, int water, double topping, int creamer, int ice, String type) {
		super(name, size, shaker, sugar, syrup, water);
		this.topping = topping;
		this.creamer = creamer;
		this.ice = ice;
		this.type = type;
	}

	public double getTopping() {
		return topping;
	}

	public void setTopping(double topping) {
		this.topping = topping;
	}

	public int getCreamer() {
		return creamer;
	}

	public void setCreamer(int creamer) {
		this.creamer = creamer;
	}
	
	public int iceQuestion() {
		System.out.println("How much ice is in this drink?");
		double answer = input.nextDouble();
		if(answer == this.ice){
			System.out.println("Correct!");
			return 1;
		} else {
			System.out.println("Incorrect.");
			return 0;
		}
	}
	
	public int toppingQuestion() {
		System.out.println("How much " + this.type
		+ " is in this drink?");
		double answer = input.nextDouble();
		if(answer == this.topping){
			System.out.println("Correct!");
			return 1;
		} else {
			System.out.println("Incorrect.");
			return 0;
		}
	}
	
	public int creamerQuestion() {
		System.out.println("How much creamer is in this drink?");
		double answer = input.nextDouble();
		if(answer == this.creamer) {
			System.out.println("Correct!");
			return 1;
		} else {
			System.out.println("Incorrect.");
			return 0;
		}
	}
	
	public String displayAnswer() {
		return this.getSize() + " " + this.getName() + " with " + this.getToppings() + " toppings, " + this.getSugar() + " oz of sugar, a " + this.getShaker()+ "cc shaker, " +  this.getSyrup()+ " oz of syrup, and " + this.getWater()+ "cc of water, " + this.topping + " scoops of " + this.type + " and " + this.creamer + " scoops of creamer\n"; 
	}
}
