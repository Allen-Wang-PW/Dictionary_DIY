package UI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

import Common.WordType;
import Data.MainData;
public class TranslatePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final int WIDTH = 700;
	static final int HEIGHT = 530;
	private WordType word = new WordType();
	public void init() {
		word.eng="";
		word.attri="";
		word.chi="";
	}
	public void setWord(WordType w) {
		word=w;
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setBackground(Color.LIGHT_GRAY);
		if (MainData.FixOn == 0) {
			Font font = new Font("Courier", Font.ITALIC, 25);
			g2d.setFont(font);
			g2d.setColor(Color.black);
			g2d.drawString(word.eng, 40, 40);
			Font font1 = new Font("Courier", Font.PLAIN, 15);
			g2d.setFont(font1);
			g2d.drawString(word.attri+" "+word.chi, 40, 80);
		}
		else {
			Font font = new Font("Courier", Font.HANGING_BASELINE, 25);
			g2d.setFont(font);
			g2d.drawString(word.eng, 40, 40);
			g2d.setColor(Color.black);
			font = new Font("Courier", Font.PLAIN, 20);
			g2d.setFont(font);
			g2d.drawString(" was not found!", 40 + 15*word.eng.length(), 40);
			
			Font font1 = new Font("Courier", Font.PLAIN, 15);
			g2d.setFont(font1);
			g2d.drawString("Do you mean?", 40, 80);
			g2d.setColor(Color.blue);
			int cnt = Math.min(MainData.TipWords.size(), 10);
			for (int i = 0; i < cnt; i++) {
				WordType temp = MainData.TipWords.get(i);
				g2d.drawString(temp.eng + " " + temp.attri + " " + temp.chi, 40, 100+i*20);
			}
			MainData.FixOn = 0;
			g2d.setColor(Color.black);
		}
	}
	
	public JPanel createPanel() {
		JPanel panel = new JPanel();
		return panel;
	}
	
	public TranslatePanel() {
		init();
		this.repaint();
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(null);
		TranslatePanel tp = new TranslatePanel();
		tp.setBounds(160, 80, 540, 450);
		frame.getContentPane().add(tp);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
