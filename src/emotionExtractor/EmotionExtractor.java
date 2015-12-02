package emotionExtractor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import Phoneme.PhonemeTextEngine;


public class EmotionExtractor {
	public static String test(String[] str, String back) {
		
		String picture = back;
		String webPath = EmotionExtractor.class.getClassLoader().getResource("").getPath();
		String path = EmotionExtractor.class.getClassLoader().getResource("").getPath().substring(0, webPath.length()-9)+"/Madi.dat";
		System.out.println("gg"+path);
		String result=ExtractEmotions(str,picture,path);
		
	return result;

	}
	
	public static String ExtractEmotions(String[] inputStrings, String picture,String path){
		String[] emotion = new String[4];
		StringBuilder sentence = new StringBuilder();
		for (int i = 0; i < inputStrings.length; i++) {
			sentence.append(inputStrings[i]);

		}
		inputStrings[3] = sentence.toString();

		

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					path));


			PhonemeTextEngine textEngine = (PhonemeTextEngine) ois
					.readObject();
			ois.close();
			
			for(int i=0; i<inputStrings.length; i++){
				try {
					emotion[i] = textEngine.getEmotion(inputStrings[i]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("** 감정 결과 **");
			for (int i = 0; i < emotion.length-1; i++) {
				System.out.println((i+1) + ". tag"+ (i+1) + " : "+emotion[i].toString());
			}
			System.out.println("4. tag1+tag2+tag3 : " + emotion[3].toString());
			System.out.println("5. background : " + picture);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		String result = EmotionSelector.choose3Emotions(emotion, picture);
		return result;
		
	}
	
	
	
	
	
}
