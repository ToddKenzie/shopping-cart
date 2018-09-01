import java.util.ArrayList;

public class Cart {

	ArrayList<Item> shoppingCart = new ArrayList<>();
	
	public void addItemToCart(Item itemName) {
		shoppingCart.add(itemName);
		
	}

	public String checkItemsInCart() {
		String itemsInCart = "";
		for (Item item : shoppingCart) {
			itemsInCart += item.toString();
		}
		return itemsInCart;
	}

	public double checkPriceOfCart() {
		double priceTotal = 0.0;
		for (Item item : shoppingCart) {
			priceTotal += (item.getPrice() * item.getQuantity());
		}
		return priceTotal;
	}

	public void removeItemFromCart(String itemName) {
		for(int i = shoppingCart.size() - 1; i >= 0; i--) {
			Item item = shoppingCart.get(i);
			if (itemName.equals(item.getItemName())) {
				shoppingCart.remove(i);
			}
		}
	}

}
