package PlayerRepositoryModule;

public class PlayerAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1336174504415761231L;

	
	
	public PlayerAlreadyExistsException(String message) {
		super(message);
	}

	//Mentor Comment: Need to add more constructors so that you can chain with all the existing constructors in super class

}
