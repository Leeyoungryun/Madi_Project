package emotionExtractor;

import org.apache.lucene.analysis.ko.morph.MorphException;

public class Main {

	public static void main(String[] args) throws MorphException {
		// TODO Auto-generated method stub

		String picture = "sad";
		String path ="C:/Users/inyoung/git/Madi_Project/data/Madi.dat";
		String[] str = { "네가", "점점", "좋아져", "" };
		
		EmotionExtractor.ExtractEmotions(str,picture,path);

	}

}
