import java.util.Random;

class Shopper implements Runnable {
	private Shipping shipping;

	public Shopper(Shipping shipping) {
		this.shipping = shipping;
	}

	public void run() {
		while (true) {
			String item = null;
			
			try {
				item = shipping.get();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if (item.equals("NONE"))
				break;
			System.out.format("Item picked up by shopper: %s%n", item);
			try {
				Thread.sleep(new Random().nextInt(7000));
			} catch (InterruptedException e) {
			}
		}
	}
}
