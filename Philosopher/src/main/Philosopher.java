package main;
import java.util.Random;
import javax.swing.ImageIcon;


/**
 * @author handsomelys
 *
 */
public class Philosopher extends Thread implements Runnable{
	/*
	 * override some methods of Runnable for suspend && resume method
	 */

    /*
     * flag for thread's resume && suspend  
     */
    private volatile boolean suspended;  

    public void run() {
    	try {
    	suspended = false;
    	run_method();	
    	}	catch(InterruptedException e) {
    		System.out.println("interrupte while in run_method()");
    	}
    	
    }
    
    public void suspend_request() {
    	suspended = true;
    }
    
    public void resume_request() {
    	suspended = false;
    }
    
	private void wait_suspended()  throws InterruptedException{
		while(suspended) {
			Thread.sleep(800);
		}	
	}
	/*
	 *members of Philosopher
	 */
	private String name;
	public String status;
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
/*
 * Construction method of Philosopher
 */
	public Philosopher(int id_for_philosopher,Chopsticks left,Chopsticks right,Room room) {
		this.id_for_philosopher = id_for_philosopher;
		this.left = left;
		this.right = right;
		this.eating = new ImageIcon("./src/pictures/eating.png");
		this.thinking = new ImageIcon("./src/pictures/thinking.png");
		this.waiting = new ImageIcon("./src/pictures/waiting.png");
		this.init = new ImageIcon("./src/pictures/init.png");
		this.current = init;	
		this.setStatus(Philosopher.INIT);
		this.room = room;
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
/*
 * set a room which can only accommodate 4 philosophers to avoid deadlock  
 */
	public void run_method() throws InterruptedException{
		while(true) {
			wait_suspended();	//检测是否挂起线程
			
			think();	
			try {
				sleep((int)(rand.nextDouble()+0.1)*800);	//思考时长随机
			}	catch(InterruptedException e) {
				//e.printStackTrace();
			}
			room.wait_room();	//wait room信号量
			eat();
			try {
				sleep((int)(rand.nextDouble()+0.1)*800);	//吃饭时长随机
			}	catch(InterruptedException e) {
				//e.printStackTrace();
			}
			room.signal_room();	//signal room信号量
			wait_suspended();
		}
	}
	/*
	 * a series of setters && getters
	 */
	public String getpName() {
		return name;
	}

	public void setpName(String name) {
		this.name = name;
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
