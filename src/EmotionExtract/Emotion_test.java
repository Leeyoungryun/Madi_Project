package EmotionExtract;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.lucene.analysis.kr.morph.MorphException;


public class Emotion_test {
	
	public static void main(String[] args) throws MorphException {
		// TODO Auto-generated method stub


		String str = "너때문에 짜증난다" ;

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"dataset/2014journal.dat"));

			PhonemeTextEmotion textEngine = (PhonemeTextEmotion) ois
					.readObject();
			ois.close();
			
			String emotion = textEngine.getEmotion(str);
			System.out.println(emotion.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
