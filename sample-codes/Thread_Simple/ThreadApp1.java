package simpleTheads1;

public class ThreadApp1 {
	
	public static void main (String [] args) {
		
		Thread t1 = new SimpleThread ("t1", 1000);
		Thread t2 = new SimpleThread ("t2", 1);
		Thread t3 = new SimpleThread ("t3", 1);
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Three threads t1, t2, and t3 have started: ");
	}

}
