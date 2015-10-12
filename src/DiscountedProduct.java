/**
 *  Subclass representing a  discounted product to be 
 *  purchased for the second assignment in DIT948, 2015 edition.
 *  It extends the <tt>Product<tt> class with two instance 
 *  variables
 */

public class DiscountedProduct extends Product {

	// Original product
	private final Product original;

	// Discount in percent (%)
	private final double discount;

	/**
	 * Construct a discounted product
	 * @param original
	 * @param discount
	 */
	public DiscountedProduct(Product original, double discount) throws InvalidArgumentException
	{
		// if the price can not be reduced you should print a message and
	    // terminate the program. Use "System.exit(0);" to terminate.
		
		super(original); 	
		if (!original.canBeReduced()) {
			throw new InvalidArgumentException("Product price cannot be reduced");
		}
		this.original = original;
		this.discount = discount;
	}
	
	/**
	 * Return false if the product price can not be
	 * reduced
	 * @return 
	 */
	public boolean canBeReduced() {
		// You can not discount the price of Discount product
		return false;
	}

	/**
	 * Return the price of this discounted product
	 * @param cart shopping cart
	 * @return discounted price 
	 */
	public double getPrice(Cart cart) {
		double originalPrice = original.getPrice(cart);
		return originalPrice - (originalPrice * discount/100);
	}
	
	/**
	 * Return the string representation of the product
	 * Example: CD [discounted 20 %] 
	 */
	public String toString() {
	     return original.getName() + " [discounted by " + discount +"%]";
	}
}
