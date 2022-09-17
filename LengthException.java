
public class LengthException extends Exception {
	private static final long serialVersionUID = 0;
	
	public LengthException() {
		super("The password must be at least 6 characters long.");
	}
}
