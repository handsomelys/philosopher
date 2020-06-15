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

import javax.swing.ImageIcon;
import javax.swing.JButton;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		ArrayList<Philosopher> philosophers = new ArrayList<Philosopher>();
		ArrayList<JLabel> pictures = new ArrayList<JLabel>();
		JButton start = new JButton("开始");
		JButton end = new JButton("结束");
		JPanel buttonpane = new JPanel();
		JPanel picPane = new JPanel();
		JFrame speedSelect = new JFrame("select speed!");
		JPanel speedPanel = new JPanel();
		Font f = new Font("serif",0,10);
		JFrame frame = new JFrame();
		JTextArea jta = new JTextArea();
		jta.setFont(f);
		JScrollPane jsp1 = new JScrollPane(jta);
		jta.setLineWrap(true);
		frame.add(buttonpane,BorderLayout.NORTH);
		buttonpane.add(start);
		buttonpane.add(end);
		JLabel pic1 = new JLabel();
		JLabel pic2 = new JLabel();
		JLabel pic3 = new JLabel();
		JLabel pic4 = new JLabel();
		JLabel pic5 = new JLabel();
		JLabel desk = new JLabel();
		JLabel kz1 = new JLabel();
		JLabel kz2 = new JLabel();
		JLabel kz3 = new JLabel();
		JLabel kz4 = new JLabel();
		JLabel kz5 = new JLabel();
		ImageIcon img = new ImageIcon("./src/pictures/desk.png");
		desk.setIcon(img);
		img = new ImageIcon("./src/pictures/kz1.png");
		kz1.setIcon(img);
		img = new ImageIcon("./src/pictures/kz3.png");
		kz2.setIcon(img);
		img = new ImageIcon("./src/pictures/kz25.png");
		kz3.setIcon(img);
		img = new ImageIcon("./src/pictures/kz4.png");
		kz4.setIcon(img);
		img = new ImageIcon("./src/pictures/kz25.png");
		kz5.setIcon(img);
		pictures.add(pic1);pictures.add(pic2);pictures.add(pic3);pictures.add(pic4);pictures.add(pic5);
		Chopsticks chopsticks = new Chopsticks();
		
		Philosopher philosopher1 = new Philosopher("0",chopsticks,pic1);
		Philosopher philosopher2 = new Philosopher("1",chopsticks,pic2);
		Philosopher philosopher3 = new Philosopher("2",chopsticks,pic3);
		Philosopher philosopher4 = new Philosopher("3",chopsticks,pic4);
		Philosopher philosopher5 = new Philosopher("4",chopsticks,pic5);
		philosophers.add(philosopher1);
		philosophers.add(philosopher2);
		philosophers.add(philosopher3);
		philosophers.add(philosopher4);
		philosophers.add(philosopher5);
		for(Philosopher ph:philosophers) {
			ph.setJta(jta);
		}
		speedSelect.setSize(100,100);
		speedSelect.setLocationRelativeTo(null);
		JButton fast = new JButton("快");
		JButton mid = new JButton("中");
		JButton slow = new JButton("慢");
		speedSelect.add(speedPanel);
		speedPanel.add(fast,FlowLayout.LEFT);
		speedPanel.add(mid,FlowLayout.CENTER);
		speedPanel.add(slow,FlowLayout.RIGHT);
		speedSelect.setResizable(false);
		speedSelect.setVisible(true);
		fast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(Philosopher ph:philosophers) {
					ph.setSpeed(200);
				}
				speedSelect.setVisible(false);
				frame.setVisible(true);
			}
			
		});
		mid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(Philosopher ph:philosophers) {
					ph.setSpeed(800);
				}
				speedSelect.setVisible(false);
				frame.setVisible(true);
			}
			
		});
		slow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(Philosopher ph:philosophers) {
					ph.setSpeed(2000);
				}
				speedSelect.setVisible(false);
				frame.setVisible(true);
			}		
		});
		
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

		Dimension size = jta.getPreferredSize();
		
		jsp1.setBounds(300, 200, size.width, size.height);
		jsp1.setPreferredSize(size);
		frame.add(jsp1,BorderLayout.WEST);
		frame.add(picPane,BorderLayout.CENTER);
		frame.setSize(500,800);
		
		picPane.setLayout(null);
		picPane.add(pic1);picPane.add(pic2);picPane.add(pic3);picPane.add(pic4);picPane.add(pic5);picPane.add(desk);
		picPane.add(kz1);picPane.add(kz2);picPane.add(kz3);picPane.add(kz4);picPane.add(kz5);
		
		pic1.setBounds(170, 50, 50, 50);
		pic5.setBounds(20, 150, 50, 50);
		pic2.setBounds(320, 150, 50, 50);
		pic4.setBounds(95, 300, 50, 50);
		pic3.setBounds(245, 300, 50, 50);
		desk.setBounds(145, 110, 200, 200);
		kz1.setBounds(170, 100, 30, 30);
		kz5.setBounds(70, 155, 30, 30);
		kz2.setBounds(275, 155, 30, 30);
		kz4.setBounds(95, 270, 30, 30);
		kz3.setBounds(245, 270, 30, 30);
		//frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.repaint();
		while(true) {
			jta.append(chopsticks.getStatus());
			for(Philosopher ph:philosophers) {
				ph.statusForPhilosophers();
			}
			if(philosopher1.getChopsticks().getIsUsed()[0]==false) {
				img = new ImageIcon("./src/pictures/kz1.png");
				kz1.setIcon(img);
				kz1.setBounds(170, 100, 30, 30);
			}
			else
				kz1.setIcon(null);
			if(philosopher1.getChopsticks().getIsUsed()[1]==false) {
				img = new ImageIcon("./src/pictures/kz25.png");
				kz2.setIcon(img);
				//kz2.setBounds(50, 155, 30, 30);
				kz2.setBounds(275, 155, 30, 30);
			}	
			else
				kz2.setIcon(null);
			if(philosopher1.getChopsticks().getIsUsed()[2]==false) {
				img = new ImageIcon("./src/pictures/kz3.png");
				kz3.setIcon(img);
				//kz3.setBounds(255, 155, 30, 30);
				kz3.setBounds(245, 270, 30, 30);
			}
			else
				kz3.setIcon(null);
			if(philosopher1.getChopsticks().getIsUsed()[3]==false) {
				img = new ImageIcon("./src/pictures/kz4.png");
				kz4.setIcon(img);
				//kz4.setBounds(75, 270, 30, 30);
				kz4.setBounds(95, 270, 30, 30);
			}
			else
				kz4.setIcon(null);
			if(philosopher1.getChopsticks().getIsUsed()[4]==false) {
				img = new ImageIcon("./src/pictures/kz25.png");
				kz5.setIcon(img);
				//kz5.setBounds(225, 270, 30, 30);
				pic5.setBounds(20, 150, 50, 50);
			}	
			else
				kz5.setIcon(null);
		}
		
		
	}
}

