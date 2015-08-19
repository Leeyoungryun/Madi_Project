package Phoneme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;

import weka.classifiers.*;
import weka.classifiers.functions.*;
import weka.classifiers.functions.supportVector.*;
import weka.core.*;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * arff 파일을 생성하고 생성한 파일로 svm 분류기 객체를 생성하는 클래스
 * @parameter 텍스트파일
 * 텍스트파일을 음운으로 쪼개기위해 phonemeExtractor 의 split 함수 호출
 */

public class PhonemeKernelClassifier implements Serializable{
	
	
	private SMO svm = null;// smo 객체생성
	private Instances data;
	private boolean debug = false;
	
	public PhonemeKernelClassifier(String dataPath, int subsequenceLength, double lambda, boolean debug) throws IOException{
		try {
			this.debug = debug;
			String[] path = dataPath.split("[.]");
			
			// 음운으로 변환된 arff파일이 아닐 경우, 음운 형태로 변환 
			String arffPath = (!path[path.length-1].equals("arff"))?convertToPhoneme(dataPath):dataPath;
			svm = createLearnedSVM(arffPath, subsequenceLength, lambda);//svm(smo) 분류기 생성.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException("음절커널>> 데이터셋파일을 열수 없습니다.");
		}		
	}
	
	public PhonemeKernelClassifier(String dataPath) throws IOException{
		this(dataPath, 3, 0.7, false);
	}
	
	private String convertToPhoneme(String arg) throws IOException{
		File fi = new File(arg);	
		String path = fi.getPath().substring(0, fi.getPath().length() - fi.getName().length());
		String fileName = path + fi.getName().split("[.]")[0] + ".arff";
		File fo = new File(fileName);//arff 파일 이름 지정. 파일 만들기
		
		BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(fi)));
		PrintWriter fout = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fo)));
		
		String buf = null;
		fout.println("@relation sentiment");
		fout.println("@attribute 0 string");
		fout.println("@attribute 1 string");
		// fout.println("@attribute 2 string");
		fout.println("@attribute 2 {happy,angry,sad,joy,love,hate,expect,natural}");
		fout.println("@data");
		
		while((buf = fin.readLine()) != null){
			buf = buf.replace("\"", "");
			buf = buf.replace("'", "");
			String[] data = buf.split("\t");//문장을 탭으로 쪼개서 배열에 저장 
			String emotion = data[2];//맨끝에있는 감정을   emotion 에 저장
			
			//모델크리에이터에 들어가는 txt 는 이미 두단어(두특징)가 뽑아진 txt 파일이어야한다다.
			
			String temp = data[0];//첫번째 단어
			String temp2 = data[1];//두번째 단어(특징)
			//String temp3 = data[2];
			
			String sentance = PhonemeExtractor.split(temp);//텍스트파일을 음운으로 쪼개기위해 phonemeExtractor 의 split 함수 호출
			String sentance2 = PhonemeExtractor.split(temp2);
			//String sentance3 = PhonemeExtractor.split(temp3);
						
			fout.println("'" + sentance + "'" + ","+"'" + sentance2 + "'" +  "," + emotion);
		}
		
		fin.close();
		fout.flush();
		fout.close();

		return fileName;
	}
	
	public int classifyEmotion(String text){
		String phnText = PhonemeExtractor.split(text);
		
		Instance inst = new DenseInstance(2);
		inst.setDataset(data);
		inst.setValue(0, phnText);
		int result = 0;
		
		try {
			result = (int)svm.classifyInstance(inst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return result;
	}
	

	/**
	 * svm(smo) 분류기를 생성하고 학습시킨다.
	 * @parameter arff 파일 
	 * 입력받은 arff 파일로 svm 분류기를 학습시킨다.
	 */
	protected SMO createLearnedSVM(String dataset, int subsequenceLength, 
			double lambda)	throws Exception{
		SMO smo = new SMO();
		
		data = DataSource.read(dataset);
		
		data.setClassIndex(data.numAttributes() - 1);
		
		StringKernel kernel = new StringKernel(data, 250007, subsequenceLength, lambda, debug);
		smo.setKernel(kernel);
		smo.buildClassifier(data);
		
		return smo;
	}

}