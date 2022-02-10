package TestAutomation.TestNG.exception;

public class BookDoesNotExist extends Exception {

	public BookDoesNotExist() {
		super();
	}
	
	public BookDoesNotExist(String message) {
		super(message);
	}
}
