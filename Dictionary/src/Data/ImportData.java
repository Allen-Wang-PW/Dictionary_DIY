package Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Common.WordType;
public class ImportData {
	private static Scanner in;

	public WordType mysplit(String str) {
		String spl[] = str.split("[\\p{Space}]+");
		int len=spl.length;
		String eng="", attri="", chi=spl[len-1];
		if (len>=3) {
			if (spl[len-2].endsWith(".")&&!spl[len-2].endsWith("...")) {
				for (int i=0;i<len-2;i++) {
					eng=eng+spl[i];
					if (i<len-3)
						eng+=" "; 
				}
				attri=spl[len-2];
			}
			else {
				for (int i=0;i<len-1;i++) {
					eng=eng+spl[i];
					if (i<len-2)
						eng+=" ";
				}
			}
		}
		else {
			for (int i=0; i<len-1; i++) {
				eng=eng+spl[i];
				if (i<len-2)
					eng+=" ";
			}
		}
		Pattern p=Pattern.compile("[a-z]\\.");
		Matcher m=p.matcher(chi);
		if (m.find()) {
			String temp[]=chi.split("\\.");
			attri=temp[0]+".";
			chi="";
			for (int i=1;i<temp.length;i++)
				chi=chi+temp[i];
		}
		WordType word = new WordType();
		word.eng=eng;
		word.attri=attri;
		word.chi=chi;
		
		return word;
	}
	
	public ImportData() {
		try {
			in = new Scanner(new File("src/Data/Dic.txt"));
			while (in.hasNextLine()) {
				String str = in.nextLine();
				WordType word=mysplit(str);
				MainData.Words.add(word);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(MainData.Words.size());

	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ImportData temp = new ImportData();
		System.out.println("in");
	}
}
