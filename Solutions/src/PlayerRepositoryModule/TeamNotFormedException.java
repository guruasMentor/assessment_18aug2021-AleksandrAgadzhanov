package PlayerRepositoryModule;

public class TeamNotFormedException extends Exception {

	private static final long serialVersionUID = -6597859621838746928L;

	
	
	public TeamNotFormedException(String message) {
		super(message);
	}

	//Mentor Comment: Need to add more constructors so that you can chain with all the existing constructors in super class

}
