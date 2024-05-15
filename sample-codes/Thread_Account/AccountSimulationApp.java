package thread.example.account;

public class AccountSimulationApp {
	
	public static void main (String [] args) {
		Account myAccount = new Account (200);
		
		Thread t1 = new Thread (myAccount);
		Thread t2 = new Thread (myAccount);
		Thread t3 = new Thread (myAccount);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}
