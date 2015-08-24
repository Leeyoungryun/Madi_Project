package EmotionExtract;

public class TendencyCheck {
	public static String result(String tendency, String emotion){
 		if(tendency.equals("yes")){
			if(emotion.equals("333")||emotion.equals("377")){
				emotion = "111";
			}else if(emotion.equals("222")||emotion.equals("277")){
				emotion = "555";
			}
 		}
 		return emotion;
	}
}
