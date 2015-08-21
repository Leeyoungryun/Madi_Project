package EmotionExtract;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.lucene.analysis.ko.morph.MorphException;

import Phoneme.PhonemeTextEngine;


public class Emotion_test {
	
	public static void main(String[] args) throws MorphException {
		// TODO Auto-generated method stub

		String[] emotion = new String[4] ;
		String[] str ={"너는","나를","잊었니"};
		
		String picture = "happy";
	

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"data/0821_tested.dat"));

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
			System.out.println();
			System.out.println(emotion.length);
			for (int i = 0; i < emotion.length; i++) {
				System.out.println(emotion[i].toString());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		Emotionform.chooseEmotion(emotion,picture);

	}

}
