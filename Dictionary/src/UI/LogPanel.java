package UI;
import java.awt.*;
import javax.swing.*;

public class LogPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		LogPanel panel = new LogPanel();
		JPanel temp = panel.createPanel();
		frame.getContentPane().add(temp);
		frame.setSize(700,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void paintComponent(Graphics g) {
		Image image = new ImageIcon("src/images/WelcomeImage.png").getImage();
		g.drawImage(image, 0, 0, 700, 427, this);
	}
	
	public JPanel createPanel() {
		LogPanel panel = new LogPanel();
//		panel.setBounds(0, 70, 700, 450);
		return panel;
	}
}
