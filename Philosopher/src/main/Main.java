package main;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
@SuppressWarnings("serial")
public class Main extends JFrame{
	/*
	 * init a series of data structure
	 */
	private Chopsticks[] chopsticks = new Chopsticks[5];
	private Philosopher[] philosophers = new Philosopher[5];
	private Dining_Table table;		
	private JPanel main_panel;	
	/*
	 * buttons
	 */
	private JButton start = new JButton("start");
	private JButton suspend = new JButton("suspend");
	private JButton resume = new JButton("resume");
	private JButton end = new JButton("end");
	/*
	 * panel or button && description
	 */
	private JPanel button_panel = new JPanel();
	private JPanel describe_panel;
	/*
	 * serials pictures for program
	 */
	ImageIcon eating,thinking,waiting,init,room_pic;

	/*
	 *set param for Main Frame
	 */
	public void setFrameLocation() {
		this.setResizable(false);
		this.setSize(600,650);
		this.setTitle("Philosopher room solution.");
		this.setLocationRelativeTo(null);
	}
	
	/*
	 * Construction method of Main
	 */
	Main(){
		
		Room room = new Room();
		
		/*
		 * init array of chopsticks && philosophers && table
		 */

		for(int i=0;i<chopsticks.length;i++) {
			chopsticks[i] = new Chopsticks();
		}

		for(int i=0;i<philosophers.length;i++) {
			philosophers[i] = new Philosopher(i,chopsticks[i],chopsticks[(i+1)%5],room);
		}
		table = new Dining_Table(chopsticks,philosophers);
		for(int i=0;i<chopsticks.length;i++) {
			chopsticks[i].setTable(table);
		}
		table.setBounds(20, 60, 500, 420);
		/*
		 * picture for philosophers
		 */
		room_pic = new ImageIcon("./src/pictures/room.png");
		eating = new ImageIcon("./src/pictures/eating.png");
		thinking = new ImageIcon("./src/pictures/thinking.png");
		waiting = new ImageIcon("./src/pictures/waiting.png");
		init = new ImageIcon("./src/pictures/init.png");
		/*
		 * add panel for button
		 */
		button_panel.setBounds(100, 0, 400, 200);
		button_panel.setLayout(new FlowLayout());
		button_panel.add(start);
		button_panel.add(suspend);
		button_panel.add(resume);
		button_panel.add(end);
		
		/*
		 * add listener for button
		 */
		start.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Philosopher ph:philosophers) {
				ph.start();
			}
			}
		});
		
		end.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		suspend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<5;i++) {
					philosophers[i].suspend_request();
				}
			}
		});
		
		resume.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<5;i++) {
					philosophers[i].resume_request();
				}
			}
		});
		/*
		 * panel for description
		 */
		describe_panel = new JPanel();
		describe_panel.setBounds(20, 480, 200, 200);
		describe_panel.setOpaque(false);
		describe_panel.setLayout(new BoxLayout(describe_panel,BoxLayout.Y_AXIS));

		JLabel label0 = new JLabel("room status",room_pic,JLabel.RIGHT);
		JLabel label1 = new JLabel("init status",init,JLabel.RIGHT);
		JLabel label2 = new JLabel("thiking status",thinking,JLabel.RIGHT);
		JLabel label3 = new JLabel("eating status",eating,JLabel.RIGHT);
		JLabel label4 = new JLabel("hungry status",waiting,JLabel.RIGHT);
		
		room.setLabel(label0);
		describe_panel.add(label0);
		describe_panel.add(label1);
		describe_panel.add(label2);
		describe_panel.add(label3);
		describe_panel.add(label4);
		/*
		 * add all panel into main panel
		 */
		main_panel = new JPanel();
		main_panel.setLayout(null);
		main_panel.add(describe_panel);
		main_panel.add(button_panel);
		main_panel.add(table);
		this.add(main_panel);
		this.setVisible(true);
		
		setFrameLocation();
	}

	public static void main(String[] args) {
		new Main();
	}
}