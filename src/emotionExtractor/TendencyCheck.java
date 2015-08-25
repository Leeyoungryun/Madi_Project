package emotionExtractor;

public class TendencyCheck {
	public static String result(String tendency, String emotion){
		String sad = "033 133 233 234 235 236 237 333 334 335 336 337 377";
		String hate = "022 023 122 123 222 223 224 225 226 227";
 		if(tendency.equals("yes")){
 			System.out.println();
			if(sad.contains(emotion)){
				emotion = "111";
				System.out.println("** 성향에 따라 감정 수정**");
				System.out.println("sad -> happy");
			}else if(hate.contains(emotion)){
				emotion = "555";
				System.out.println("** 성향에 따라 감정 수정**");
				System.out.println("hate -> excite");
			}
 		}
 		return emotion;
	}
}
