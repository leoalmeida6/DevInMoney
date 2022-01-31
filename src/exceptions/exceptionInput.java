package exceptions;

public class exceptionInput extends Exception{
	
	public exceptionInput(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	private boolean verifyLastNames(String lname) {
		
		lname = lname.trim();
		if(lname == null || lname.equals(""))
			return false;
		
		if(!lname.matches("[a-zA-Z]*"))
			return false;
		
		return true;
	}

}
