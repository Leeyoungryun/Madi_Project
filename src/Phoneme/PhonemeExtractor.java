package Phoneme;
import java.util.ArrayList;

public class PhonemeExtractor {

	public static int BASE_LETTER_CODE = 0xAC00, END_LETTER_CODE = 0xD7AF; 

	private static final char[] CHO = 
			/*ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ ㅁ ㅂ ㅃ ㅅ ㅆ ㅇ ㅈ ㅉ ㅊ ㅋ ㅌ ㅍ ㅎ */
		{0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145,
			0x3146, 0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
	private static final char[] JUN = 
			/*ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ*/
		{0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158,
			0x3159, 0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160,	0x3161,	0x3162,
			0x3163};
			/*X ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ*/
	private static final char[] JON = 
		{0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a,
			0x313b, 0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145,
			0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
	
	public static boolean isKorean(char code){
		boolean rst = false;
		
		if(code >= BASE_LETTER_CODE && code <= END_LETTER_CODE){
			rst = true;
		}
		
		return rst;
	}
	
	//issue: 영어가 들어왔을때 어떻게할것인가.
	
	public static String split(String string){
		ArrayList<Character> line = new ArrayList<Character>();//초,중,종성을 저장할 어레이리스트
		
		for(char item:string.toCharArray()){
			if(isKorean(item)){
				char uniVal = (char) (item - 0xAC00);
				
				char cho = (char) (((uniVal - (uniVal % 28))/28)/21);
				char jun = (char) (((uniVal - (uniVal % 28))/28)%21);
				char jon = (char) (uniVal %28);
				
				line.add(CHO[cho]);
				line.add(JUN[jun]);
				
				//종성이 없을수도 있으므로
				if((char)jon != 0x0000){
					line.add(JON[jon]);					
				}
			}
			else{
				line.add(item);//한글이 아닐 경우 일단 그냥 add
			}
		}
		
		StringBuilder strBuild = new StringBuilder("");//배열을 하나의 스트링으로 만들기 위해.
		//stringbuilder 가 문자열의 반복적인 수정에는 좋다.그냥string을 계속 수정할경우 성능저하를 일으킬 수 있다.
		for(char item:line){
			strBuild.append(item);
		}
		
		return strBuild.toString();//ㄱㅏㅁㅅㅏ
	}
	
}
