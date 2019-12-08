package shopping;

/** James Palacios, jwp89, RUID 166-00-4545 **/

//This file contains the Item class and has all the getters and setters 
//needed to run accordingly as well as the constructor for objects of type Item

public class Item {

	private int id;
	private double price;
	private int quantity;
	// sets needed variables as private

	public Item(int id, double price, int quantity) {
		// initializes a new Item object
		this.id = id;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() { // id getter
		return id;
	}

	public void setId(int id) { // id setter
		this.id = id;
	}

	public double getPrice() { // price getter
		return price;
	}

	public void setPrice(double price) { // price setter
		this.price = price;
	}

	public int getQuantity() { // quantity getter
		return quantity;
	}

	public void setQuantity(int paramQuantity) { // quantity setter
		this.quantity = paramQuantity;
	}

	public String toString() { // returns a string with detailed item information that pertains to that
								// specific item
		String item_desc = "Item Id: " + String.valueOf(id) + ", Cost: $" + String.valueOf(price)
				+ " has been added to your Shopping Cart with Quantity " + String.valueOf(quantity);
		return item_desc;
	}
}
