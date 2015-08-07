package ExtractWord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.kr.morph.MorphException;

import Phoneme.PhonemeExtractor;

/**
 * 텍스트를 입력 받아 감성을 추출
 * 
 * @param string
 *            감성 분석을 원하는 텍스트
 * @throws MorphException
 * 
 */


public class extractword {
	static TextMorphAnalyzer k_analyzer= new TextMorphAnalyzer();
	
	public static void main(String[] args) throws IOException, MorphException {
		// TODO Auto-generated method stub
		justExtract("우리가 사랑한 시간은 긴가");
		
	}
	

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
		String spaced= k_analyzer.wordSpaceAnalyze(input);
		splitWithVerb(spaced);
	

	}
	
	
	/**
	 * 동사를 기준으로 문장을 구분
	 * 
	 * @param string
	 *            띄어쓰기가 된 감성 분석을 원하는 텍스트
	 * @throws MorphException
	 */
	
	public static void splitWithVerb(String input) throws MorphException
	{
		System.out.println(input);
		String[] sentences=null;
		String[] verbs= k_analyzer.extractVerb(input);		
		String[] guided = k_analyzer.guideWord(input); 
		
		System.out.println(verbs.length);

		List<Integer> verb_index= new ArrayList<Integer>();

		String phonemeInput= PhonemeExtractor.split(input);//들어온 문장을 음운으로
		System.out.println(phonemeInput);
		
		String[] phonemeVerbs=new String[verbs.length];//
		for(int i=0; i<verbs.length; i++)//추출된 동사를 음운으로
		{
			phonemeVerbs[i]=PhonemeExtractor.split(verbs[i]);
			System.out.println(phonemeVerbs[i]);
		}
		
		/*동사의 인덱스찾기*/
		
		
		for(int i=0; i<phonemeVerbs.length; i++){
			if(phonemeVerbs[i]!=null){
			System.out.println(phonemeInput.indexOf(phonemeVerbs[i].toString()));
		verb_index.add(phonemeInput.indexOf(phonemeVerbs[i].toString()));
			//System.out.println(verb_index.get(i));//동사의 인덱스번호 저장
			}
		}
	
	}
	


}

