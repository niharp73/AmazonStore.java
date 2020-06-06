import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AmazonStore {
private ArrayList<Product> products;
  
public AmazonStore()
	{
		this.products = new ArrayList<>();
	}
  
public int getNumberOfProducts(){ return this.products.size(); }
  
public void displayProductList()
	{
		if(products.isEmpty())
		{
			System.out.println("List is empty!\n");
			return;
		}
		System.out.printf("%-5s %-30s %-10s %-50s %-10s %-10s %-1s\n", "ID", "NAME", "PRICE",
				"DESCRIPTION", "REVIEWS", "RATING", "POSSIBLE SHOPPING DATE");
		for(Product p : products)
		System.out.println(p);
		System.out.println();
	}
  
private int getIndexOfById(ArrayList<Product> prods, int id)
	{
		int index = -1;
		for(int i = 0; i < prods.size(); i++)
		{
			if(prods.get(i).getId() == id)
			{
				index = i;
				break;
			}
		}
		return index;
	}
  
private int getIndexOfByName(ArrayList<Product> prods, String name)
	{
		int index = -1;
		for(int i = 0; i < prods.size(); i++)
		{
			if(prods.get(i).getName().equalsIgnoreCase(name))
			{
				index = i;
				break;
			}
		}
		return index;
	}
  
public void displayFirstProductByNameOrID()
	{
	if(products.isEmpty())
		{
		System.out.println("List is empty!\n");
		return;
		}
	Scanner sc = new Scanner(System.in);
	System.out.print("Search product by - N for product name\tI for product ID: ");
	char inp = Character.toLowerCase(sc.nextLine().trim().charAt(0));
	while(inp != 'n' && inp != 'i')
	{
		System.out.print("Search product by - N for name\tI for product id: ");
		inp = Character.toLowerCase(sc.nextLine().trim().charAt(0));
	}
	if(inp == 'n')
	{
		System.out.print("Enter the product name: ");
		String name = sc.nextLine().trim();
		int index = getIndexOfByName(products, name);
		if(index == -1)
			System.out.println("Sorry, no products matching name " + name + " were found!\n");
		else
			System.out.println("Match found:\n" + products.get(index));
	}
	else
	{
		System.out.print("Enter the product id: ");
		int id = Integer.parseInt(sc.nextLine().trim());
		int index = getIndexOfById(products, id);
		if(index == -1)
			System.out.println("Sorry, no products matching ID " + id + " were found!\n");
		else
			System.out.println("Match found:\n" + products.get(index));
	}	
}
  
public void addProduct()
	{
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the product ID: ");
	int id = Integer.parseInt(sc.nextLine().trim());
  
	// search if the product exists, if exists, do not add, else add it
	int index = getIndexOfById(products, id);
  
	if(index != -1)
	{
		// 	product present
		System.out.println("A similar product is already present with the same ID!\n");
		return;
	}
	// product not present
	System.out.print("Enter product name: ");
	String name = sc.nextLine().trim();
	System.out.print("Enter product price: $");
	double price = Double.parseDouble(sc.nextLine().trim());
	System.out.print("Enter product description: ");
	String description = sc.nextLine().trim();
	System.out.print("Enter number of reviews for the product: ");
	int nReviews = Integer.parseInt(sc.nextLine().trim());
	System.out.print("Enter rating for the product: ");
	int rating = Integer.parseInt(sc.nextLine().trim());
	System.out.print("Enter possible shopping date for the product: ");
	String shoppingDate = sc.nextLine().trim();
	products.add(new Product(id, name, price, description, nReviews, rating, shoppingDate));
	System.out.println(id + " was successfully added to the store.\n");
}
  
public void sortByProductName()
	{
		Collections.sort(products, new CompareByName());
		displayProductList();
	}
  
public void sortByProductPrice()
	{
		Collections.sort(products, new CompareByPrice());
		displayProductList();
	}
  
public void sortByProductReviews()
	{
		Collections.sort(products, new CompareByReviews());
		displayProductList();
	}
  
public void sortByProductRating()
	{
		Collections.sort(products, new CompareByRating());
		displayProductList();
	}
  
public void sortByProductDescription()
	{
		Collections.sort(products, new CompareByDescriptionLength());
		displayProductList();
	}
  
public void deleteProductByNameOrID()
	{
	if(products.isEmpty())
		{
		System.out.println("List is empty!\n");
		return;
		}
	Scanner sc = new Scanner(System.in);
	System.out.print("Delete product by - N for product name\tI for product ID: ");
	char inp = Character.toLowerCase(sc.nextLine().trim().charAt(0));
	while(inp != 'n' && inp != 'i')
		{
		System.out.print("Search product by - N for name\tI for product id: ");
		inp = Character.toLowerCase(sc.nextLine().trim().charAt(0));
		}
	if(inp == 'n')
		{
		System.out.print("Enter the product name: ");
		String name = sc.nextLine().trim();
		int index = getIndexOfByName(products, name);
		if(index == -1)
			System.out.println("Sorry, no products matching name " + name + " were found!\n");
		else
		{
			products.remove(index);
			System.out.println(name + " was deleted successfully.\n");
		}
		}
	else
	{
		System.out.print("Enter the product id: ");
		int id = Integer.parseInt(sc.nextLine().trim());
		int index = getIndexOfById(products, id);
		if(index == -1)
			System.out.println("Sorry, no products matching ID " + id + " were found!\n");
		else
		{
			products.remove(index);
			System.out.println(id + " was deleted successfully.\n");
		}
	}
}
  
public void deleteAllProducts()
	{
	if(products.isEmpty())
		{	
		System.out.println("List is empty!\n");
		return;
		}
	products.removeAll(products);
	System.out.println("Store is successfully cleared.\n");
	}
  
// COMPARATOR CLASSES
class CompareByName implements Comparator<Product>
	{
@Override
		public int compare(Product p1, Product p2) {
		if(p1.getName().compareTo(p2.getName()) < 0)
			return -1;
		else if(p1.getName().compareTo(p2.getName()) == 0)
			return 0;
		else
			return 1;
		}	
	}
  
class CompareByPrice implements Comparator<Product>
	{
@Override
	public int compare(Product p1, Product p2) {
		if(p1.getPrice() < p2.getPrice())
			return -1;
		else if(p1.getPrice() == p2.getPrice())
			return 0;
		else
			return 1;
		}
	}
  
class CompareByReviews implements Comparator<Product>
	{
@Override
	public int compare(Product p1, Product p2) {
		if(p1.getnReviews()< p2.getnReviews())
			return -1;
		else if(p1.getnReviews()== p2.getnReviews())
			return 0;
		else	
			return 1;
		}	
	}
  
class CompareByRating implements Comparator<Product>
	{
@Override
	public int compare(Product p1, Product p2) {
	if(p1.getRating()< p2.getRating())
		return -1;
	else if(p1.getRating()== p2.getRating())
		return 0;
	else	
		return 1;
		}
	}
  
class CompareByDescriptionLength implements Comparator<Product>
	{
@Override
	public int compare(Product p1, Product p2) {
		if(p1.getDescription().compareTo(p2.getDescription()) < 0)
			return -1;
		else if(p1.getDescription().compareTo(p2.getDescription()) == 0)
			return 0;
		else
			return 1;
		}
	}
}

