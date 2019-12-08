package shopping;

/** James Palacios, jwp89, RUID 166-00-4545 **/

//This file contains the Tester class that acts as the user interface for navigating
//their shopping cart, makes sure all user errors in input and errors in logic 
//(ie. removing, updating item that isn't in their cart) are accounted for, 
//loops available options until user wants to leave application then exits application gracefully

import java.util.Scanner;

public class ShoppingCartTester {
	public static void main(String[] args) {
		userInputSimulator();
	}

	public static void userInputSimulator() {

		Scanner getName = new Scanner(System.in);

		System.out.println("Welcome to the Shopping Cart Application");
		System.out.print("Please Enter Your Name: ");

		String userName = getName.next();
		// gets user's name for following code

		ShoppingCart userCart = new ShoppingCart(userName);
		// initializes a new ShoppingCart object and sets the user name to the string
		// parameter provided

		System.out.println();
		System.out.println("Hi there " + userCart.getCustomerName() + "! Your shopping cart has been created!");
		System.out.println();
		System.out.println("TODAY, kids toys, men's clothing, and women's clothing are on SALE!!!");
		System.out.println("Take advantage of this SALE TODAY by using the IDs '0-24', '25'49, and '50-74' RESPECTIVELY!");
		System.out.println("(All other items are at regular price, BUT, buying in bulk will guarantee a hefty discount off your total!!!");
		// welcomes user to application

		Scanner input = new Scanner(System.in);

		int choice;
		// will be used in options loop

		while (true) { // option "screen" that will be looped until user terminates program
			System.out.println();
			System.out.println("Select one of the following options:");
			System.out.println();
			System.out.println("1. Add an Item to your Shopping Cart");
			System.out.println("2. Update the Quantity of an Item already in your Shopping Cart");
			System.out.println("3. Remove an Item from your Shopping Cart");
			System.out.println(
					"4. Calculate your current Discount, buying more than 26 items guarantees the highest discount!");
			System.out.println("5. Calculate the current Total, includes how much you'll be Saving with us today!");
			System.out.println();
			System.out.println("6. Checkout");
			System.out.println();
			System.out.println("7. Exit");
			System.out.println();

			while (true) { // error checks user input by looping until user inputs a valid option (1-7)
				if (input.hasNextInt()) {
					choice = input.nextInt();
					break;
				} else {
					System.out.println("Please select a valid Option (1-7)");
					System.out.println();
					System.out.println("Select one of the following options:");
					System.out.println();
					System.out.println("1. Add an Item to your Shopping Cart");
					System.out.println("2. Update the Quantity of an Item already in your Shopping Cart");
					System.out.println("3. Remove an Item from your Shopping Cart");
					System.out.println(
							"4. Calculate your current Discount, buying more than 26 items guarantees the highest discount!");
					System.out.println(
							"5. Calculate the current Total, includes how much you'll be Saving with us today!");
					System.out.println();
					System.out.println("6. Checkout");
					System.out.println();
					System.out.println("7. Exit");
					System.out.println();
					input.next();
				}
			}

			switch (choice) {

			case 1:
				int itemID = 1;
				double itemPrice = 0;
				int itemQuantity = 1;

				System.out.println();
				System.out.println("You have selected to add an item to your shopping cart");
				System.out.println();
				System.out.print("Enter the Item ID: ");
				Scanner getItemID = new Scanner(System.in);
				// asks user for item ID of item they wish to add

				do { // error checks by looping until user inputs a valid item ID
					if (itemID < 1) {
						System.out.println();
						System.out.print("Please enter a valid Item ID: ");
					}
					while (!getItemID.hasNextInt()) {
						System.out.println();
						System.out.print("Please enter a valid Item ID: ");
						getItemID.next();
					}
					itemID = getItemID.nextInt();
				} while (itemID < 1);

				System.out.println();
				System.out.print("Enter the price of the item: ");
				Scanner getItemPrice = new Scanner(System.in);
				// asks user for the price of item they wish to add

				do { // error checks by looping until user inputs a valid item price
					if (itemPrice < 0) {
						System.out.println();
						System.out.print("Please enter a valid price: ");
					}
					while (!getItemPrice.hasNextDouble()) {
						System.out.println();
						System.out.print("Please enter a valid price: ");
						getItemPrice.next();
					}
					itemPrice = getItemPrice.nextDouble();
				} while (itemPrice < 0);

				System.out.println();
				System.out.print("Enter the item quantity: ");
				Scanner getItemQuantity = new Scanner(System.in);
				// asks user for item quantity of item they wish to add

				do { // error checks by looping until user inputs a valid item quantity
					if (itemQuantity < 1) {
						System.out.println();
						System.out.print("Please enter a valid quantity: ");
					}
					while (!getItemQuantity.hasNextInt()) {
						System.out.println();
						System.out.print("Please enter a valid quantity: ");
						getItemQuantity.next();
					}
					itemQuantity = getItemQuantity.nextInt();
				} while (itemQuantity < 1);

				System.out.println();

				userCart.addItemToCart(itemID, itemPrice, itemQuantity);
				// adds item of their choice to their cart

				break;

			case 2:

				int itemID2 = 1;
				int newQuantity = 1;

				System.out.println();
				System.out.println("You have selected to change an item's quantity");
				System.out.println();
				System.out.print("Enter the Item ID: ");
				Scanner getItemID2 = new Scanner(System.in);
				// asks user for item ID of item they wish to update quantity

				do { // error checks by looping until user inputs a valid item ID
					if (itemID2 < 1) {
						System.out.println();
						System.out.print("Please enter a valid Item ID: ");
					}
					while (!getItemID2.hasNextInt()) {
						System.out.println();
						System.out.print("Please enter a valid Item ID: ");
						getItemID2.next();
					}
					itemID2 = getItemID2.nextInt();
				} while (itemID2 < 1);

				System.out.println();
				System.out.print("Enter the new item quantity: ");
				Scanner newQuantitySC = new Scanner(System.in);
				// asks user for the new quantity they'd like to have for their selected item

				do { // error checks by looping until user inputs a valid item quantity
					if (newQuantity < 1) {
						System.out.println();
						System.out.print("Please enter a valid quantity: ");
					}
					while (!newQuantitySC.hasNextInt()) {
						System.out.println();
						System.out.print("Please enter a valid quantity: ");
						newQuantitySC.next();
					}
					newQuantity = newQuantitySC.nextInt();
				} while (newQuantity < 1);

				System.out.println();
				userCart.updateItemQuantity(itemID2, newQuantity);
				// updates the quantity of the selected user item if valid item ID is provided
				// if not method will return a statement saying there is no item of given
				// item ID currently in the user's shopping cart to update

				break;

			case 3:
				int itemID3 = 1;

				System.out.println();
				System.out.println("You have selected to remove an item from your shopping cart");
				System.out.println();
				System.out.print("Enter an Item ID: ");
				Scanner getItemID3 = new Scanner(System.in);
				// asks user for item ID of item they wish to remove

				do { // error checks by looping until user inputs a valid item ID
					if (itemID3 < 1) {
						System.out.println();
						System.out.print("Please enter a valid Item ID: ");
					}
					while (!getItemID3.hasNextInt()) {
						System.out.println();
						System.out.print("Please enter a valid Item ID: ");
						getItemID3.next();
					}
					itemID3 = getItemID3.nextInt();
				} while (itemID3 < 1);

				userCart.removeItemFromCart(itemID3);
				// removes selected item from shopping cart if valid item ID is provided
				// if not method will return a statement saying there is no item of given
				// item ID currently in the user's shopping cart to remove

				break;

			case 4:

				double discount = 0;

				System.out.println();
				System.out.println("You have selected to calculate your current percent discount");
				System.out.println();

				discount = userCart.calculateItemBasedDiscount();
				// calculates discount

				String currentDiscount = discount * 100 + "";
				System.out.println("At checkout the total for your current cart will be " + currentDiscount + "% OFF!");
				System.out.println();
				// prints user discount as a percent (ie. 10%, 25%, 50%)

				break;

			case 5:

				System.out.println();
				System.out
						.println("You have selected to calculate your current total cost after applying your discount");
				System.out.println();
				System.out.println("Your current total is: $" + userCart.getTotalCost());
				// prints current total cost applying discount
				System.out.println();
				System.out.println("You Saved $" + userCart.getSavings() + "!");
				// prints user's savings to assure customer satisfaction

				break;

			case 6:
				Scanner shipping = new Scanner(System.in);
				int option;
				
				while (true) {
					System.out.println("You have selected to Checkout");
					System.out.println();
					System.out.println("Select one of the following shipping methods:");
					System.out.println();
					System.out.println("1. Complete order with Regular Shipping");
					System.out.println();
					System.out.println("2. Complete order with Expedited Shipping");
				
				while (true) { // error checks user input by looping until user inputs a valid option (1-2)
					if (shipping.hasNextInt()) {
						option = shipping.nextInt();
						break;
					} else {
						System.out.println("Please select a valid Option (1-2)");
						System.out.println();
						System.out.println("You have selected to Checkout");
						System.out.println();
						System.out.println("Select one of the following shipping methods:");
						System.out.println();
						System.out.println("1. Complete order with Regular Shipping");
						System.out.println();
						System.out.println("2. Complete order with Expedited Shipping");
						shipping.next();
					}
				}
				switch (option) {
				case 1: 
					System.out.println();
					System.out.println("You've selected regular shipping");
					RegularShipping reg = new RegularShipping();
					System.out.println();
					System.out.println("Your current total is: $" + userCart.getTotalCost());
					System.out.println("Shipping is: $" + reg.price());
					System.out.println();
					double a = userCart.getTotalCost();
					double b = reg.price();
					double c = a + b;
					System.out.println("Total cost is: $" + c);
					System.out.println();
					System.out.println("You'll receive your items within " + reg.expectedDuration() + " days!");
					System.out.println();
					System.out.println("Thanks for shopping!!! Have a nice day");
					System.exit(0);
					
				case 2:
					System.out.println();
					System.out.println("You've selected expedited shipping");
					ExpeditedShipping ex = new ExpeditedShipping();
					System.out.println();
					System.out.println("Your current total is: $" + userCart.getTotalCost());
					System.out.println("Shipping is: $" + ex.price());
					System.out.println();
					double d = userCart.getTotalCost();
					double e = ex.price();
					double f = d + e;
					System.out.println("Total cost is: $" + f);
					System.out.println();
					System.out.println("You'll receive your items within " + ex.expectedDuration() + " days!");
					System.out.println();
					System.out.println("Thanks for shopping!!! Have a nice day");
					System.exit(0);
					
				default:
					System.out.println("Please select a valid Option (1-2)");
					// if user's input is invalid asks user to select a valid option
					// then repeats main loop and displays all user options again
					break;
				}
			}
				
			case 7:
				String s;

				System.out.println("Are you sure you want to exit? (y/n)");
				Scanner testExit = new Scanner(System.in);
				s = testExit.nextLine();
				// asks user if they're sure they'd like to exit application

				if (s.startsWith("y")) {
					System.out.println("Good bye! Have a nice day!");
					System.exit(0);
					// terminates program when user wants to exit application
				}

				else {
					// if not, repeats main loop and displays shopping cart options to user
					break;
				}

			default:
				System.out.println("Please select a valid Option (1-7)");
				// if user's input is invalid asks user to select a valid option
				// then repeats main loop and displays all user options again
				break;
			}
		}
	}
}