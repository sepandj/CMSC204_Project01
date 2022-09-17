
public class WeakPasswordException extends Exception {
	private static final long serialVersionUID = 6;
	
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters.");
	}
}
