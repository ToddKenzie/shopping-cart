import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CartTest {
	Cart underTest = new Cart();
	Item shirts = new Item("shirt", 10.0, 1);
	Item shoes = new Item("shoes", 25.5, 3);
	final static double delta = 0.0000001;
	
	
	@Test
	public void assertShirtisAddedToCart() {
		underTest.addItemToCart(shirts);
		underTest.addItemToCart(shoes);
		String itemsInCart = underTest.checkItemsInCart();
		assertTrue(itemsInCart.contains("shirt"));
	}
	
	@Test
	public void assertShoesisAddedToCart() {
		underTest.addItemToCart(shirts);
		underTest.addItemToCart(shoes);
		String itemsInCart = underTest.checkItemsInCart();
		assertTrue(itemsInCart.contains("shoes"));
	}
	
	@Test
	public void assertPriceOfCartIs86a5() {
		underTest.addItemToCart(shirts);
		underTest.addItemToCart(shoes);
		double priceTotal = underTest.checkPriceOfCart();
		assertEquals(86.5, priceTotal, delta);
	}
	
	@Test
	public void assertPriceOfCartIs76a5() {
		underTest.addItemToCart(shoes);
		double priceTotal = underTest.checkPriceOfCart();
		assertEquals(76.5, priceTotal, delta);
	}
	
	@Test
	public void assertPriceOfCartIs20() {
		underTest.addItemToCart(shirts);
		underTest.addItemToCart(shirts);
		double priceTotal = underTest.checkPriceOfCart();
		assertEquals(20.0, priceTotal, delta);
	}
	
	@Test
	public void assertRemovalOfShirtFromCart() {
		underTest.addItemToCart(shirts);
		underTest.addItemToCart(shoes);
		underTest.removeItemFromCart("shirt");
		String itemsInCart = underTest.checkItemsInCart();
		assertFalse(itemsInCart.contains("shirt"));
	}
	
	@Test
	public void assertRemovalOfShoesFromCart() {
		underTest.addItemToCart(shirts);
		underTest.addItemToCart(shoes);
		underTest.removeItemFromCart("shoes");
		String itemsInCart = underTest.checkItemsInCart();
		assertFalse(itemsInCart.contains("shoes"));
	}
	
	
}


//	@Test
//	public void assertQuantityOfShirtIsOne() {
//		underTest.addItemToCart(shirts);
//		underTest.addItemToCart(shoes);
//		int shirtQuantity = underTest.checkQuantity("shirt");
//		assertEquals(1, shirtQuantity);
//	}
//
//	@Test
//	public void assertQuantityOfShirtIsTwo() {
//		underTest.addItemToCart(shirts);
//		underTest.addItemToCart(shirts);
//		int shirtQuantity = underTest.checkQuantity("shirt");
//		assertEquals(2, shirtQuantity);
//	}
//	@Test
//	public void assertQuantityOfJeansIs0() {
//		underTest.addItemToCart(shirts);
//		underTest.addItemToCart(shirts);
//		int shirtQuantity = underTest.checkQuantity("jeans");
//		assertEquals(0, shirtQuantity);
//	}
//	