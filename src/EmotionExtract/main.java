package EmotionExtract;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.lucene.analysis.ko.morph.MorphException;

import Phoneme.PhonemeTextEngine;

public class main {

	public static void main(String[] args) throws MorphException {
		// TODO Auto-generated method stub

		String[] emotion = new String[4];

		String[] str = { "나는", "나는", "나는", "" };
		StringBuilder sentence = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sentence.append(str[i]);

		}
		str[3] = sentence.toString();

		String picture = "natural";

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"data/Madi_v.01.dat"));

			PhonemeTextEngine textEngine = (PhonemeTextEngine) ois.readObject();
			ois.close();

			for (int i = 0; i < str.length; i++) {
				try {
					emotion[i] = textEngine.getEmotion(str[i]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
				}
			}
			System.out.println();

			for (int i = 0; i < emotion.length; i++) {
				// System.out.println("ss");
				System.out.println(emotion[i].toString());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		String aa = Emotionform.chooseEmotion(emotion, picture);

		System.out.println(aa);

	}

}
