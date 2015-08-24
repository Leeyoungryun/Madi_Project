package emotionExtractor;

public class TendencyCheck {
	public static String result(String tendency, String emotion){
		String sad = "033 133 233 234 235 236 237 333 334 335 336 337";
		String hate = "022 023 122 123 222 223 224 225 226 227";
 		if(tendency.equals("yes")){
			if(sad.contains(emotion)){
				emotion = "111";
			}else if(hate.contains(emotion)){
				emotion = "555";
			}
 		}
 		return emotion;
	}
}
