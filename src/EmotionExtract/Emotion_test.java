package EmotionExtract;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.lucene.analysis.ko.morph.MorphException;

import Phoneme.PhonemeTextEngine;


public class Emotion_test {
	
	public static void main(String[] args) throws MorphException {
		// TODO Auto-generated method stub


		String[] str ={ "바다","사랑","식당"};

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"data/gee.dat"));

			PhonemeTextEngine textEngine = (PhonemeTextEngine) ois
					.readObject();
			ois.close();
			
			String[] emotion = new String[str.length];
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

	}

}
