import java.util.Random;

class Supplier implements Runnable {
	private Shipping shipping;

	public Supplier(Shipping shipping) {
		this.shipping = shipping;
	}

	public void run() {
		String itemList[] = { "IBM Laptop", "Samsung Galaxy S5", "Power Adapter", "Music CD" };
		for (int i = 0; i < itemList.length; i++) {
			try {
				shipping.set(itemList[i]);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.format("Item received from supplier: %s%n", itemList[i]);
			try {
				Thread.sleep(new Random().nextInt(7000));
			} catch (InterruptedException e) {
			}
		}
		try {
			shipping.set("NONE");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}