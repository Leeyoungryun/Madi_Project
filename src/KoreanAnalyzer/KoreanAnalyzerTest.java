package KoreanAnalyzer;
import java.io.IOException;

import org.apache.lucene.analysis.kr.morph.MorphException;



public class KoreanAnalyzerTest {
	
	public static void main(String[] args) throws IOException, MorphException {
		// TODO Auto-generated method stub
		TextMorphAnalyzer korAnalyzer = new TextMorphAnalyzer();//
		
		String text = "오늘 늦겠다 차막혀서";
		String spacing = korAnalyzer.wordSpaceAnalyze(text);//띄어쓰기를 자동으로 해준느 함수
//		Reader reader = new StringReader(text);
		
		System.out.println("원문: " + text);
		System.out.println();
		
		System.out.println("띄어쓰기: " + spacing);
		System.out.println();
		
		String temp2 =  korAnalyzer.morphAnalyze(spacing).toString();// 형태소 분석 함수
		System.out.println("형태소분석: " + temp2);
		System.out.println();
		
		
		String[] temp3 = temp2.split(" ");
		for(String t : temp3)
		{
		//	System.out.println(t);
			String[] word =t.split(",");
			for(String w : word)
			{
				boolean check = false;
				for(int i=0; i<w.length(); i++)
				{
					if(w.charAt(i)=='N')
					{
						check = true;
						break;
					}
				}
				if(check);
			//		System.out.println(w);
			}
			
		//	System.out.println();
		}
	
		
		//System.out.println("형태소 분석: " + korAnalyzer.morphAnalyze(spacing));
		
		String[] verbs = korAnalyzer.extractVerb(spacing);// 동사추출함수
		String str = "";
		
		for(String item:verbs){
			str += item + " ";
		}
		
		System.out.println("동사 추출: " + str);
		System.out.println();
		
//		System.out.println("복합명사 분해:" + korAnalyzer.compoundNounAnalyze("하늘정원"));

		String[] guide = korAnalyzer.guideWord(spacing);//색인어.
		 System.out.print("색인어 추출: ");
		
		for(int i=0; i<guide.length; i++){
			System.out.print("'" + guide[i] + "' ");
		}
		System.out.println();
		System.out.println(guide[guide.length-1]);
		
		String temp="";
	//	String[] guide = kmu.guideWord(input2);  // 색인 추출
		 if(verbs.length == 0){				//동사가 없을때 
	        	str = str+  guide[guide.length-1];	// 색인 마지막 인덱스에 있는 단어 추출
	     }else{		// 동사가 있을때
	    	  for(int i=0; i<verbs.length; i++){	
	    		  if(verbs[i]!=null){	// 동사값이 NULL이 아닐때
		        	if(verbs[i].matches(".*다")){  //동사가 "다"로 끝나면
		        		str = temp+verbs[i];		//temp에 동사를 합해서 str에 넣어준다
		        		temp = "";	// temp 초기화
		        	}else{	//동사값이 NULL 값일때
		        		temp = temp+ verbs[i];		
		        	}     	
		        }
	    	  }
	    	//  System.out.println("마지막 동사 : " + str);
	     }	
	}


}
