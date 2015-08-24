package ExtractWord;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.lucene.analysis.ko.morph.MorphException;

import EmotionExtract.Emotionform;
import ExtractWord.extractword;
import Phoneme.PhonemeTextEngine;

public class writeTest2 {
	public static String test(String[] str, String back) {
		String[] emotion = new String[4] ;

		StringBuilder sentence= new StringBuilder();
		for(int i=0; i<str.length; i++){
			sentence.append(str[i]);
		}
		str[3]=sentence.toString();
		
		String picture = back;
	
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"C:/project/Madi_Project/data/0725_jinhee.dat"));

			PhonemeTextEngine textEngine = (PhonemeTextEngine) ois
					.readObject();
			ois.close();
			
			for(int i=0; i<str.length; i++){
				try {
					emotion[i] = textEngine.getEmotion(str[i]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("** 감정 결과 **");
			for (int i = 0; i < emotion.length-1; i++) {
				System.out.println((i+1) + ". tag"+ (i+1) + " : "+emotion[i].toString());
			}
			System.out.println("4. tag1+tag2+tag3 : " + emotion[3].toString());
			System.out.println("5. background : " + picture);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		String result = Emotionform2.chooseEmotion(emotion, picture);
		return result;
	}
}
