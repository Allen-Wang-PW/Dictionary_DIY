package UI;
import javax.swing.*;

import Data.ImportData;
import Data.MainData;
public class Display {
	static final int WIDTH = 700;
	static final int HEIGHT = 530;
	static final String TITLE = "My Dictionary";
	static Display menu;
	static ImportData importdata;
	public static void main(String[] args) {
		menu = new Display();
	}
	
	public Display() {
		MainData.frame = new JFrame();
		MainData.frame.setResizable(false);
		MainData.frame.setTitle(TITLE);
		MainData.frame.setLayout(null);
		
		importdata = new ImportData();

		Data.MainData.uppanel = new UpPanel();
		Data.MainData.uppanel.setBounds(0, 0, 700, 80);
		MainData.frame.getContentPane().add(Data.MainData.uppanel);
		
		LogPanel logpanel = new LogPanel();
		Data.MainData.welpanel = logpanel.createPanel();
		Data.MainData.welpanel.setBounds(0, 80, 700, 450);
		MainData.frame.getContentPane().add(Data.MainData.welpanel);
/*		
		AutoCompletionPanel acp = new AutoCompletionPanel();
		JScrollPane sp = acp.createList();
		Data.MainData.autopanel = new JPanel();
		MainData.autopanel.setLayout(null);
		Data.MainData.autopanel.add(sp);
		Data.MainData.autopanel.setBounds(0, 80, 160, 450);
		MainData.autopanel.setBackground(Color.LIGHT_GRAY);
		MainData.frame.getContentPane().add(Data.MainData.autopanel);
		Data.MainData.autopanel.setVisible(false);
*/				
		MainData.translatepanel = new TranslatePanel();
		MainData.translatepanel.setVisible(false);
		MainData.translatepanel.setBounds(0, 80, 540, 450);
		MainData.frame.getContentPane().add(MainData.translatepanel);
		
		MainData.tipandfix = new TipAndFix();
		
		MainData.frame.setSize(WIDTH, HEIGHT);
		MainData.frame.setLocationRelativeTo(null);
		MainData.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainData.frame.setVisible(true);
	}
}

