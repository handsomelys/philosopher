package main;

public class Chopsticks {
	private boolean[] isUsed = {false,false,false,false,false};
	private String status;
	private boolean waiting = false;
	private int name;
	private int one;
	private	boolean[] whichWaiting = {false,false,false,false,false};
	public synchronized void waitChopsticks() {
		
		String name = Thread.currentThread().getName();
		int i = Integer.parseInt(name);
		this.setName(i);
		
		String temp;
		
		if(i%2==1) {
			//this.whichWaiting[i]=true;
			while(true)	{
				if(isUsed[i]) {

				}
				else if(!isUsed[i]) {
					if(isUsed[(i+1)%5]) {

					}
				else if(!isUsed[(i+1)%5]) {
						break;
					}
				}
				try {
					temp = i+"is waiting\n"+"\n";
					this.setStatus(temp);
					this.setWaiting(true);
					this.whichWaiting[i]=true;
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			isUsed[i] = true;
			isUsed[(i+1)%5] = true;

			this.whichWaiting[i]=false;
			this.setWaiting(false);
		}
		else {

			while (true){
				if(isUsed[(i+1)%5]) {

				}
			else if(!isUsed[(i+1)%5]) {
				if(isUsed[i]) {

				}
			else if(!isUsed[i])
						break;
				}
				try {
					this.whichWaiting[i]=true;
					this.setWaiting(true);
					temp = i+" is waiting\n"+"\n";
					this.setStatus(temp);
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			isUsed[(i+1)%5] = true;
			isUsed[i] = true;
			this.setWaiting(false);
			this.whichWaiting[i]=false;
			
		}
	}

	public synchronized void signalChopsticks() {
		String name = Thread.currentThread().getName();
		int i = Integer.parseInt(name);
		isUsed[i] = false;
		isUsed[(i+1)%5] = false;
		notifyAll();
	}
	public boolean[] getIsUsed() {
		return isUsed;
	}
	public static int getChopsticksIndex(boolean[] array,boolean value) {
		for(int i=0;i<array.length;i++) {
			if(array[i]==value)
				return i;
		}
		return -1;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isWaiting() {
		return waiting;
	}
	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getOne() {
		return one;
	}
	public void setOne(int which) {
		this.one = which;
	}
	public int whichIsWating() {
		while(true) {
			System.out.println(this.getName());
			System.out.println(this.isWaiting());
			if(this.getName()==0&&this.isWaiting()) {
				return 1;
			}
			if(this.getName()==1&&this.isWaiting()) {
				return 2;
			}
			if(this.getName()==2&&this.isWaiting()) {
				return 3;
			}
			if(this.getName()==3&&this.isWaiting()) {
				return 4;
			}
			if(this.getName()==4&&this.isWaiting()) {
				return 5;
			}
		}
	}

	public boolean[] getWhichWaiting() {
		return whichWaiting;
	}

	public void setWhichWaiting(boolean[] whichWaiting) {
		this.whichWaiting = whichWaiting;
	}
}
