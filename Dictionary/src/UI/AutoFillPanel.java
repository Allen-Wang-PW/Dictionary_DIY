package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Common.WordType;
import Data.MainData;

public class AutoFillPanel {
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		JFrame frame = new JFrame();
		frame.setTitle("Auto Completion Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 200, 500, 400);
		
		ArrayList<WordType> items = new ArrayList<WordType>();
		Locale[] locales = Locale.getAvailableLocales();
		for (int i = 0; i < locales.length; i++) {
			String item = locales[i].getDisplayName();
			WordType word = new WordType();
			word.eng = item;
			items.add(word);
		}
		JTextField txtInput = new JTextField();
		setupAutoComplete(txtInput, items);
		txtInput.setColumns(30);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(txtInput, BorderLayout.NORTH);
		frame.setVisible(true);
	}
	
	@SuppressWarnings("rawtypes")
	private static boolean isAdjusting(JComboBox cbInput) {
		if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
			return (Boolean) cbInput.getClientProperty("is_adjusting");
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	private static void setAdjusting(JComboBox cbInput, boolean adjusting) {
		cbInput.putClientProperty("is_adjusting", adjusting);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	public static void setupAutoComplete(JTextField field, ArrayList<WordType> items) {
		final DefaultComboBoxModel model = new DefaultComboBoxModel();
		final JComboBox cbInput = new JComboBox(model) {
			public Dimension getPreferredSize() {
				return new Dimension(super.getPreferredSize().width, 0);
			}
		};
		
		setAdjusting(cbInput, false);
		for (WordType item : items) {
			String eng = item.eng;
			model.addElement(eng);
		}
		cbInput.setSelectedItem(null);
		cbInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isAdjusting(cbInput)) {
					if (cbInput.getSelectedItem() != null) {
						field.setText(cbInput.getSelectedItem().toString());
					}
				}
			}
		});
		
		field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setAdjusting(cbInput, true);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (cbInput.isPopupVisible()) {
						e.setKeyCode(KeyEvent.VK_ENTER);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
					e.setSource(cbInput);
					cbInput.dispatchEvent(e);
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						if (cbInput.getSelectedItem()==null) {
//							System.out.println("null");
							MainData.FixOn = 1;
							String str = field.getText();
							System.out.println("Wrong : " + str);
							MainData.TipWords.clear();
							MainData.tipandfix.setKey(str);
							MainData.tipandfix.giveTip();
//							System.out.println("Size of Tip : " + MainData.TipWords.size());
							WordType temp = new WordType();
							temp.eng = str;
							MainData.translatepanel.setWord(temp);
							MainData.translatepanel.repaint();
/*
							int cnt = 0;
							for (WordType word : MainData.TipWords) {
								System.out.println(word.eng);
								cnt++;
								if (cnt>10)
									break;
							}
*/
						}
						else {
							field.setText(cbInput.getSelectedItem().toString());
							cbInput.setPopupVisible(false);
							int index = cbInput.getSelectedIndex();
//							System.out.println("index : " + index);
//							System.out.println(cbInput.getSelectedItem().toString());
							WordType word = MainData.AutofillWords.get(index);
							MainData.translatepanel.setWord(word);
							MainData.translatepanel.repaint();
						}
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					cbInput.setPopupVisible(false);
				}
				setAdjusting(cbInput, false);
			}
		});
		
		field.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				updateList();
			}
			
			public void removeUpdate(DocumentEvent e) {
				updateList();
			}
			
			public void changedUpdate(DocumentEvent e) {
				updateList();
			}
			
			private void updateList() {
				setAdjusting(cbInput, true);
				model.removeAllElements();
				String input = field.getText();
//				System.out.println("Text : " + input);
				InputArea.autoFill(input);
//				System.out.println("Size : " + MainData.AutofillWords.size());
				if (!input.isEmpty()) {
					for (WordType item : items) {
						if (item.eng.toLowerCase().startsWith(input.toLowerCase())) {
							model.addElement(item.eng);
			            }
					}
				}
				cbInput.setPopupVisible(model.getSize() > 0);
				if (MainData.AutofillWords.size()>10)
					cbInput.setMaximumRowCount(10);
				else 
					cbInput.setMaximumRowCount(MainData.AutofillWords.size());
				setAdjusting(cbInput, false);
			}
		});
		
		field.setLayout(new BorderLayout());
		field.add(cbInput, BorderLayout.SOUTH);
		cbInput.setEditable(true);
	}
}
