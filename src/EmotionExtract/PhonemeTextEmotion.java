/**
 * 
 */
package EmotionExtract;

import java.io.*;

import org.apache.lucene.analysis.kr.morph.MorphException;

import ExtractWord.TextMorphAnalyzer;
import Phoneme.PhonemeKernelClassifier;


/**
 * @author CrossPendent
 * 
 */
public class PhonemeTextEmotion implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 5522966953158140000L;

	private PhonemeKernelClassifier classifier = null;
	private String emotion = null;

	/**
	 * 학습된 음운기반 텍스트 감성인지 객체 생성
	 * 
	 * @param parent
	 *            호출된 객체 레퍼런스(일반적으로 this)
	 * @param datasetPath
	 *            데이터 셋 파일(일반적인 텍스트형태의 확장자는 txt, 음운으로 분리된 데이터셋의 확장자는 arff)
	 * @return 학습된 PhonemeTextEmotion 객체
	 * @throws IOException
	 */
	public static PhonemeTextEmotion getLearnedInstance(String datasetPath)
			throws IOException {
		PhonemeTextEmotion textEmotion = new PhonemeTextEmotion();

		textEmotion.classifier = new PhonemeKernelClassifier(datasetPath, 3,
				0.8, true);

		return textEmotion;
	}

	protected PhonemeTextEmotion() {
		// TODO Auto-generated constructor stub

		this.emotion = new String();
	}


	/**
	 * 텍스트를 입력 받아 감성을 추출
	 * 
	 * @param string
	 *            감성 분석을 원하는 텍스트
	 * @throws MorphException
	 * @throws WebSearchException
	 */
	public String putData(String string) throws MorphException {
		String emotion = "";
		TextMorphAnalyzer k_Analyzer = new TextMorphAnalyzer();

		String input1 = string;
		String input2 = k_Analyzer.wordSpaceAnalyze(input1); // 띄어쓰기
		String temp2 = k_Analyzer.morphAnalyze(input2).toString();
		String[] verbs = k_Analyzer.extractVerb(input2);// 동사 추출
	
		String word1 = null,word2 = null;//뽑아낼 두 단어
		
		//
		//여기에 단어추출알고리즘이 들어가야함
		//
		
		int result = classifier.classifyEmotion(word1 + "\t" + word2);
		
	
//		int result = classifier.classifyEmotion(temp10 + "\t" + str);

		return emotion;
	}

	/**
	 * 감성 추출(6가지 감성)
	 * 
	 * @return EmoInfo 타입의 감성
	 * @throws MorphException 
	 */
	public String getEmotion(String string) throws MorphException {
		emotion = putData(string);
		
		return emotion;
	}

	/***
	 * 문자들의 감성을 순서대로 추출
	 * 
	 * @param string
	 * @return
	 */
	public String[] getLinearEmotion(String[] string) {
		String[] emotions = new String[string.length];
		for (int i = 0; i < string.length; i++) {
			try {
				emotions[i] = putData(string[i]);

			} catch (MorphException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emotions;
	}


}
