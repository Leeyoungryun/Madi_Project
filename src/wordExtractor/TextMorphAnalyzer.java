package wordExtractor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.lucene.analysis.ko.morph.AnalysisOutput;
import org.apache.lucene.analysis.ko.morph.CompoundEntry;
import org.apache.lucene.analysis.ko.morph.CompoundNounAnalyzer;
import org.apache.lucene.analysis.ko.morph.MorphAnalyzer;
import org.apache.lucene.analysis.ko.morph.MorphException;

public class TextMorphAnalyzer {
    @SuppressWarnings("unchecked")
	public String morphAnalyze(String source) throws MorphException {
        StringBuilder result = new StringBuilder();
        MorphAnalyzer maAnal = new MorphAnalyzer();
        StringTokenizer stok = new StringTokenizer(source, " ");
        while(stok.hasMoreTokens()) {
            String token = stok.nextToken();
            List<AnalysisOutput> outList = maAnal.analyze(token);
            for(AnalysisOutput o: outList) {
                result.append(o).append(" ");
            }
        }
        return result.toString();
    }

    public String[] extractVerbEng(String source) throws MorphException {
		List<String> listWord = new ArrayList<String>();
		String[] words = null;
		words = source.split("\u0020");
		if(words == null){
			words = new String[0];
		}

		for(String item:words){
			if(item != null && item.length() > 1 ){
				listWord.add(item.toLowerCase());
			}
		}
		
		String[] retWords = new String[listWord.size()];
		listWord.toArray(retWords);
		
		return retWords;
    }

    
    public String[] extractVerb(String source) throws MorphException {
    	MorphAnalyzer maAnal = new MorphAnalyzer();
    	StringTokenizer stok = new StringTokenizer(source, " ");
    	List<String> listStr = new ArrayList<String>();
    	
		String tempNoun = null;
    	while(stok.hasMoreTokens()) {
    		String token = stok.nextToken();
    		@SuppressWarnings("unchecked")
			List<AnalysisOutput> list = maAnal.analyze(token);
    		for(AnalysisOutput item:list){
    			if(item.getPos() == 'Z' && item.getScore() >= 50){
    				listStr.add(item.getStem());
    			}
    			if(item.getPos() == 'V' && item.getScore() >= 90){
    				if(!(item.getStem().equals("하") || item.getStem().equals("되"))){
    					listStr.add(tempNoun);
    					tempNoun = null;
    				}
    				listStr.add(((tempNoun !=null)?tempNoun:"") + item.getStem() + "다");
    			}
    			if(item.getPos() == 'N' && item.getVsfx() != null && item.getScore() >= 90){
    				if(item.getVsfx().equals("하") || item.getVsfx().equals("되")){
        				listStr.add(item.getStem() + item.getVsfx() + "다"); 		
    				}
    				else{
    					listStr.add(item.getStem());
    				}
    			}
    			if(tempNoun != null){
    				tempNoun = null;
    			}
    			if(item.getPos() == 'N' && item.getVsfx() == null && item.getScore() >= 90){
    				tempNoun = item.getStem();
    			}
    		}
    	}
    	
    	String[] result = new String[listStr.size()];
    	listStr.toArray(result);
    	
    	return result;
    }
    
    @SuppressWarnings("unchecked")
	public List<AnalysisOutput> morphAnalyzeDetail(String source) throws MorphException{
        MorphAnalyzer maAnal = new MorphAnalyzer();
        StringTokenizer stok = new StringTokenizer(source, " ");
        List<AnalysisOutput> outList = new ArrayList<AnalysisOutput>();
        
        while(stok.hasMoreTokens()) {
            String token = stok.nextToken();
            outList.addAll(maAnal.analyze(token));
        }
    	return outList;
    }


    public String compoundNounAnalyze(String source) throws MorphException {
        StringBuilder result = new StringBuilder();
        CompoundNounAnalyzer cnAnal = new CompoundNounAnalyzer();
        @SuppressWarnings("unchecked")
		List<CompoundEntry> outList = cnAnal.analyze(source);
        for(CompoundEntry o: outList) {
            result.append(o.getWord()).append(" ");
        }

        return result.toString();
    }

	public String[] guideWord(String source) throws MorphException {
 //     StringBuilder result = new StringBuilder();
        MorphAnalyzer maAnal = new MorphAnalyzer();
        StringTokenizer stok = new StringTokenizer(source, " ");
        
        ArrayList<String> listResult = new ArrayList<String>();
        
        while(stok.hasMoreTokens()) {
            String token = stok.nextToken();
			@SuppressWarnings("unchecked")
			List<AnalysisOutput> outList = maAnal.analyze(token);
            listResult.add(outList.get(0).getStem());
/*
            for(AnalysisOutput o: outList) {
                listResult.add(o.getStem());
                boolean first = true;
                for(CompoundEntry s : o.getCNounList()) {
                    if(first) {
                        result.append("(" + s.getWord());
                        first = false;
                    }
                    else {
                        result.append("+" + s.getWord());
                    }
                }
                if(!first)
                    result.append(")");
                result.append(",");
            }
*/
        }
        
        String[] strResult = new String[listResult.size()];
        
        for(int i=0; i<listResult.size(); i++){
        	strResult[i] = listResult.get(i);
        }
        
        return strResult;
    }
    
/*
    public String guideWord(String source) throws MorphException {
        StringBuilder result = new StringBuilder();
        MorphAnalyzer maAnal = new MorphAnalyzer();
        StringTokenizer stok = new StringTokenizer(source, " ");
        while(stok.hasMoreTokens()) {
            String token = stok.nextToken();
            List<AnalysisOutput> outList = maAnal.analyze(token);
            for(AnalysisOutput o: outList) {
                result.append(o.getStem());
                boolean first = true;
                for(CompoundEntry s : o.getCNounList()) {
                    if(first) {
                        result.append("(" + s.getWord());
                        first = false;
                    }
                    else {
                        result.append("+" + s.getWord());
                    }
                }
                if(!first)
                    result.append(")");
                result.append(",");
            }
        }
        String s = result.toString();
        if(s.endsWith(","))
            s = s.substring(0, s.length()-1);
        return s;
    }
*/
	public String removeStopWord(String string){
		string = string.replace(",", " ");
		string = string.replace(".", " ");
		string = string.replace("?", " ");
		string = string.replace("!", " ");
		string = string.replace("\"",  " ");
		string = string.replace("'", " ");
		string = string.replace("~", " ");
		string = string.replace("-", " ");
		string = string.replace("/", " ");
		string = string.replace("-", " ");
		string = string.replace("\\", " ");
		
		return string;		
	}

}
