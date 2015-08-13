package KoreanAnalyzer;

import java.util.List;

import org.apache.lucene.analysis.ko.WordSegmentFilter;
import org.apache.lucene.analysis.ko.morph.AnalysisOutput;
import org.apache.lucene.analysis.ko.morph.MorphAnalyzer;
import org.apache.lucene.analysis.ko.morph.MorphException;
import org.apache.lucene.analysis.ko.morph.WordSegmentAnalyzer;
import org.apache.lucene.analysis.kr.morph.WordSpaceAnalyzer;

public class WordSegmentAnalyze {

	
	public static void main(String[] args) throws MorphException, org.apache.lucene.analysis.kr.morph.MorphException{
	MorphAnalyzer Ana= new MorphAnalyzer();
	
		//TextMorphAnalyzer aaa= new TextMorphAnalyzer();
		String ss=wordSegmentAnalyze("혼자있어도 난슬프지않아",false);
		System.out.println(ss);
 
		
	}
	
	
	 public static String wordSegmentAnalyze(String source, boolean force) throws MorphException {
	        StringBuilder result = new StringBuilder();
	       
	        WordSegmentAnalyzer sss= new WordSegmentAnalyzer();
	        String s="";
	        if(force)
	            s = source.replace(" ", "");
	        else
	            s = source;
	        @SuppressWarnings("unchecked")
			List<List<AnalysisOutput>> outList = sss.analyze(s);
	    
	     
	        for(List<AnalysisOutput> o: outList) {
	        
	        
	        	for(AnalysisOutput a:o){
	        		
	            result.append(a.getSource()).append(" ");
	        	System.out.println(a.getSource());
	        	}
	        	
	        }

	        return result.toString();
	    }
	
}
