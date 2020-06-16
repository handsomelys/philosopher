package main;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
public class Main extends JFrame{
	Chopsticks[] chops = new Chopsticks[5];
	Philosopher[] phils = new Philosopher[5];
	Dining_Table table;
	private JButton start = new JButton("start");
	private JButton end = new JButton("end");
	private JPanel button_panel = new JPanel();
	
	ImageIcon eating,thinking,waiting,init;
	public void setFrameLocation() {
		this.setResizable(false);
		this.setSize(600,650);

	}
	Main(){
		/*
		 * init philosophers && chopsticks && table
		 */
		Room room = new Room();
		for(int i=0;i<chops.length;i++) {
			chops[i] = new Chopsticks();
		}
		for(int i=0;i<phils.length;i++) {
			phils[i] = new Philosopher(i,chops[i],chops[(i+1)%5],room);
		}
		table = new Dining_Table(chops,phils);
		for(int i=0;i<chops.length;i++) {
			chops[i].setTable(table);
		}
		table.setBounds(20, 80, 500, 420);
		this.setVisible(true);
		
		/*
		 * picture for philosophers
		 */
		eating = new ImageIcon("./src/pictures/eating.png");
		thinking = new ImageIcon("./src/pictures/thinking.png");
		waiting = new ImageIcon("./src/pictures/waiting.png");
		init = new ImageIcon("./src/pictures/init.png");
		/*
		 * add panel for button
		 */
		button_panel.setBounds(200, 20, 150, 100);
		button_panel.setLayout(new FlowLayout());
		button_panel.add(start);
		button_panel.add(end);
		
		/*
		 * add listener for button
		 */
		start.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Philosopher ph:phils) {
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
		
		JPanel describe_panel = new JPanel();
		describe_panel.setBounds(20, 500, 200, 200);
		describe_panel.setOpaque(false);
		describe_panel.setLayout(new BoxLayout(describe_panel,BoxLayout.Y_AXIS));
		JLabel label1 = new JLabel("init status",init,JLabel.RIGHT);
		
		JLabel label2 = new JLabel("thiking status",thinking,JLabel.RIGHT);
		
		JLabel label3 = new JLabel("eating status",eating,JLabel.RIGHT);
		
		JLabel label4 = new JLabel("hungry status",waiting,JLabel.RIGHT);
		
		describe_panel.add(label1);
		describe_panel.add(label2);
		describe_panel.add(label3);
		describe_panel.add(label4);
		JPanel main_panel = new JPanel();
		main_panel.setLayout(null);
		main_panel.add(describe_panel);
		main_panel.add(button_panel);
		main_panel.add(table);
		this.add(main_panel);
		
		setFrameLocation();
	}
	public static void main(String[] args) {
		new Main();
	}
}