package com.gedcom.test.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gedcom.exception.GedcomParserException;

public class GedcomParserExceptionTest {
	class Simple{
		public void foo() throws GedcomParserException{
			throw new GedcomParserException("Hello");
		}		
	}
	@Test
	public void GedcomParserExceptionTestTest() { 
		try{
			Simple obj = new Simple();
			obj.foo();
		 }catch( final GedcomParserException e )
		  {
		    final String msg = "Hello";
		    assertTrue(msg.equals(e.getMessage()));
		  }
	} 

}
