package Phoneme;

import java.io.IOException;



public class phoneme_test {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PhonemeKernelClassifier Classifier = new PhonemeKernelClassifier("data/featureTWO.txt", 3,
				0.8, true);
	}
}
