package EmotionExtract;

import java.util.ArrayList;
import java.util.Collections;

public class Emotionform {

	public static String chooseEmotion(String[] input, String picture) {
		String[] Emotions = { input[0], input[1], input[2] };
		String sentence = input[3];

		ArrayList<String> FinalEmotions = new ArrayList<String>();

		boolean sameWithSentence = false;// 합친문장의 감정의 각각의 감정과 겹치는지
		boolean sameWithPicture = false;

		// 먼저 앞의 세개감정을검사한다.
		for (int i = 0; i < Emotions.length; i++) {

			if (Emotions[i] != "natural") {
				FinalEmotions.add(Emotions[i]);
				if (Emotions[i] == sentence) {
					sameWithSentence = true;
				}
				if (Emotions[i] == picture) {

				}
			}
		}

		if (FinalEmotions.size() < 3) {
			if (FinalEmotions.size() == 1) {
				FinalEmotions.add(sentence);
			}
			if (FinalEmotions.size() == 0 && sameWithSentence == false)// 앞세개의
																		// 감정이
																		// 없을경우
			{
				FinalEmotions.add(sentence);
			}
			if (FinalEmotions.size() < 3 && sameWithPicture == true) {
				FinalEmotions.add(picture);
			}
			if (FinalEmotions.size() < 2 && sameWithPicture == false) {
				FinalEmotions.add(picture);
			}
			if (FinalEmotions.size() < 3 && sentence == picture) {
				FinalEmotions.add(picture);

			}

			while (FinalEmotions.size() < 3) {
				FinalEmotions.add("natural");
			}

		}

		System.out.println();
		for (int i = 0; i < FinalEmotions.size(); i++) {
			System.out.println(FinalEmotions.get(i));
		}

		FinalEmotions = sortEmotions(FinalEmotions);

		StringBuilder aa = new StringBuilder();
		for (int i = 0; i < FinalEmotions.size(); i++) {
			aa.append(FinalEmotions.get(i));
		}
		System.out.println(aa.toString());

		return aa.toString();

	}

	public static ArrayList<String> sortEmotions(ArrayList<String> Emotions) {

		ArrayList<String> int_result = new ArrayList<String>();
		for (int i = 0; i < Emotions.size(); i++) {
			Emotions.get(i).trim();
			if (Emotions.get(i) == "love")
				int_result.add("0");
			else if (Emotions.get(i) == "happy")
				int_result.add("1");
			else if (Emotions.get(i) == "hate")
				int_result.add("2");
			else if (Emotions.get(i) == "sad")
				int_result.add("3");
			else if (Emotions.get(i) == "angry")
				int_result.add("4");
			else if (Emotions.get(i) == "excite")
				int_result.add("5");
			else if (Emotions.get(i) == "expect")
				int_result.add("6");
			else if (Emotions.get(i) == "natural")
				int_result.add("7");
		}

		Collections.sort(int_result);
		return int_result;

	}

}
