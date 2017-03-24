package Data;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UI.TipAndFix;
import UI.TranslatePanel;
import UI.UpPanel;
import Common.WordType;

public class MainData {
	public static JFrame frame;
	public static UpPanel uppanel;
	public static JPanel welpanel;
	public static JPanel autopanel;
	public static TranslatePanel translatepanel; 
	public static TipAndFix tipandfix;
//	@SuppressWarnings("rawtypes")
//	public static JList wordlist;
//	@SuppressWarnings("rawtypes")
//	public static DefaultListModel listmodel;
	public static ArrayList<WordType> Words = new ArrayList<WordType>();
	public static ArrayList<WordType> AutofillWords = new ArrayList<WordType>();
	public static ArrayList<WordType> TipWords = new ArrayList<WordType>();
	
	public static int FixOn = 0;
}
