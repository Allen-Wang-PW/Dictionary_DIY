/*
package UI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Common.WordType;
import Data.MainData;
public class AutoCompletionPanel {	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JScrollPane createList() {
		MainData.listmodel = new DataModel(1);
		MainData.wordlist = new JList(MainData.listmodel);
		MainData.wordlist.addMouseListener(new ListClick());
		JScrollPane scroller = new JScrollPane(MainData.wordlist);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scroller.setBounds(1, 1, 157, 425);
		return scroller;
	}
	
	class ListClick implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()==2) {
				int index = MainData.wordlist.locationToIndex(e.getPoint());
				MainData.translatepanel.setWord(MainData.AutofillWords.get(index));
				MainData.translatepanel.repaint();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	@SuppressWarnings({ "rawtypes", "serial" })
	class DataModel extends DefaultListModel {
		@SuppressWarnings("unchecked")
		DataModel(int flag) {
			if (flag == 1) {
				try {
					for (WordType sta : Data.MainData.AutofillWords) {
						addElement(sta.eng);
					}
				} catch(Exception e) {
//					e.printStackTrace();
				}
			}
		}
	}
}
*/