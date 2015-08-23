package ExtractWord;

import java.util.ArrayList;
import java.util.Collections;

public class Emotionform2 {
	public static String chooseEmotion(String[] input,String picture){
		System.out.println("픽쳐"+picture);
		String[] Emotions={input[0],input[1],input[2]};
		String sentence=input[3];
		
		ArrayList<String> FinalEmotions=new ArrayList<String>();
	
		boolean sameWithSentence= false;//합친문장의 감정의 각각의 감정과 겹치는지
		boolean sameWithPicture= false;
			
		//먼저 앞의 세개감정을검사한다.
		for(int i=0; i<Emotions.length; i++){	
			if(Emotions[i]!="natural" ){
				FinalEmotions.add(Emotions[i]);
				if(Emotions[i]==sentence){
					sameWithSentence=true;
				}			
				if(Emotions[i]==picture){
				}
			}
		}
		
		if(FinalEmotions.size()<3){
			if(FinalEmotions.size()==1){
				FinalEmotions.add(sentence);		
			}	
			if(FinalEmotions.size()==0 && sameWithSentence==false){
				FinalEmotions.add(sentence);
			}
			if(FinalEmotions.size()<3 && sameWithPicture==true){
				FinalEmotions.add(picture);
			}
			if(FinalEmotions.size()<2 &&sameWithPicture==false){
				FinalEmotions.add(picture);
			}
			if(FinalEmotions.size()<3 && sentence==picture){
					FinalEmotions.add(picture);
			}
						
			while(FinalEmotions.size()<3){
				FinalEmotions.add("natural");
			}
		}

		System.out.println(FinalEmotions.size());
		for(int i=0; i<FinalEmotions.size(); i++)
		{
				System.out.println("test중"+FinalEmotions.get(i));
		}
		FinalEmotions=sortEmotions(FinalEmotions);
		
		StringBuilder aa = new StringBuilder();
		for(int i=0; i<FinalEmotions.size() ;i++){
			aa.append(FinalEmotions.get(i));
		}
		//System.out.println(aa.toString());
		
		return aa.toString();
	}
	
	public static ArrayList<String> sortEmotions(ArrayList<String> Emotions){
		ArrayList<String> int_result = new ArrayList<String>();
		System.out.println("함수안에서"+Emotions.size());
		
		for(int i=0; i<Emotions.size(); i++ ){
			switch(Emotions.get(i)){
			case "love":
				int_result.add("0");
				break;
			case "happy":
				int_result.add("1");
				break;
			case "hate":
				int_result.add("2");
				break;
			case "sad":
				int_result.add("3");
				break;
			case "angry":
				int_result.add("4");
				break;
			case "excite":
				int_result.add("5");
				break;	
			case "expect":
				int_result.add("6");
				break;
			case "natural":
				int_result.add("7");
				break;	
			}
		}
			
		System.out.println(int_result.size());
		Collections.sort(int_result);
		return int_result;
	}
}

