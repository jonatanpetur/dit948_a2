import static dit948.SimpleIO.*;
/**
 *  Class representing a shopping cart application for the
 *  second assignment in DIT948, 2015 edition.
 *  This is the main class for the application, interacting
 *  with the customer, adding to the cart different product to 
 *  be purchased and finally calculating the total amount to be payed
 */

public class Main {
	
	/**
	 *  Allows a shopkeeper to enter the details for a product
	 *  to be purchased by a customer 
	 *  @param cart the shopping cart of a given customer
	 */
	 public static void askCustomer(Cart cart){
		 // Code to read from console the product name, seller,
		 // price, number of products, discount and 
		 // if Buy2Take 3 applies. 			
		 print("Product name : ");
		 String name = readLine();
		 		 
		 print("Seller : ");
		 String seller = readLine();
		 
		 print("Price : ");
		 double price = readDouble();
		 
		 print("How many : ");
		 int quantity = readInt();
		 
		 print("Discount (enter 0 if no discount applies) : ");
		 double discountPercentage = readDouble();
		 
		 char b2t3Answer;
		 
		 boolean b2t3 = false;
		 boolean cont = false;
		 
		 while(!cont)
		 {
			 print("Does Buy2Take3 apply? (y/N) : ");
			 
			 b2t3Answer = readChar();
			 if (Character.toLowerCase(b2t3Answer) == 'y')
			 {
				 b2t3 = true;
				 cont = true;
			 }
			 else if (Character.toLowerCase(b2t3Answer) == 'n')
			 {
				 b2t3 = false;
				 cont = true;
			 }
			 else if (b2t3Answer == '\r')
			 {
				 println("Assuming no");
				 cont = true;
			 }
			 else
			 {
				 println("Try again please.");
			 }
		 }
		 
		 Product product = new Product(seller, name, price);
		 
		 if(discountPercentage != 0)
		 {
			 try
			 {
				 product = new DiscountedProduct(product, discountPercentage);
			 }
			 catch(InvalidArgumentException e)
			 {
				 println("\nError encountered while discounting product");
				 println(e.getMessage());
				 System.exit(-1);
			 }
		 }

		 if(b2t3)
		 {
			 try
			 {
				 product = new Buy2Take3Product(product); 
			 }
			 catch(InvalidArgumentException e)
			 {
				 println("\nError encountered while applying buy 2 take 3 to product");
				 println(e.getMessage());
				 System.exit(-1);
			 }
		 }
		 
		 cart.addProduct(product, quantity);		 
	 }
	 
	// Main method to interact with a customer 
	public static void main(String[] args)
	{
		 //Implement the user interface here
		 // Ask the user to choose 0 (buy product) or 
		 // 1 (checkout), depending on  what they want to do
		 // See TestCases.txt for several examples

		 println("Welcome to DIT958 shop");
		 print("What's your name? ");
		 String customer = readLine();
		 println("Hi "+customer+". Please choose one of the following options:");
		 
		 Cart cart = new Cart();
		 boolean cont = false;
		 while(!cont)
		 {
			 println("");		 
			 println("Buy a product: 1");
			 println("Checkout: 0");
			 print(": ");
			 char answer = readString().charAt(0);
			 println("");
			 if(answer == '1')
			 {
				 askCustomer(cart);
			 }
			 else if(answer == '0')
			 {
				 cont = true;
			 }
			 else
			 {
				 println("Try again");
			 }
		 }
		 
		 println(cart);
		 
		 
	}
}
