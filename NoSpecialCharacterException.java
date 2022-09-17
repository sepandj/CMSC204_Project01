
public class NoSpecialCharacterException extends Exception {
	private static final long serialVersionUID = 3;
	
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character ");
	}
}
