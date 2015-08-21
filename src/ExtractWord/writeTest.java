package ExtractWord;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.lucene.analysis.ko.morph.MorphException;

import ExtractWord.extractword;
import Phoneme.PhonemeTextEngine;

public class writeTest {
	public static String[] test(String[] str) {
		
		//String[] string = { "바다","사랑","식당"};
		String[] emotion = null;

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/project/Madi_Project/data/0821_tested.dat"));

			PhonemeTextEngine textEngine = (PhonemeTextEngine) ois
					.readObject();
			ois.close();
			
			emotion = new String[str.length];
			for(int i=0; i<emotion.length; i++){
				try {
					emotion[i] = textEngine.getEmotion(str[i]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(emotion[i]);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emotion;
	}
}
