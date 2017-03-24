package UI;

import java.util.ArrayList;

import Common.WordType;
import Data.MainData;
import Data.StringDistance;

public class TipAndFix {
	private String key;
	public void setKey(String str) {
		key = str;
	}
	
	public void giveTip() {
		ArrayList<WordType>setDistance1 = new ArrayList<WordType>();
		ArrayList<WordType>setDistance2 = new ArrayList<WordType>();
		ArrayList<WordType>setDistance3 = new ArrayList<WordType>();
		for (WordType word : MainData.Words) {
			int dis = StringDistance.getStringDistance(key, word.eng);
			if ( dis < 4) {
				if (dis == 1)
					setDistance1.add(word);
				else if (dis == 2)
					setDistance2.add(word);
				else if (dis == 3)
					setDistance3.add(word);
			}
		}
		for (WordType word : setDistance1)
			MainData.TipWords.add(word);
		for (WordType word : setDistance2)
			MainData.TipWords.add(word);
		for (WordType word : setDistance3)
			MainData.TipWords.add(word);
	}
}
