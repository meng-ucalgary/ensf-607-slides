
public class ItemList implements Runnable{
	
	String items [] = {"Milk", "Bread", "Chips", "Apples", "Oranges"};
	
	public void run () {
		try {
			for (int i = 0; i < items.length; i++) {
				Thread.sleep(1000);
				System.out.println (Thread.currentThread().getName() +  items[i]);
			}
			
		}catch (InterruptedException e) {
			System.err.println(Thread.currentThread().getName() +  " is intruptted!");
		}
	}
	

}
