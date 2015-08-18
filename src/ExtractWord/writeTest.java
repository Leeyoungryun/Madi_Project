package ExtractWord;

import org.apache.lucene.analysis.ko.morph.MorphException;

import ExtractWord.extractword;

public class writeTest {
	public static void main(String[] args){
		test("t");
	}
	public static String test(String str) {
		String emotion = null;
		extractword e = new extractword();
		try {
			extractword.extracting(str);
			emotion = "happy";
		} catch (MorphException e1) {
			e1.printStackTrace();
		}
		
		return emotion;
	}
}
