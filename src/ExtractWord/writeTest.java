package ExtractWord;

import org.apache.lucene.analysis.ko.morph.MorphException;

import ExtractWord.extractword;

public class writeTest {
	public static void main(String[] args){
		test("t");
	}
	public static boolean test(String str) {
		extractword e = new extractword();
		try {
			extractword.extracting(str);
		} catch (MorphException e1) {
			e1.printStackTrace();
		}

		//String sss="committest";
		
		return true;
		
		
		
	}
}
