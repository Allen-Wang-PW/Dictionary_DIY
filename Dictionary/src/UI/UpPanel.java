package UI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int WIDTH = 700;
	static final int HEIGHT = 80;
	
	static UpPanel uppanel;
	static InputArea area;
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		uppanel = new UpPanel();
		uppanel.repaint();
		frame.getContentPane().add(uppanel);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g) {
		Color mycolor = new Color(7*25+5, 1*25+5, 1*25+5);
		g.setColor(mycolor);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		Image Logo = new ImageIcon("src/images/Logo.png").getImage();
		g.drawImage(Logo, 10, 30, 100, 33, this);
	}
	
	static JButton dic;
	static JButton exa;
	static JButton baik;
	static JButton trans;
	static JButton word;
	public UpPanel( ){
		this.setLayout(null);
		area = new InputArea();
		JTextField field = area.createField();
		field.setBounds(120, 35, 200, 25);
		dic = new JButton(new ImageIcon("src/images/Dic_Off.png"));
		dic.addActionListener(new dicListener());
		exa = new JButton(new ImageIcon("src/images/Exa_Off.png"));
		exa.addActionListener(new exaListener());
		baik = new JButton(new ImageIcon("src/images/Baik_Off.png"));
		baik.addActionListener(new baikListener());
		trans = new JButton(new ImageIcon("src/images/Trans_Off.png"));
		trans.addActionListener(new transListener());
		word = new JButton(new ImageIcon("src/images/Word_Off.png"));
		word.addActionListener(new wordListener());
		dic.setBounds(360, 25, 40, 44);
		exa.setBounds(420, 25, 40, 44);
		baik.setBounds(480, 25, 40, 44);
		trans.setBounds(540, 25, 40, 44);
		word.setBounds(600, 25, 40, 44);
		this.add(dic);
		this.add(exa);
		this.add(baik);
		this.add(trans);
		this.add(word);
		this.add(field);
	}
	
	class dicListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dic.setIcon(new ImageIcon("src/images/Dic_On.png"));
			exa.setIcon(new ImageIcon("src/images/Exa_Off.png"));
			baik.setIcon(new ImageIcon("src/images/Baik_Off.png"));
			trans.setIcon(new ImageIcon("src/images/Trans_Off.png"));
			word.setIcon(new ImageIcon("src/images/Word_Off.png"));
		}
	}
	
	class exaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dic.setIcon(new ImageIcon("src/images/Dic_Off.png"));
			exa.setIcon(new ImageIcon("src/images/Exa_On.png"));
			baik.setIcon(new ImageIcon("src/images/Baik_Off.png"));
			trans.setIcon(new ImageIcon("src/images/Trans_Off.png"));
			word.setIcon(new ImageIcon("src/images/Word_Off.png"));
		}
	}
	
	class baikListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dic.setIcon(new ImageIcon("src/images/Dic_Off.png"));
			exa.setIcon(new ImageIcon("src/images/Exa_Off.png"));
			baik.setIcon(new ImageIcon("src/images/Baik_On.png"));
			trans.setIcon(new ImageIcon("src/images/Trans_Off.png"));
			word.setIcon(new ImageIcon("src/images/Word_Off.png"));
		}
	}
	
	class transListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dic.setIcon(new ImageIcon("src/images/Dic_Off.png"));
			exa.setIcon(new ImageIcon("src/images/Exa_Off.png"));
			baik.setIcon(new ImageIcon("src/images/Baik_Off.png"));
			trans.setIcon(new ImageIcon("src/images/Trans_On.png"));
			word.setIcon(new ImageIcon("src/images/Word_Off.png"));
		}
	}
	
	class wordListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dic.setIcon(new ImageIcon("src/images/Dic_Off.png"));
			exa.setIcon(new ImageIcon("src/images/Exa_Off.png"));
			baik.setIcon(new ImageIcon("src/images/Baik_Off.png"));
			trans.setIcon(new ImageIcon("src/images/Trans_Off.png"));
			word.setIcon(new ImageIcon("src/images/Word_On.png"));
		}
	}
}
