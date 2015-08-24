package emotionExtractor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.lucene.analysis.ko.morph.MorphException;

import Phoneme.PhonemeTextEngine;

public class main {

	public static void main(String[] args) throws MorphException {
		// TODO Auto-generated method stub

		String picture = "natural";
		String path ="C:/Users/inyoung/git/Madi_Project/data/Madi.dat";
		String[] str = { "나는", "나는", "나는", "" };
		EmotionExtractor.ExtractEmotions(str,picture,path);

	}

}
