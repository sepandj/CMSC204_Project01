
public class UnmatchedException extends Exception {
	private static final long serialVersionUID = 7;
	
	public UnmatchedException() {
		super("The passwords do not match.");
	}
}
