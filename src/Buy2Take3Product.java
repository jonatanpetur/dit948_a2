

/**
 *  Subclass representing a  product to be  purchased 
 *  (using the formula "buy 2 take 3") for the second 
 *  assignment in DIT948, 2015 edition.
 *  It extends the <tt>Product<tt> class with one instance 
 *  variable
 */

public class Buy2Take3Product extends Product {

	//original product
	private final Product original;

	/**
	 * Construct a Buy2Take3 product
	 * If the price of this product can not be reduced
	 * you should print a message to the user and terminate the 
	 * program
	 * @param original
	 * @throws InvalidArgumentException 
	 */
	public Buy2Take3Product(Product original) throws InvalidArgumentException{
		// if the price can not be reduced you should print a message and
		// terminate the program. Use "System.exit(0);" to terminate. 
		super(original);
		
		if(original instanceof DiscountedProduct)
		{
			throw new InvalidArgumentException("A buy 2 take 3 product cannot also be discounted");
		}
		
		this.original = original;
	}

	/**
	 * Return false if the product price can not be
	 * reduced
	 * @return 
	 */
	public boolean canBeReduced() {
		// You can not discount the price of Buy2Take3 product
		return false;
	}

	/**
	 * Return the unit price of a product using the
	 * formula "Buy2Take3"
	 * @param cart shopping cart
	 * @return unit price 
	 */
	public double getPrice(Cart cart) {

		// calculate unit price of this product purchased
		// as Buy2Take3
		int countSame = 0;
		
		for(Product product : cart.getProducts())
		{
			if(this == product)
			{
				countSame++;
			}
		}
		
		double b2t3discount = (int)(countSame/3) * (original.getPrice(cart) / countSame); 
		
		return original.getPrice(cart) - b2t3discount;
	}
	
	public boolean equals(Object obj)
	{
		Buy2Take3Product product;
		if(obj instanceof Buy2Take3Product)
		{
			product = (Buy2Take3Product)obj;
		}
		else
		{
			return false;
		}
		
		return this.original.equals(product.original); 
	}
	
	public String toString() {
		return original.getName() + " [Buy two take three]";
	}
}
