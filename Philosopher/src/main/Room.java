/** 
 * @Title: Room.java 
 * @Package main 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com 
 * @date 2020年6月16日 上午11:24:27 
 * @version V1.0 
 */  
package main;

/**
 * @author dell
 *
 */
public class Room {
	private static int MAX_NUMBER_IN_PEOPLE = 4;
	
	public synchronized void wait_room() {
		//System.out.println(MAX_NUMBER_IN_PEOPLE);
		while(MAX_NUMBER_IN_PEOPLE==0) {
			try {
				wait();
				System.out.println("room is full!");
			}	catch(InterruptedException e) {
			}
		}
		MAX_NUMBER_IN_PEOPLE--;
	}
	
	public synchronized void signal_room() {
		MAX_NUMBER_IN_PEOPLE++;
		notifyAll();
	}
}
