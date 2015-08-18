package ExtractWord;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.lucene.analysis.ko.morph.MorphException;

import ExtractWord.extractword;
import Phoneme.PhonemeTextEngine;

public class writeTest {
	public static String test(String str) {
		String str1 = str;
		String emotion = null;
		
		try {
			String path = writeTest.class.getResource("").getPath();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/project/Madi_Project/data/gee.dat"));

			PhonemeTextEngine textEngine = (PhonemeTextEngine) ois
					.readObject();
			ois.close();
						
			try {
				emotion = textEngine.getEmotion(str1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(emotion.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "happy";
	}
}
