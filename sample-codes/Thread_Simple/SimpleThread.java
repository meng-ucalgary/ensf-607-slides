package simpleTheads1;

public class SimpleThread extends Thread{
	
	private long sleepTime;
	
	public SimpleThread (String name, long sleepTime) {
		super(name);
		setSleepTime (sleepTime);
		System.out.println(getName() + "Sleep: " + getSleepTime());
	}
	@Override
	public void run () {
		for (int i = 0; i < 5; i++) {
			try {
				sleep(getSleepTime());
				System.out.println (getName () + " is started!");
			}catch (InterruptedException e) {
				System.err.println(e.toString());
			}
		}
		System.out.println (getName () + " is running!");
	}
	public long getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}

}
