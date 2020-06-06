
import java.util.Scanner;

public class StoreMain {
  
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	AmazonStore store = new AmazonStore();
	int choice;
	  
	do
		{
		displayMenu();
		choice = Integer.parseInt(sc.nextLine().trim());
		switch(choice)
			{
			case 1:
				{	
					System.out.println("\nDISPLAY ALL STORED PRODUCTS:\n"
							+ "----------------------------");
					store.displayProductList();
					break;
				}
  
			case 2:
			{
				System.out.println("\nDISPLAY FIRST PRODUCT BY NAME OR ID:\n"
						+ "------------------------------------");
				store.displayFirstProductByNameOrID();
				break;
			}
  
			case 3:
			{
				System.out.println("\nDISPLAY NUMBER OF STORED PRODUCTS:\n"
						+ "----------------------------------");
				System.out.println("Number of products = " + store.getNumberOfProducts() + "\n");
				break;
			}
  
			case 4:
			{
				System.out.println("\nADD A PRODUCT:\n"
						+ "--------------");
				store.addProduct();
				break;
			}
  
			case 5:
			{
				System.out.print("Enter sub category: ");
				char subChoice = Character.toLowerCase(sc.nextLine().trim().charAt(0));
				switch(subChoice)
				{
				case 'a':
				{
					System.out.println("\nSORT PRODUCTS BY NAME:\n"
							+ "----------------------");
					store.sortByProductName();
					break;
				}
				case 'b':
				{
					System.out.println("\nSORT PRODUCTS BY PRICE:\n"
							+ "-----------------------");
					store.sortByProductPrice();
					break;
				}
				case 'c':
				{
					System.out.println("\nSORT PRODUCTS BY NUMBER OF REVIEWS:\n"
							+ "-----------------------------------");
					store.sortByProductReviews();
					break;
				}
				case 'd':
				{
					System.out.println("\nSORT PRODUCTS BY RATING:\n"
							+ "------------------------");
					store.sortByProductRating();
					break;
				}
				case 'e':
				{
					System.out.println("\nSORT PRODUCTS BY DESCRIPTION LENGTH:\n"
							+ "------------------------------------");
					store.sortByProductDescription();
					break;	
				}
				default:	
					System.out.println("Invalid subcategory for product sorting!\n");
				}
				break;
			}
			
			case 6:
			{
				System.out.println("\nDELETE PRODUCT BY NAME OR ID:\n"
						+ "-----------------------------");
				store.deleteProductByNameOrID();
				break;
			}
			
			case 7:
			{
				System.out.println("\nDELETE ALL PRODUCTS:\n"
						+ "--------------------");
				store.deleteAllProducts();
				break;
			}
			
			case 0:
			{
				System.out.println("\nThank you for visiting us..Goodbye!\n");
				System.exit(0);
			}
			default:
				System.out.println("\nInvalid choice!\n");
			}
		}while(choice != 0);
	}
  
private static void displayMenu()
	{
	System.out.print("Choose from the following options:\n"
			+ "1. Display all stored products\n"
			+ "2. Display first product based on product name or product id\n"
			+ "3. Display number of stored products\n"
			+ "4. Add a product\n"
			+ "5. Sort products by:\n"
			+ "\ta. Product name\n"
			+ "\tb. Product price\n"
			+ "\tc. Number of reviews\n"
			+ "\td. Rating of the product\n"
			+ "\te. Size of product description\n"
			+ "6. Delete a product by name or id\n"
			+ "7. Delete all products\n"
			+ "0. Exit\n"
			+ "Your selection >> ");
}
}