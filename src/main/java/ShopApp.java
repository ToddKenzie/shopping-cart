import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ShopApp {

	public static void main(String[] args) {
		shopping();
	}

	private static Scanner input = new Scanner(System.in);
	private static Cart usersCart = new Cart();
	private static NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);

	public static void shopping() {
		System.out.println("Welcome to Nozama!");
		continueShopping();
		System.out.println("Thank you for shopping today.\nPlease pay " 
		+ currency.format(usersCart.checkPriceOfCart()) + " at checkout.");
	}
	
	public static void continueShopping() {
		boolean wantsToCheckout = false;
		do {
			System.out.println(displayCart());
			System.out.print("Would you like to continue shopping? (Y/N)  ");
			wantsToCheckout = checkToContinueShopping();
		} while (!wantsToCheckout);
	}
	
	public static boolean checkToContinueShopping() {
		String userEnteredToContinueShopping = input.nextLine();
		if (userEnteredToContinueShopping.equalsIgnoreCase("y")) {
			modifyCart();
		} else if (userEnteredToContinueShopping.equalsIgnoreCase("n")) {
			return true;
		} else {
			System.out.println("Invalid response. Please enter Y or N");
		}
		return false;
	}

	public static String displayCart() {
		String itemsInCart = "Current Cart\n" + usersCart.checkItemsInCart();
		if (itemsInCart.equals("Current Cart\n")) {
			return itemsInCart + "Your cart is currently empty.\n";
		} else {
			itemsInCart += "Total price " + currency.format(usersCart.checkPriceOfCart()) + "\n";
			return itemsInCart;
		}
	}

	public static void modifyCart() {
		System.out.print("\nEnter \"add\" to add an item to the cart\nor \"remove\" to remove an item: ");
		String userEnteredToModifyCart = input.nextLine();
		if (userEnteredToModifyCart.equalsIgnoreCase("add")) {
			addingItemToCart();
		} else if (userEnteredToModifyCart.equalsIgnoreCase("remove")) {
			deletingItemFromCart();
		} else {
			System.out.println("Unknown reponse.  Returning to main menu.");
		}
	}

	public static void addingItemToCart() {
		System.out.print("Enter the name of the item: ");
		String itemName = input.nextLine();
		double itemPrice = promptUserforUnitPrice();
		int itemQuantity = promptUserforQuantity();
		usersCart.addItemToCart(itemName, itemPrice, itemQuantity);

	}

	public static double promptUserforUnitPrice() {
		boolean parseIntoDouble = true;
		String prompt = "Enter the unit price: ";
		return Double.parseDouble(checkIfUserInputCanParse(prompt, parseIntoDouble));
	}

	public static int promptUserforQuantity() {
		boolean parseIntoDouble = false;
		String prompt = "Enter the quantity to purchase: ";
		return Integer.parseInt(checkIfUserInputCanParse(prompt, parseIntoDouble));
	}

	public static String checkIfUserInputCanParse(String prompt, boolean parseIntoDouble) {
		String userInput = "";
		boolean isInvalid = true;
		do {
			System.out.print(prompt);
			userInput = input.nextLine();
			try {
				if (parseIntoDouble) {
					Double.parseDouble(userInput);
				} else {
					Integer.parseInt(userInput);
				}
				isInvalid = false;
			} catch (Exception ex) {
				System.out.println("Invalid entry.");
			}
		} while (isInvalid);
		return userInput;
	}
	
	public static void deletingItemFromCart() {
		System.out.print("What would you like to remove from the cart? ");
		String itemToRemove = input.nextLine();
		usersCart.removeItemFromCart(itemToRemove);
		System.out.println(itemToRemove + " removed.");
	}

}
