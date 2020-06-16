package main;

public class Chopsticks {

	private boolean avilable;
	private Philosopher taker;
	private Philosopher owner;
	private Dining_Table table;
	public Chopsticks() {
		avilable = true;
	}
	
	public synchronized void take(Philosopher taker) {
		this.setTaker(taker);
		while(!avilable) {
			try {
				taker.setStatus(2);
				//System.out.println("philosopher "+ taker.getId_for_philosopher()+" is waiting");
				wait();
			}	catch(InterruptedException e) {
				
			}
		}
		avilable = false;
		this.setOwner(taker);
		table.repaint();
	}
	
	public synchronized void putdown() {
		avilable = true;
		this.setOwner(null);
		notifyAll();
		table.repaint();
	}

	public static int getChopsticksIndex(boolean[] array,boolean value) {
		for(int i=0;i<array.length;i++) {
			if(array[i]==value)
				return i;
		}
		return -1;
	}
	public Philosopher getTaker() {
		return taker;
	}

	public void setTaker(Philosopher taker) {
		this.taker = taker;
	}

	public Philosopher getOwner() {
		return owner;
	}

	public void setOwner(Philosopher owner) {
		this.owner = owner;
	}
	public int getOwner_ID() {
		return getOwner().getId_for_philosopher();
	}

	public Dining_Table getTable() {
		return table;
	}

	public void setTable(Dining_Table table) {
		this.table = table;
	}
}
