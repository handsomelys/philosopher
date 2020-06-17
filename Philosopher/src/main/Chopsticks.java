package main;

/**
 * @author handsomelys
 *
 */
/*
 * class of chopsticks
 */
public class Chopsticks {
	private boolean avilable;
	private Philosopher taker;
	private Philosopher owner;
	private Dining_Table table;
	public Chopsticks() {
		avilable = true;
	}
	
	/*
	 *  equal to operation of wait Chopstick
	 */
	public synchronized void take(Philosopher taker) {
		this.setTaker(taker);
		while(!avilable) {
			try {
				taker.setStatus(2);
				wait();
			}	catch(InterruptedException e) {
				
			}
		}
		avilable = false;
		this.setOwner(taker);
		table.repaint();
	}
	
	/*
	 * equal to operation of signal Chopstick
	 */
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
