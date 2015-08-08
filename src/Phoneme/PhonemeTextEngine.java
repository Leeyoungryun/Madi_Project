/**
 * 학습된 분류기를 파일로 저장하고 불러와서 감정을 추출할 수 있게 하기위한 클래스
 * (학습된 분류기와 감정추출을 위한 함수들을 포함한다)
 */
package Phoneme;

import java.io.*;

import org.apache.lucene.analysis.kr.morph.MorphException;


public class PhonemeTextEngine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PhonemeKernelClassifier classifier = null;
	private String emotion = null;

	/**
	 * 학습된 음운기반 텍스트 감성인지 객체 생성
	 * 
	 * @param parent
	 *            호출된 객체 레퍼런스(일반적으로 this)
	 * @param 학습된 classifier
	 *          
	 * @return 학습된 classifier를 포함하는 PhonemeTextEngine 객체
	 * @throws IOException
	 */
	public static PhonemeTextEngine getLearnedInstance(PhonemeKernelClassifier classifier)
			throws IOException {
		PhonemeTextEngine textEmotion = new PhonemeTextEngine();

		textEmotion.classifier = classifier;

		return textEmotion;
	}

	protected PhonemeTextEngine() {
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
		String word1 = null,word2 = null;//뽑아낼 두 단어
		
		//
		//여기에 단어추출알고리즘이 들어가야함!!!
		//
		
		int result = classifier.classifyEmotion(word1 + "\t" + word2);
		

		switch(result)
		{
			case 1 :
			emotion="angry";
			case 2: 
				emotion ="";
			case 3:
				emotion ="";
			case 4:
				emotion ="";
			case 5:
				emotion ="";
			case 6:
				emotion ="";
			case 7:
				emotion ="";
		}
		return emotion;
	}
	


	/**
	 * 감성 추출(7가지 감성)
	 * 
	 * @return String 타입의 감성
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
