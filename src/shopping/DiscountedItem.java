package shopping;

/** James Palacios, jwp89, RUID 166-00-4545 **/

public class DiscountedItem extends Item{
	public static final double kidsToy = 0.1;
	public static final double mensClothing = 0.2;
	public static final double womensClothing = 0.3;
	private double discount;
	private double newPrice;
	private double saved;
	
	public DiscountedItem(int id, double price, int quantity) {
		super(id, price, quantity);
		setPrice(price);
		if(id > 0 && id < 25) {
			this.discount = kidsToy;
			newPrice =(Math.round((getPrice() - (price * discount)) * 100.0) / 100.0);
			saved = getPrice() - newPrice;
			setPrice(newPrice);
		}
		if(id > 24 && id < 50) {
			this.discount = mensClothing;
			newPrice = (Math.round((getPrice() - (price * discount)) * 100.0) / 100.0);
			saved = getPrice() - newPrice;
			setPrice(newPrice);
		}
		if(id > 49 && id <75) {
			this.discount = womensClothing;
			newPrice = (Math.round((getPrice() - (price * discount)) * 100.0) / 100.0);
			saved = getPrice() - newPrice;
			setPrice(newPrice);
		}
	}
	
	public double getDiscount (int id){
		if(id > 0 && id < 25) {
			return kidsToy;
		}
		if(id > 24 && id < 50) {
			return mensClothing;
		}
		if(id > 49 && id < 75) {
			return womensClothing;
		}
		return 0.0;
	}
	
	public void setDiscount (int id){
		
		if(id > 0 && id < 25) {
			this.discount = kidsToy;
		}
		if(id > 24 && id < 50) {
			this.discount = mensClothing;
		}
		if(id > 49 && id <75) {
			this.discount = womensClothing;
		}
	}
	
	public String toString() {
		return super.toString() + " (ON SALE!!! You saved: $" + (Math.round(saved * 100)) / 100.0 + ")";
	}
}
