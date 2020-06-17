/** 
 * @Title: Room.java 
 * @Package main 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com 
 * @date 2020年6月16日 上午11:24:27 
 * @version V1.0 
 */  
package main;

import javax.swing.JLabel;

/**
 * @author handsomelys
 *
 */

/*
 * this class is used to avoid deadlock
 */
public class Room {
	private static int MAX_NUMBER_IN_PEOPLE = 4;
	private JLabel label;
	public synchronized void wait_room() {
		if(MAX_NUMBER_IN_PEOPLE!=0)
		label.setText("room still has "+ MAX_NUMBER_IN_PEOPLE + "sets.");
		while(MAX_NUMBER_IN_PEOPLE==0) {
			try {
				wait();
				label.setText("room is full!");
			}	catch(InterruptedException e) {
			}
		}
		MAX_NUMBER_IN_PEOPLE--;
	}
	
	public synchronized void signal_room() {
		MAX_NUMBER_IN_PEOPLE++;
		notifyAll();
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}


}
