import java.text.NumberFormat;
import java.util.Locale;

public class Item {
	
	private String itemName;
	private int quantity;
	private double price;
	private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
	
	
	
	public String getItemName() {
		return itemName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Item(String itemName, double price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String toString() {
		return "Item: " + itemName + "\t\tPrice: " + currency.format(price) +  "\tQuantity: " + quantity + "\n";
	}


}
