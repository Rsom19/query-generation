package firstImplementation;

public class Question {

	//4 parameters title, body, category, question ID
	
	private String title;
	private String body;
	private String category;
	private String qid;
	
	public Question(String title, String body, String category, String qid) {
		this.title = title;
		this.body = body;
		this.category = category;
		this.qid = qid;
	}

	
	
	public Question(String title, String body) {
		this.title = title;
		this.body = body;
	}

		
}
