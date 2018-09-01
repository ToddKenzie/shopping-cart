
public class Item {
	
	private String itemName;
	private int quantity;
	private double price;
	
	
	
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
		return "ItemName: " + itemName + "\tPrice: " + price +  "\tQuantity: " + quantity + "\n";
	}


}
