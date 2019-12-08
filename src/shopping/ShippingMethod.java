package shopping;

/** James Palacios, jwp89, RUID 166-00-4545 **/

public interface ShippingMethod {
	public int expectedDuration();
	public double price();
}

class RegularShipping implements ShippingMethod{
	public int expectedDuration() {
		return 8;
	}
	public double price() {
		return 5.0;
	}
}

class ExpeditedShipping implements ShippingMethod{
	public int expectedDuration() {
		return 3;
	}
	public double price() {
		return 20.0;
	}
}