package Phoneme;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;



public class phoneme_test {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		PhonemeKernelClassifier Classifier = new PhonemeKernelClassifier("data/featureTWO.txt", 3,
				0.8, true);
		PhonemeTextEngine TextEmotion = PhonemeTextEngine.getLearnedInstance(Classifier);
		
		//데이터셋을 학습한 SVM을 파일로 저장
		ObjectOutputStream dat = new ObjectOutputStream(new FileOutputStream("data/featureTWO.dat"));
		//ObjectOutputStream: 객체 안에 저장되어 있는 내용을 파일로 저장하거나 네트워크를 통하여 다른 곳으로 전송하기위해 사용
		dat.writeObject(TextEmotion);
		dat.flush();//stream에 남아 있는 데이터를 강제로 내보내는 역할
		dat.close();
	}
}
