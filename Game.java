import java.lang.*;
import java.util.*;
import java.io.*;

public class Game {
	
	Random rand = new Random();
	Scanner input = new Scanner(System.in);

	public void displayMenu() {
		displayDashes();
		System.out.println("\n  Welcome to Cool Tea Bar's\n       Verbal Quiz!");
		displayDashes();
		System.out.println("\nDrinks on the test:");
		System.out.println("   1. G J Roasted MT\n   2. Roasted MT\n   3. Tea Bar MT\n   4. Mango GT\n   5. Kumquat GT\n   6. Jasmine MT\n   7. Oolong MT");
		displayDashes();
	}
	
	public void displayDashes() {
		for(int i = 0; i < 29; i++) {
			System.out.print("-");
		}
	}

	final double[] sugarlevels =  {.8, 1.0, 1.2, 1.5, 1.8, 2.0, 2.5, 3.0};


	public void toppingsmodifier(double[] sugar, Drink drink) {

		for(int i = 0; i < sugar.length; i++) {
			if(i == drink.getSugar()) {
				int count = i;
			}
		}
		drink.setSugar(i - 1);
	}

	public Drink[] fillDrink() {
		Drink[] list = new Drink[14];
		list[0] = new Drink("G J Roasted MT", 'r', 60, sugarlevels[2], 0, 700, 0, 1);
		list[1] = new Drink("G J Roasted MT", 'l', 60, sugarlevels[3], 0, 1000, 0, 2);
		list[2] = new Drink("Roasted MT", 'r', 60, sugarlevels[1], 0, 700, 0, 3);
		list[3] = new Drink("Roasted MT", 'l', 60, sugarlevels[5], 0, 1000, 0, 4);
		list[4] = new Drink("Tea Bar MT", 'r', 60, sugarlevels[1], 0, 700, 0, 5);
		list[5] = new Drink("Tea Bar MT", 'l', 60, sugarlevels[4], 0, 1000, 0, 6);
		list[6] = new Drink("Mango GT", 'r', 60, sugarlevels[0], 1.2, 700, 0, 7);
		list[7] = new Drink("Mango GT", 'l', 60, sugarlevels[4], 2.0, 1000, 0, 8);
		list[8] = new Drink("Kumquat GT", 'r', 60, sugarlevels[1], 1.2, 700, 100, 9);
		list[9] = new Drink("Kumquat GT", 'l', 60, sugarlevels[4], 2.0, 1000, 100, 10);
		list[10] = new Drink("Jasmine MT", 'r', 60, sugarlevels[3], 0, 700, 0, 11);
		list[11] = new Drink("Jasmine MT", 'l', 60, sugarlevels[6], 0, 1000, 0, 12);
		list[12] = new Drink("Oolong MT", 'r', 60, sugarlevels[3], 0, 700, 0, 13);
		list[13] = new Drink("Oolong MT", 'l', 60, sugarlevels[7], 0, 1000, 0, 14);
		
		
		return list;
	}
	
	public int questionTime(Drink[] list) {
		int total = 0;
		int toppings = 0;
		for(int i = 0; i < 14; i ++) {
			toppings = rand.nextInt(3);
			System.out.print("\nQuestion #" + (i + 1) + ": ");
			Drink rand_drink = list[rand.nextInt(14)];
			rand_drink.setToppings(toppings);
			rand_drink.getSugar();
			System.out.println("\n" + rand_drink);
			total += shakerQuestion(rand_drink);
			total += sugarQuestion(rand_drink);
			total += syrupQuestion(rand_drink);	
			total += waterQuestion(rand_drink);
		}
		
		return total;
			
	}
	
	public char addTotal(int total) {
		double grade = (total / 56) * 100;
		if(grade >= 90) {
			return 'A';
		} else if(grade >= 80 && grade < 90) {
			return 'B';
		} else if(grade >= 70 && grade < 80) {
			return 'C';
		} else if (grade >= 60 && grade < 70) {
			return 'D';
		} else {
			return 'F';
		}
	}
	
	public int shakerQuestion(Drink drink) {
		Drink test = new Drink(drink.getName(), drink.getSize(), drink.getIce(), drink.getSugar(), drink.getSyrup(), drink.getShaker(), drink.getWater(), drink.getLabel());
		int count = 0;
		System.out.println("\nShaker: ");
		test.setShaker(input.nextInt());
		if(test.equals(drink)) {
			System.out.println("Correct!");
			count++;
		} else {
			System.out.println("Incorrect.");
		}
		return count;
	}
	
	public int sugarQuestion(Drink drink) {
		Drink test = new Drink(drink.getName(), drink.getSize(), drink.getIce(), drink.getSugar(), drink.getSyrup(), drink.getShaker(), drink.getWater(), drink.getLabel());
		int count = 0;
		System.out.println("Sugar: ");
		test.setSugar(input.nextDouble());
		if(test.equals(drink)) {
			System.out.println("Correct!");
			count++;
		} else {
			System.out.println("Incorrect.");
		}
		return count;
	}
	
	public int syrupQuestion(Drink drink) {
		Drink test = new Drink(drink.getName(), drink.getSize(), drink.getIce(), drink.getSugar(), drink.getSyrup(), drink.getShaker(), drink.getWater(), drink.getLabel());
		int count = 0;
		System.out.println("Syrup: ");
		test.setSyrup(input.nextDouble());
		if(test.equals(drink)) {
			System.out.println("Correct!");
			count++;
		} else {
			System.out.println("Incorrect.");
		}
		return count;
	}
	
	public int waterQuestion(Drink drink) {
		Drink test = new Drink(drink.getName(), drink.getSize(), drink.getIce(), drink.getSugar(), drink.getSyrup(), drink.getShaker(), drink.getWater(), drink.getLabel());
		int count = 0;
		System.out.println("Water: ");
		test.setWater(input.nextInt());
		if(test.equals(drink)) {
			System.out.println("Correct!");
			count++;
		} else {
			System.out.println("Incorrect.");
		}
		return count;
	}
		
	public void run() {
		displayMenu();
		System.out.println("You finished the test! Letter grade: " + addTotal(questionTime(fillDrink())));
	}
	
}
