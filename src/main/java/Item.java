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
		String tabsName = "";
		int itemNameLength = itemName.length();
		for (int i = 24; i > 0; i -= 8) {
			if (itemNameLength <= i) {
				tabsName += "\t";
			}
		}
		String tabsPrice = "\t";
		if (price < 1000) {
			tabsPrice += "\t";
		}
		return "Item:  " + itemName + tabsName +"Price: " + currency.format(price) + tabsPrice + "Quantity: " + quantity + "\n";
	}


}
