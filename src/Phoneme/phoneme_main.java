package Phoneme;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Phoneme.PhonemeKernelClassifier;

public class phoneme_main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PhonemeKernelClassifier svmClassifier = new PhonemeKernelClassifier("data/featureTWO.txt", 3,
				0.8, true);
		

	}

	
	
	
}
