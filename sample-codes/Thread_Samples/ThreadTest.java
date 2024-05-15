
public class ThreadTest {
	
	public static void main (String [] args) throws InterruptedException{
		
		System.out.println (Thread.currentThread().getName() + " Started!");
		
		long startTime = System.currentTimeMillis();
		Thread t0 = new Thread (new ItemList ());
		Thread t1 = new Thread (new ItemList ());
		
		t0.start();
		t1.start();
		System.out.println ("The number of active threads at Start: " + Thread.activeCount());
		while (t0.isAlive()) {
			
			System.out.println (Thread.currentThread().getName() + " is waiting!");
			
			t0.join(1000);
			
			if (((System.currentTimeMillis() - startTime) > 2000) && t0.isAlive()) {
				System.out.println (Thread.currentThread().getName() + " interrupting " 
						+ t0.getName());
				t0.interrupt();
				break;
			}
			
		}
		Thread.sleep(1000);
		
		System.out.println (Thread.currentThread().getName() + " Ends! ");
		
		System.out.println (t0.isAlive());
		System.out.println (t1.isAlive());
		System.out.println (Thread.currentThread().getName() + Thread.currentThread().isAlive());
		
		System.out.println ("The number of active threads at END: " + Thread.activeCount());
		
		
		
		
	}

}
