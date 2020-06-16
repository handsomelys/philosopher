package main;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
public class Philosopher extends Thread {
	private String name;
	private int speed;
	private int number;
	public String status;
	public JTextArea jta;

	public static final int EATING = 0;	//吃饭的表情
	public static final int THINKING = 1;	//思考的表情
	public static final int WAITING = 2;	//等待阻塞的表情
	public static final int INIT = 3;	//初始表情
	private Chopsticks left,right;	//分左右筷子 方便到时做GUI
	private int id_for_philosopher;	//第几号哲学家
	private ImageIcon eating,thinking,waiting,init;	//各个状态的表情
	private ImageIcon current;	//记录当前的表情
	private Random rand = new Random();	//随机数 吃饭和思考的时候用到
	private int code;
	private Room room;

	public Philosopher(int id_for_philosopher,Chopsticks left,Chopsticks right,Room room) {
		this.id_for_philosopher = id_for_philosopher;
		this.left = left;
		this.right = right;
		eating = new ImageIcon("./src/pictures/eating.png");
		thinking = new ImageIcon("./src/pictures/thinking.png");
		waiting = new ImageIcon("./src/pictures/waiting.png");
		init = new ImageIcon("./src/pictures/init.png");
		current = init;	
		setStatus(Philosopher.INIT);
		this.room = room;
		this.speed = speed;
	}
	
	public void eat() {
			left.take(Philosopher.this);
			right.take(Philosopher.this);
			setStatus(Philosopher.EATING);
			//System.out.println("philosopher "+this.id_for_philosopher + " is eating");
	}
	
	public void think() {
		left.putdown();
		right.putdown();
		setStatus(THINKING);
		//System.out.println("philosopher "+this.id_for_philosopher + " is thinking");
	}
	/** 
	 * @Title: setStatus 
	 * @Description: TODO 
	 * @param @param thinking2
	 * @return void
	 * @throws 
	 */  
	
	public void setStatus(int status_code) {
		if(status_code == EATING) {
			current = eating;
			code = EATING;
		}
		else if(status_code == THINKING) {
			current = thinking;
			code = THINKING;
		}
		else if(status_code == WAITING) {
			current = waiting;
			code = WAITING;
		}
		else if(status_code == INIT) {
			current = init;
			code = INIT;
		}
	}
	@Override
	public void run() {
		while(true) {
			think();	//思考
			try {
				sleep((int)(rand.nextDouble()+0.5)*2000);	//思考的时间是随机的
			}	catch(InterruptedException e) {
				e.printStackTrace();
			}
			room.wait_room();
			eat();
			try {
				sleep((int)(rand.nextDouble()+0.5)*3000);
			}	catch(InterruptedException e) {
				e.printStackTrace();
			}
			room.signal_room();
		}
	}
	
	public String getpName() {
		return name;
	}

	public void setpName(String name) {
		this.name = name;
	}

	public JTextArea getJta() {
		return jta;
	}

	public void setJta(JTextArea jta) {
		this.jta = jta;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public ImageIcon getCurrent() {
		return current;
	}

	public int getId_for_philosopher() {
		return id_for_philosopher;
	}

	public void setId_for_philosopher(int id_for_philosopher) {
		this.id_for_philosopher = id_for_philosopher;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
