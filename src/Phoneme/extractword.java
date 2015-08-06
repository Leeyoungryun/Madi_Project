package Phoneme;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.analysis.kr.morph.MorphException;

public class extractword {
	static TextMorphAnalyzer k_analyzer= new TextMorphAnalyzer();
	
	public static void main(String[] args) throws IOException, MorphException {
		// TODO Auto-generated method stub
		extracting("우리가 사랑한시간은 얼마나 긴지");
		
	}
	
	/**
	 * 텍스트를 입력 받아 감성을 추출
	 * 
	 * @param string
	 *            감성 분석을 원하는 텍스트
	 * @throws MorphException
	 * @throws WebSearchException
	 */
	public static void extracting(String input) throws MorphException {
		TextMorphAnalyzer k_analyzer= new TextMorphAnalyzer();
		
		String spaced= k_analyzer.wordSpaceAnalyze(input);
		String[] verbs= k_analyzer.extractVerb(spaced);
		
			String[] guided = k_analyzer.guideWord(spaced); 
		
		for(int i=0; i<guided.length; i++){
			System.out.println(guided[i]);
			}

	
		if(verbs.length==0){
		}
		else{
			
		}
	
	}
	
	public static void justExtract(String input) throws MorphException
	{
		
		TextMorphAnalyzer k_analyzer= new TextMorphAnalyzer();

		String spaced= k_analyzer.wordSpaceAnalyze(input);
		String[] verbs= k_analyzer.extractVerb(spaced);
		if(verbs.length==0){
			
		}
	
		else if(verbs.length>=2)
		{
			String[] sentences;
			ArrayList arr= new ArrayList();
			
			for(int i=0; i<verbs.length; i++)
			{
			
			}
		}

	}
	
	public static void splitWithVerb(String input) throws MorphException
	{
		ArrayList sentenc
		
		es= new ArrayList();
		String[] verbs= k_analyzer.extractVerb(input);
		int[] verb_index = null;
		for(int i=0; i<verbs.length; i++){
			verb_index[i]=input.indexOf(verbs[i]);//동사의 인덱스번호 저장
		}
		for(int i=0; i<verb_index.length; i++)
		{
		sentences.add(input.substring(, verb_index[i])
		}
	
	}
	

}

