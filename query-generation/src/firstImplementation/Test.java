package firstImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Test {

	public static void main(String args[])throws IOException, InterruptedException{
		/*
		String question = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
		
		while (true) {
			if (question == null) { // prompt the user
				System.out.println("Enter your question: ");
			}

			String line = question != null ? question : in.readLine();
			
			
			if (line == null || line.length() == -1) {
				break;
			}

			line = line.trim();
			if (line.length() == 0) {
				break;
			}

			// send question 
			QueryGeneration queryGeneration = new QueryGeneration();
			
			String query="";
					
			
			//server.getAnswerAndResourcesAndSummaries(String.valueOf(++qidDummy), line, "", "");
			
			System.out.println("Question is : " + question);
			System.out.println("Query is : " + query);
			
			
			if (question != null) {
				break;
			}
		}
		*/
		
		String trial = "how is everyone?Where is everyone?";
		System.out.println("Trial : " + trial);
		
		KeywordGenerator keywordGenerator = new KeywordGenerator(trial);
		
		trial = keywordGenerator.stopwordRemover(trial);
		System.out.println("Trial : " + trial);
	}
}
