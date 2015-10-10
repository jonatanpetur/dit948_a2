/**
 *  Class representing a shopping cart for the
 *  second assignment in DIT948, 2015 edition.
 */

public class Cart  {

	// array of products (max 100 products)
	private final Product[] products = new Product[100];

	//position of the first free cell to add a product
	private int position = 0;
	
	/**
	 * Return the list of products
	 * @return
	 */
	public Product[] getProducts(){
	     return products;
	}
	
	/**
	 * Add a product to the list
	 * @param product
	 */
	public void addProduct(Product product) {
		products[position] = product;
 	   	position++;
	}

	/**
	 * Add an array of products to the list
	 * @param products
	 */
	public void addProducts(Product[] products) {
		for(Product product : products)
	    {	    				
			addProduct(product);
	    }
	}

	/**
	 * Adds a product several times
	 * @param product
	 * @param howManyTimes number of times to add product 
	 */
	public void addProduct(Product product, int howManyTimes) {
 	   	for(int i = 0; i < howManyTimes; i++)
		{
			addProduct(product);
		}
	}
	
	/**
	 * Calculate the total price
	 * @return
	 */
	public double totalPrice(){
		double price = 0;
		
		for(int i = 0; i < position; i++)
	    {
			price += products[i].getPrice(this);
		}
		
		return price;
	}

	/**
	 * String representation of products in a shopping 
	 * cart
	 * Example: 
	 * CD of Leonard Cohen 22.50 SEK. Sold by Javier
     * TV [discounted by 20.00%]    4000.00 SEK. Sold by Maria
	 */
	public String toString() {
		String result = "";
	    for (int i = 0; i < position; i++) {
	    	Product product = products[i];
	    	result += product.toString() + " " + String.format("%.2f", product.getPrice(this)) + " Sold by " + product.getSeller() + '\n';
		}	    
	    
	    result += "\nTotal: " + String.format("%.2f", this.totalPrice());
		
	    return result;
	}

}
