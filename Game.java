import java.util.*;

public class Game {
	
	public static final Scanner input = new Scanner(System.in);
	public static final Random rand = new Random();
	
	public static final double[] sugarlevels = 
		{0, .2, .25, .4, .6, .8, 1.0, 1.2, 1.5, 1.8, 2.0, 2.5, 3.0}; 
		//0, 1,  2,   3,  4,  5,   6,   7,   8,   9,  10,  11,  12
	
	public static final Drink[] drinks = {
			
			new Drink("Tea Bar MT", "Regular", 500, sugarlevels[6], 0, 0), 
			new Drink("Tea Bar MT", "Regular", 700, sugarlevels[7], 0, 0), 
			new Drink("Tea Bar MT", "Large", 1000, sugarlevels[9], 0, 0), 
			new Drink("Roasted MT", "Regular", 500, sugarlevels[6], 0, 0), 
			new Drink("Roasted MT", "Regular", 700, sugarlevels[7], 0, 0), 
			new Drink("Roasted MT", "Large", 1000, sugarlevels[10], 0, 0),
			new Drink("Jasmine MT", "Regular", 500, sugarlevels[8], 0, 0), 
			new Drink("Jasmine MT", "Regular", 700, sugarlevels[9], 0, 0), 
			new Drink("Jasmine MT", "Large", 1000, sugarlevels[11], 0, 0), 
			new Drink("Oolong MT", "Regular", 500, sugarlevels[8], 0, 0), 
			new Drink("Oolong MT", "Regular", 700, sugarlevels[9], 0, 0), 
			new Drink("Oolong MT", "Large", 1000, sugarlevels[12], 0, 0),
			new Drink("Mango GT", "Regular", 700, sugarlevels[5], 1.2, 0), 
			new Drink("Mango GT", "Regular", 700, sugarlevels[7], 1.5, 0), 
			new Drink("Mango GT", "Large", 1000, sugarlevels[9], 2.0, 0), 
			new Drink("Kumquat GT", "Regular", 500, sugarlevels[6], 1.2, 100), 
			new Drink("Kumquat GT", "Regular", 700, sugarlevels[7], 1.5, 100), 
			new Drink("Kumquat GT", "Large", 1000, sugarlevels[10], 1.8, 100),
			new Drink("G J Roasted MT", "Regular", 500, sugarlevels[7], 0, 0), 
			new Drink("G J Roasted MT", "Large", 1000, sugarlevels[8], 0, 0),
	};
	
	public static void displayMenu() {
		displayDashes();
		System.out.println("\n  Welcome to Cool Tea Bar's\n       Verbal Quiz!");
		displayDashes();
		System.out.println("\nDrinks on the test:");
		System.out.println("   1. G J Roasted MT\n   2. Roasted MT\n   3. Tea Bar MT\n   4. Mango GT\n   5. Kumquat GT\n   6. Jasmine MT\n   7. Oolong MT");
		displayDashes();
		System.out.println();
	}
	
	public static void displayDashes() {
		for(int i = 0; i < 29; i++) {
			System.out.print("-");
		}
		
	}
	
	public static void test() {
		int toppings = rand.nextInt(3);
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < drinks.length; j++) {
				if(drinks[j] == drinks[2]) {
					System.out.println(drinks[2]);
					drinks[2].setSugar(i - 1);
					System.out.println(drinks[2]);
				}
			}
		}
	}
	
	public static void sugarQuestion() {
		System.out.println("How much sugar is in this drink?");
	}
	
	public static void main(String[] args) {
		displayMenu();
		test();
	}
}