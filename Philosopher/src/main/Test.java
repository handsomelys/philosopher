package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageIcon img = new ImageIcon("./src/pictures/eating.png");
		JLabel jl = new JLabel();
		jl.setIcon(img);
		JFrame frame = new JFrame();
		JPanel jp = new JPanel();
		frame.add(jp);
		jp.add(jl);
		frame.setVisible(true);
	}

}
