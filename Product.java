public class Product {
private int id;
private String name;
private double price;
private String description;
private int nReviews;
private int rating;
private String shoppingDate;
  
	public Product()
	{
		this.id = 0;
		this.name = "";
		this.price = 0.0;
		this.description = "";
		this.nReviews = 0;
		this.rating = 0;
		this.shoppingDate = "";
	}

	public Product(int id, String name, double price, String description, int nReviews,
			int rating, String shoppingDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.nReviews = nReviews;
		this.rating = rating;
		this.shoppingDate = shoppingDate;
	}

public int getId() {
return id;
}

public String getName() {
return name;
}

public double getPrice() {
return price;
}

public String getDescription() {
return description;
}

public int getnReviews() {
return nReviews;
}

public int getRating() {
return rating;
}

public String getShoppingDate() {
return shoppingDate;
}
  
@Override
public String toString()
	{
		return(String.format("%-5d %-30s $%-10.2f %-50s %-10d %-10d %-1s", getId(), getName(), getPrice(),
				getDescription(), getnReviews(), getRating(), getShoppingDate()));
	}
}
