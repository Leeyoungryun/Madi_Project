package ExtractWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.ko.morph.MorphException;

import KoreanAnalyzer.TextMorphAnalyzer;
import KoreanAnalyzer.WordSegmentAnalyze;
import Phoneme.PhonemeExtractor;

/**
 * 텍스트를 입력 받아 키워드를 추출
 * 
 * @param string
 *            키워드 분석을 원하는 텍스트
 * @throws MorphException
 * 
 */


public class extractword {
	static TextMorphAnalyzer k_analyzer= new TextMorphAnalyzer();
	
	public static void main(String[] args) throws IOException, MorphException {
		// TODO Auto-generated method stub
		
		
		extractFromTxt("data/0725.txt");
		
	/*	String[] Words=extracting("사랑해");
		for(int i=0; i<Words.length; i++)
		{
			System.out.println();
			System.out.println(Words[i]);
		}
	*/	
		
	}
	
	

	public static String[] extracting(String input) throws MorphException {
		TextMorphAnalyzer k_analyzer= new TextMorphAnalyzer();
		input=input.trim();
		
		WordSegmentAnalyze ws_analyzer= new WordSegmentAnalyze(input, false);

		
		String segmented= ws_analyzer.segmented.toString();
	
		 // 띄어쓰기
		
		System.out.println(segmented);
		String temp2 = k_analyzer.morphAnalyze(segmented).toString();
		String[] verbs = k_analyzer.extractVerb(segmented);// 동사 추출
		String temp = "";
		String str = "";
		String[] guide = k_analyzer.guideWord(segmented); // 색인 추출
		String[] extractedWord= new String[2];
		for(int i=0; i<guide.length; i++){ 
		}
		
		/**
		 * 특징 1번째 명사
		 */
		String[] temp3 = temp2.split(" ");
		String[] temp4 = new String[4000];
		
		int wordcount = 0;
		for (String t : temp3) {
			// System.out.println(t);
			String[] word = t.split(",");
			for (String w : word) {
				boolean check = false;
				for (int i = 0; i < w.length(); i++) {
					if (w.charAt(i) == 'N') {
						check = true;
						break;
					}
				}
				if (check)
					temp4[wordcount] = w;
				// System.out.println(w);
				wordcount++;
				// System.out.println(wordcount);
			}
		}


		/**
		 * 특징 2번째 동사
		 */
		
		if (verbs.length == 0) { // 동사가 없을때
			str = str + guide[guide.length - 1]; // 색인 마지막 인덱스에 있는 단어 추출
			// System.out.println("===동사가 없을때===" + str);
		} else { // 동사가 있을때
			for (int i = 0; i < verbs.length; i++) {
				if (verbs[i] != null) { // 동사값이 NULL이 아닐때
					if (verbs[i].matches(".*다")) { // 동사가 "다"로 끝나면
						 str = temp + verbs[i]; // temp에 동사를 합해서 str에 넣어준다
						// System.out.println("===동사가 다 끝날때===" + str);
						//str = verbs[i];
						temp = ""; // temp 초기화
					} else { // 동사값이 NULL 값일때
						// temp = temp + verbs[i];

					}

				}

			}

		}
		
		/**
		 * 특징 3번째 색인어
		 */

		String textResult = "";

	
		if (input != null) {
			if (guide.length > 0) {
				textResult = guide[guide.length / 2];
			}
		}
		
		
		if (str.length() == 0) {
			if (guide.length != 0) {
				str = guide[guide.length-1];
			} else {
				str = guide[0];
			}
		}
		extractedWord[0]=textResult;
		extractedWord[1]=str;
		
		System.out.println(extractedWord[0]+""+extractedWord[1]);
		//.out.println(extractedWord[1]);
		return extractedWord;
	
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
	
	
	
	public static void extractFromTxt(String dataPath) throws MorphException, IOException 
	{
	
		File fi = new File(dataPath);	
		String path = fi.getPath().substring(0, fi.getPath().length() - fi.getName().length());
		String fileName = path + "ex_"+ fi.getName().split("[.]")[0] + ".txt";
		File fo = new File(fileName);
		
		BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(fi)));
		PrintWriter fout = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fo)));
		
		String buf = null;
	
		while((buf = fin.readLine()) != null){
			buf = buf.replace("\"", "");
			buf = buf.replace("'", "");
			
			
			String[] data = buf.split("\t");//문장을 탭으로 쪼개서 배열에 저장 
			String emotion = data[1];//맨끝에있는 감정을   emotion 에 저장
			
			//두단어뽑기
			String[] extracted =extracting(data[0]);
		
			fout.println(extracted[0]+ "\t" + extracted[1] + "\t"  + emotion);
			System.out.println(extracted[0]+ "\t" + extracted[1] + "\t"  + emotion);
		}
		
		fin.close();
		fout.flush();
		fout.close();
		
	}


}

