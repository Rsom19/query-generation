package firstImplementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.util.Version;

public class KeywordGenerator {

	private String text;
	
	
	public KeywordGenerator(String text){
		this.text = text;
		//this.text = stopwordRemover(this.text);
		this.text = stemmer(this.text);
		
	}

	public String stopwordRemover(String text) {
		
		CharArraySet stopWords = new CharArraySet(0, true);
		
		//Read the stopwords file to get CharArraySet of stop words
		try{
		FileInputStream fileInputStream = new FileInputStream(new File("ranksNLStopwords.txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
	 
		String stopword = "";
		
		while ((stopword = bufferedReader.readLine()) != null) {
			stopWords.add(stopword);
		}
	 
		bufferedReader.close();
		
		Analyzer analyzer  = new StandardAnalyzer(stopWords);
		
		TokenStream tokenStream = new StandardTokenizer();
		tokenStream = new StopFilter(tokenStream, stopWords);
		tokenStream.reset();
	    StringBuilder sb = new StringBuilder();
	    CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
	    
	    //tokenStream.reset();
	    while (tokenStream.incrementToken()) {
	        String term = charTermAttribute.toString();
	        sb.append(term + " ");
	    }
	    tokenStream.end();
	    tokenStream.close();
	    
	    		text = sb.toString();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		
		
		return text;
	}
	
	private String stemmer(String text){
		return text;
	}
	
}
