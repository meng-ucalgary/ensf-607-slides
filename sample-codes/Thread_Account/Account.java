package thread.example.account;

public class Account implements Runnable{
	
	private double amount;
	
	public Account (double initDeposit) {
		setAmount (initDeposit);
		
	}
	synchronized public void withdraw (double withdrawAmount) {
		if (withdrawAmount <= amount) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			amount -= withdrawAmount;	
		}
	}
	public void deposit (double depositAmount) {
		amount += depositAmount;
	}
	
	public double balance () {
		return getAmount ();
	}

	private double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//We are simulating attempts/machines to withdraw
		
		for (int i = 0; i < 5; i++) {
			withdraw(100);
			System.out.println(balance());
		}
		
		System.err.println(balance());
		
		
	}

}
