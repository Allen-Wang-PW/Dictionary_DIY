package UI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;

import Common.WordType;
import Data.MainData;
public class InputArea extends JTextField{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static JTextField field;
	public JTextField createField() {
		field = new JTextField("Search");
		field.setSize(200, 20);
		field.addMouseListener(new mouseEnter());
		AutoFillPanel.setupAutoComplete(field, MainData.AutofillWords);
		return field;
	}
	
	public String getContent() {
		return field.getText();
	}
	
	public static int binarySearch(String key) {
		if (key.isEmpty())
			return 0;
		key=key.toLowerCase();
		int low=0, high=MainData.Words.size()-1;
		int mid=(low+high)/2;
		String temp=MainData.Words.get(mid).eng.toString();
		while (high>low) {
			mid=(high+low)/2;
			temp=MainData.Words.get(mid).eng.toString().toLowerCase();
			String t="";
			if (mid>0)
				t=MainData.Words.get(mid-1).eng;
			if (temp.startsWith(key)&&(!t.startsWith(key)||mid==0)) {
//				System.out.println(mid+" "+temp);
				return mid;
			}
			if (key.compareTo(temp)>0)
				low=mid;
			else if (key.compareTo(temp)==0)
				return mid;
			else if (key.compareTo(temp)<0||temp.contains(key))
				high=mid;
			if (mid==low&&low+1==high)
				break;
		}
		return -1;
	}
	
	public static void autoFill(String key) {
//		String key=field.getText().toLowerCase();
		if (key.isEmpty()) {
			MainData.AutofillWords.clear();
			for (WordType sta : MainData.Words)
				MainData.AutofillWords.add(sta);
			return ;
		}
		int index=binarySearch(key);
		System.out.println("binary : " + index);
		if (index==-1) {
			System.out.println("None");
			return ;
		}
		else {
			MainData.AutofillWords.clear();
//			System.out.println("index:"+index);
			for (int i=index;i<MainData.Words.size();i++) {
				WordType temp=MainData.Words.get(i);
				if (temp.eng.toLowerCase().startsWith(key.toLowerCase()))
					MainData.AutofillWords.add(temp);
				else 
					break;
			}
		}
//		System.out.println("After autoFill : " + MainData.AutofillWords.size());
	}
	
	public int mfind(String key) {
		if (key.isEmpty())
			return 0;
		key=key.toLowerCase();
		int low=0, high=MainData.AutofillWords.size()-1;
		int mid=(low+high)/2;
		String temp=MainData.AutofillWords.get(mid).eng.toString();
		if (low==high&&low==0) {
			if (key.equals(temp))
				return 0;
		}
		while (high>low) {
			mid=(high+low)/2;
			temp=MainData.AutofillWords.get(mid).eng.toString().toLowerCase();
			String t="";
			if (mid>0)
				t=MainData.AutofillWords.get(mid-1).eng;
			if (temp.contains(key)&&(!t.contains(key)||mid==0)) {
//				System.out.println(mid+" "+temp);
				return mid;
			}
			if (key.compareTo(temp)>0)
				low=mid;
			else if (key.compareTo(temp)==0)
				return mid;
			else if (key.compareTo(temp)<0||temp.contains(key))
				high=mid;
			if (mid==low&&low+1==high)
				break;
		}
		return -1;
	}
	
	class mouseEnter implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			if (e.getSource()==field) {
				field.setText("");
				MainData.translatepanel.setVisible(true);
				MainData.welpanel.setVisible(false);
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
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	@SuppressWarnings({ "serial", "rawtypes" })
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
