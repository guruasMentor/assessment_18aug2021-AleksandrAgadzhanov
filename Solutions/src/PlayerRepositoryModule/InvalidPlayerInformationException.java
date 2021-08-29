package PlayerRepositoryModule;

public class InvalidPlayerInformationException extends Exception {

	private static final long serialVersionUID = 1179052280883463394L;

	
	
	public InvalidPlayerInformationException(String message) {
		super(message);
	}

//Mentor Comment: Need to add more constructors so that you can chain with all the existing constructors in super class
}
