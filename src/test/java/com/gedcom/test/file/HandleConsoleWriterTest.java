package com.gedcom.test.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleConsoleReader;
import com.gedcom.file.HandleConsoleWriter;

public class HandleConsoleWriterTest {
	@Test
	public void HandleConsoleWriterCreateTest() throws GedcomParserException{
		HandleConsoleReader handler =  new HandleConsoleReader();
		assertNotNull(handler);
		handler.close();
	}
	
	@Test 
	public void HandleConsoleWriterWriteTest() throws GedcomParserException{	
		ByteArrayOutputStream outCont = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(outCont);
	    System.setOut(ps);
	    HandleConsoleWriter handler =  new HandleConsoleWriter();
		
		String line = "hello Mr";
		handler.write(line);
		
		handler.close();
		System.setOut(System.out);
		
		//we need to check only after flush/close the handler, since it could be be buffering till filled up 
		assertEquals("hello Mr", outCont.toString());
	}
	
	@Test(expected = GedcomParserException.class)
	public void HandleConsoleWriterCloseTest() throws GedcomParserException{
		HandleConsoleWriter handler =  new HandleConsoleWriter();
		assertNotNull(handler);
		handler.close();
		String line = "hi";
		handler.write(line);
	}
}
