package ExtractWord;

import java.io.IOException;

import org.apache.lucene.analysis.kr.morph.MorphException;

import ExtractWord.extractword;

public class writeTest {
	public static void main(String[] args){
		test("t");
	}

	public static boolean test(String str){
		extractword e = new extractword();
		try {
			e.justExtract(str);
		} catch (MorphException e1) {
			e1.printStackTrace();
		}
		
		return true;
	}
}
