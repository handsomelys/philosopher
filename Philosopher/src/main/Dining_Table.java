/** 
 * @Title: Dining_Table.java 
 * @Package main 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com 
 * @date 2020年6月16日 上午10:06:26 
 * @version V1.0 
 */  
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author dell
 *
 */
public class Dining_Table extends JPanel{
	Chopsticks chops[];
	Philosopher phils[];
	private int radius1 = 20;
	private int LENGTH_OF_CHOP = 35;
	private int DISTANCE_BETWEEN_PERSON_AND_CHOP = 100;
	private int DISTANCE_BETWEEN_PERSON_AND_NAME = -12;
	private int radius2 = radius1 + LENGTH_OF_CHOP;
	private int radius3 = radius2 + DISTANCE_BETWEEN_PERSON_AND_CHOP;
	private int delta = 72;
	private int theta = -18;

	public Dining_Table(Chopsticks[] chops,Philosopher[] phils) {
		this.setPreferredSize(new Dimension(500,350));
		this.chops = chops;
		this.phils = phils;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*
		 * init label
		 */
		int x1,y1,x2,y2,x3,y3;
		/*
		 * 画餐桌
		 */
		g.fillOval(200, 150, 150, 150);
		
		/*
		 * 画筷子,并把哲学家安置好
		 */
		for(int i=0;i<5;i++) {
			g.setColor(Color.blue);
			
			x1 = 275 + (int) (radius1 * Math.cos(((delta * i)+ theta*(-5)  ) * Math.PI / 180));
			y1 = 225 + (int) (radius1 * Math.sin(((delta * i) + theta*(-5)  ) * Math.PI / 180));
			x2 = 275 + (int) (radius2 * Math.cos(((delta * i) + theta *(-5) ) * Math.PI / 180));
			y2 = 225 + (int) (radius2 * Math.sin(((delta * i) + theta *(-5) ) * Math.PI / 180));
			x3 = 275 + (int) (radius3 * Math.cos(((delta * i) + theta ) * Math.PI / 180));
			y3 = 225 + (int) (radius3 * Math.sin(((delta * i) + theta ) * Math.PI / 180));
			
			if(chops[i].getOwner() != null && phils[i].getId_for_philosopher() == chops[i].getOwner_ID()) {
				if(chops[i].getOwner().getCode() == 2) {
					g.drawLine(x3 + 38 , y3, x3 + 38, y3 + LENGTH_OF_CHOP);
				}	
			}

			if(chops[i].getOwner() == null) {
				g.drawLine(x1, y1, x2, y2);
			}
			
			phils[i].getCurrent().paintIcon(this, g, x3 - 7, y3);
			g.drawString("philosopher" + (i+1), x3 - 25, y3 + DISTANCE_BETWEEN_PERSON_AND_NAME);
			System.out.println((i+1)+" philosopher"+" locate in " + (x3-5) + "," + (y3 + DISTANCE_BETWEEN_PERSON_AND_NAME));
		}		
	}
	}
	
