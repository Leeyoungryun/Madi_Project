package ExtractWord;

import java.util.ArrayList;

public class Emotionform2 {
	
	public static String chooseEmotion(String[] input,String picture)
	{
		String[] Emotions={input[0],input[1],input[2]};
		String sentence=input[3];
	
		ArrayList<String> FinalEmotions=new ArrayList<String>();
		boolean sameWithSentence= false;//합친문장의 감정의 각각의 감정과 겹치는지
		boolean sameWithPicture= false;
		
		
		//먼저 앞의 세개감정을검사한다.
		for(int i=0; i<Emotions.length; i++){
			
			if(Emotions[i]!="natural" )
			{
				FinalEmotions.add(Emotions[i]);
				if(Emotions[i]==sentence){
					sameWithSentence=true;
				}			
				if(Emotions[i]==picture){
					
				}
			}
		}
		
		if(FinalEmotions.size()<3)
		{
			if(FinalEmotions.size()==1 && sameWithSentence==true)
			{
				FinalEmotions.add(sentence);		
			}	
			if(FinalEmotions.size()==0 && sameWithSentence==false)//앞세개의 감정이 없을경우
			{
				FinalEmotions.add(sentence);
			}
			if(FinalEmotions.size()<3 && sameWithPicture==true)
			{
				FinalEmotions.add(picture);
			}
			if(FinalEmotions.size()<2 &&sameWithPicture==false)
			{
				FinalEmotions.add(picture);
			}
			if(FinalEmotions.size()<3 && sentence==picture)
				{
					FinalEmotions.add(picture);
			
				}
			
			FinalEmotions=sortEmotions(FinalEmotions);
			while(FinalEmotions.size()<3)
			{
				FinalEmotions.add("natural");
			}
		
		}
		
		StringBuilder aa = new StringBuilder();
		for(int i=0; i<FinalEmotions.size() ;i++){
		aa.append(FinalEmotions.get(i));
		}
		System.out.println(aa.toString());
		return aa.toString();	
	}
	
	public static ArrayList<String> sortEmotions(ArrayList<String> Emotions)
	{
		return Emotions;
		
	}

}

