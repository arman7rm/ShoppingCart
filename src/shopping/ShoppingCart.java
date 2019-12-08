package shopping;

/** James Palacios, jwp89, RUID 166-00-4545 **/

//This file contains the ShoppingCart class, all the methods detailed on
//the assignment that had to be included as well as a Savings method that
//shows the user how much they've saved at  checkout
//Also added were statements that printed an error message when the user
//called a method with an item id parameter that wasn't in their current cart
//at the time of invoking said method
//All this and more is detailed throughout the lines of code

import java.util.ArrayList;

public class ShoppingCart {
	public static final double LOW_DISCOUNT = 0.10;
	public static final double MEDIUM_DISCOUNT = 0.25;
	public static final double HIGH_DISCOUNT = 0.50;
	ArrayList<Item> itemArray = new ArrayList<Item>();
	private String customerName;
	// sets sets the static and private variables and constants needed throughout
	// program

	public String getCustomerName() { // user name getter
		return customerName;
	}

	public void setCustomerName(String customerName) { // user name setter
		this.customerName = customerName;
	}

	public ShoppingCart() {
		// (basic constructor) initializes a ShoppingCart object without string
		// parameter
		itemArray = new ArrayList<Item>();
	}

	public ShoppingCart(String customerName) {
		// initializes ShoppingCart object and sets string parameter as the user's name
		itemArray = new ArrayList<Item>();
		this.customerName = customerName;
	}

	public void addItemToCart(Item item, int quantity) {
		for (Item i : itemArray) {
			if (i.getId() == item.getId()) {
				updateItemQuantity(item.getId(), quantity);
				return;
			}
		}
		// If item already exists, the quantity of that item is updated by calling
		// updateItemQuantity then exits out of method

		itemArray.add(item);
		String addedItem = item.toString();
		// If a new item is added, the item is added to itemArray and the details
		// of the item are fetched by calling the toString() method in Item;

		System.out.println(addedItem);
		// prints the fetched string
	}
	
	public void addDiscountedItemToCart(int itemId, double itemPrice, int itemQuantity) {
		DiscountedItem dItem = new DiscountedItem(itemId, itemPrice, itemQuantity);
		addItemToCart(dItem, itemQuantity);
	}

	public void addItemToCart(int itemId, double itemPrice, int itemQuantity) {
		if (itemId > 0 && itemId < 75) {
			addDiscountedItemToCart(itemId, itemPrice, itemQuantity);
			return;
		}
		Item item = new Item(itemId, itemPrice, itemQuantity);
		// initializes new Item object with all needed parameters

		addItemToCart(item, itemQuantity);
		// calls addItemToCart(Item item, int quantity) to make sure the item id
		// the user inputs isn't already in itemArray, if so the quantity is
		// updated rather then adding a duplicate
	}

	public void updateItemQuantity(int itemID, int newQuantity) {
		double price = 0;

		for (Item i : itemArray) {
			if (i.getId() == itemID) {
				i.setQuantity(newQuantity);
				// checks the item IDs of the items in itemArray to see if there
				// is a match, if so the quantity of said item is updated

				price = i.getPrice(); // gets item price to use in the following string

				String item_updated = "Quantity for Item Id: " + String.valueOf(itemID) + ", Cost: $"
						+ String.valueOf(price) + " has changed to " + String.valueOf(newQuantity);
				// modifies item_updated to display data in the following format- 'Quantity for
				// Item Id: 123, Cost: $20.50 is changed to 25'

				System.out.println(item_updated);
				// prints item_updated
				return;
			}
		}
		System.out.println("No Item/s with ID: " + itemID + " are currently in your shopping cart");
		// if the item ID parameter is not found in any items in itemArray, the
		// "return;" statement
		// inside the for loop above is not executed and a statement is printed letting
		// the user know that there is no item with their selected item ID currently in
		// their shopping cart to update quantity for
	}

	public void removeItemFromCart(int itemID) {
		for (Item i : itemArray) {
			if (i.getId() == itemID) {
				itemArray.remove(i);
				// checks the item IDs of the items in itemArray to see if there
				// is a match, if so that item is removed from itemArray

				System.out.println();
				System.out.println("Item/s with ID: " + itemID + " have been removed.");
				// prints line stating the item/s associated with the given item ID have been
				// removed
				return;
			}
		}
		System.out.println();
		System.out.println("No Item/s with ID: " + itemID + " are currently in your shopping cart");
		// if the item ID parameter is not found in any items in itemArray, the
		// "return;" statement
		// inside the for loop above is not executed and a statement is printed letting
		// the user know that there is no item with their selected item ID currently in
		// their shopping cart to remove
	}

	public double calculateItemBasedDiscount() {
		double discount = 0;
		int totalQuantity = 0;

		for (Item i : itemArray) {
			totalQuantity += i.getQuantity();
			// gets total quantity ACROSS ALL Items
		}

		if (totalQuantity < 11) {
			discount = 0.1;
		}
		// If the total number of quantity ACROSS ALL Items is less than 11 ,
		// LOW_DISCOUNT (10% discount) is applied

		if (totalQuantity > 10 && totalQuantity < 26) {
			discount = 0.25;
		}
		// If the total number of quantity ACROSS ALL Items is more than 10 but less
		// than 26, MEDIUM_DISCOUNT (25% discount) is applied

		if (totalQuantity > 26) {
			discount = 0.5;
		}
		// If the total number of quantity ACROSS ALL Items is more than 26,
		// HIGH_DISCOUNT (50% discount) is applied
		return discount;
	}

	/** * * @return */

	public double getTotalCost() {
		double totalFinalCost = 0;

		for (Item i : itemArray) {
			totalFinalCost += (i.getPrice() * i.getQuantity());
		}
		// Computes the total cost by adding the cost of each item (quantity * price)

		totalFinalCost = totalFinalCost - (totalFinalCost * calculateItemBasedDiscount());
		// Finds applicable discount using calculateItemBasedDiscount and applies the
		// discount to find the final cost
		return totalFinalCost;
	}

	public double getSavings() {
		double savings = 0;

		for (Item i : itemArray) {
			savings += (i.getPrice() * i.getQuantity());
		}
		// first finds total cost of everything

		savings = savings * calculateItemBasedDiscount();
		// calculates savings to be printed so the user is able to see much they've
		// saved at checkout

		return (Math.round(savings * 100)) / 100.0;
	}
}
