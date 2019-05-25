import java.util.*;

public class Game {
	
	public static final Scanner input = new Scanner(System.in);
	public static final Random rand = new Random();
	
	public static final double[] sugarlevels = 
		{0, .2, .25, .4, .6, .8, 1.0, 1.2, 1.5, 1.8, 2.0, 2.5, 3.0}; 
		//0, 1,  2,   3,  4,  5,   6,   7,   8,   9,  10,  11,  12
	
	public static Drink[] fillDrinks() {
		Drink[] list = {
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
				new Drink("Mango GT", "Regular", 500, sugarlevels[5], 1.2, 0), 
				new Drink("Mango GT", "Regular", 700, sugarlevels[7], 1.5, 0), 
				new Drink("Mango GT", "Large", 1000, sugarlevels[9], 2.0, 0), 
				new Drink("Kumquat GT", "Regular", 500, sugarlevels[6], 1.2, 100), 
				new Drink("Kumquat GT", "Regular", 700, sugarlevels[7], 1.5, 100), 
				new Drink("Kumquat GT", "Large", 1000, sugarlevels[10], 1.8, 100),
				new Drink("G J Roasted MT", "Regular", 500, sugarlevels[7], 0, 0), 
				new Drink("G J Roasted MT", "Large", 1000, sugarlevels[8], 0, 0), 
		};
      return list;
	}
			
	
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
	
	public static int customerOrder() {
		int total = 0;
		for(int i = 0; i < 5; i++) {
			Drink[] list = fillDrinks();
			Drink customer = new Drink();
			do {
				customer = list[rand.nextInt(20)];
			} while(customer.getShaker() == 500);
			
			customer.setToppings(rand.nextInt(3));
			System.out.println("Customer #" + (i+1) + " orders: " + customer);
			modifySugar(customer, sugarlevels, customer.getToppings());
			Drink answer = modifyFormula(list, customer);
			answer.setToppings(customer.getToppings());
			total += shakerQuestion(answer);
			total += sugarQuestion(answer);
			total += syrupQuestion(answer);
			total += waterQuestion(answer);
			System.out.println("\nAnswer: " + answer.displayAnswer());
			displayDashes();
			System.out.println();
		}
		return total;
	}
	
	public static Drink modifyFormula(Drink[] list, Drink drink) {
		if(drink.getShaker() == 500) {
			return drink;
		} else {
			for(int i = 0; i < list.length; i++) {
				if(list[i] == drink) {
					if(drink.equals(list[i - 1])) {
						list[i - 1].setSugar(drink.getSugar());
						drink = list[i - 1];
					}
				}
			}
			return drink;
		}
		
	}
	
	public static void modifySugar(Drink drink, double[] sugar, int toppings) {
		for(int i = 0; i < sugar.length; i++) {
			if(sugar[i] == drink.getSugar()) {
				drink.setSugar(sugar[i - toppings]);
			}
		}
	}
	
	public static int sugarQuestion(Drink drink) {
		System.out.println("How much sugar is in this drink?");
		double answer = input.nextDouble();
		if(answer == drink.getSugar()) {
			System.out.println("Correct!");
			return 1;
		} else {
			System.out.println("Incorrect.");
			return 0;
		}
	}
	public static int shakerQuestion(Drink drink) {
		System.out.println("What shaker do you use?");
		int answer = input.nextInt();
		if(answer == drink.getShaker()) {
			System.out.println("Correct!");
			return 1;
		} else {
			System.out.println("Incorrect.");
			return 0;
		}
	}
	
	public static int syrupQuestion(Drink drink) {
		System.out.println("How much syrup is in this drink?");
		double answer = input.nextDouble();
		if(answer == drink.getSyrup()) {
			System.out.println("Correct!");
			return 1;
		} else {
			System.out.println("Incorrect.");
			return 0;
		}
	}
	
	public static int waterQuestion(Drink drink) {
		System.out.println("How much water is in this drink?");
		int answer = input.nextInt();
		if(answer == drink.getWater()) {
			System.out.println("Correct!");
			return 1;
		} else {
			System.out.println("Incorrect.");
			return 0;
		}
	}
	
	public static void main(String[] args) {
		displayMenu();
		String keepGoing = "y";
		int questions_right = 0;
		int count = 1;
		int total = 0;
		while(keepGoing.equals("y") || keepGoing.equals("yes")) { 
			questions_right += customerOrder();
			count++;
			total = count * 4 ;
			System.out.println("Want to keep going?");
			keepGoing = input.next();
		}
		System.out.println("Congratulations! Your score is: " + questions_right + "/" + total);
		
	}
}