public class ShopApp {
	public static void main(String[] args) throws InterruptedException {
		Shipping shipping = new Shipping();
		Supplier sup = new Supplier(shipping);
		Thread t1 = new Thread(sup);
		Shopper sh = new Shopper(shipping);
		Thread t2 = new Thread(sh);
		t1.start();
		t2.start();
	}
}