package com.gedcom.exception;

public class GedcomParserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2769772159863161926L;
	/**
	 * 
	 */
	
	private String message = null;
	
	public GedcomParserException() {
        super();
    }
 
    public GedcomParserException(String message) {
        super(message);
        this.message = message;
    }
 
    public GedcomParserException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }

}
