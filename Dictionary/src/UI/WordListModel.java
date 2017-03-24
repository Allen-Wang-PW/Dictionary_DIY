package UI;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
public class WordListModel extends DefaultComboBoxModel {
	WordListModel(String s[]){
		addElement("Default");
		for (String sta : s) {
			addElement(sta);
		}
	}
}
