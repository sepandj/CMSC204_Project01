
public class NoLowerAlphaException extends Exception {
	private static final long serialVersionUID = 2;
	
	public NoLowerAlphaException(){
		super("The password must contain at least one lowercase alphabetic character");
	}
}
