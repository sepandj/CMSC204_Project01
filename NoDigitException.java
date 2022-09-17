
public class NoDigitException extends Exception {
	private static final long serialVersionUID = 1;

	public NoDigitException() {
		super("The password must contain at least one digit");
	}

}
