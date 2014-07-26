package com.gedcom.test.file;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleConsoleReader;

public class HandleConsoleReaderTest {
	
	@Test
	public void HandleConsoleReaderCreateTest() throws GedcomParserException{
		HandleConsoleReader handler =  new HandleConsoleReader();
		assertNotNull(handler);
		handler.close();
	}
	
	@Test 
	public void HandleConsoleReaderReadTestValidLines() throws GedcomParserException{
		ByteArrayInputStream in = new ByteArrayInputStream("\nMy string\n\t   \n   ".getBytes());
		System.setIn(in);
		
		HandleConsoleReader handler =  new HandleConsoleReader();
		String line = null;
		while((line = handler.read())  != null){
			if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")){
				    continue;
			}
			assertEquals(line, "My string");
	   }
		handler.close();
		System.setIn(System.in);
	}
	
	@Test 
	public void HandleConsoleReaderReadTestEmptyConsole() throws GedcomParserException{	
		ByteArrayInputStream in = new ByteArrayInputStream(new byte[0], 0, 0);
		System.setIn(in);
		
		HandleConsoleReader handler =  new HandleConsoleReader();
		
		@SuppressWarnings("unused")
		String line = null;
		boolean checkFlag =  false;
		if((line = handler.read())  != null){
			checkFlag = true;
		}
		assertFalse(checkFlag);
	
		handler.close();
		System.setIn(System.in);
	}
	
	@Test(expected = GedcomParserException.class)
	public void HandleConsoleReaderCloseTest() throws GedcomParserException{
		HandleConsoleReader handler =  new HandleConsoleReader();
		assertNotNull(handler);
		handler.close();
		@SuppressWarnings("unused")
		String x  = handler.read();
	}
}