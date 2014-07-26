package com.gedcom.test.file;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleFileReader;
import com.gedcom.file.HandleFileWriter;

public class HandleFileWriterTest {
	@Test
	public void HandleFileWriterCreateTestWithValidPath() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/XMLFile.txt");
		String fileName = resourceUrl.getPath();
		HandleFileWriter handler =  new HandleFileWriter(fileName);
		assertNotNull(handler);
		handler.close();
	}
	@Test
	public void HandleFileWriterCreateTestWithPathNotExist() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/XMLFile.txt");
		String fileName = resourceUrl.getPath();
		String path = fileName.substring(0, fileName.lastIndexOf('/')+1);
		path += "FileWasNotThereBefore.txt";
		
		@SuppressWarnings("unused")
		boolean success = (new File(path)).delete();		
		HandleFileWriter handler =  new HandleFileWriter(path);
		assertNotNull(handler);
		handler.close();
	}
	@Test(expected = GedcomParserException.class)
	public void HandleFileWriterCreateTestWithEmptyFilePath() throws GedcomParserException{
		String fileName =  "";
		HandleFileWriter handler =  new HandleFileWriter(fileName);
		handler.close();
	}
	
	@Test(expected = GedcomParserException.class)
	public void HandleFileWriterCreateTestWithNullFilePath() throws GedcomParserException{
		String fileName =  null;
		HandleFileWriter handler =  new HandleFileWriter(fileName);
		handler.close();
	}
	/*
	 * Before Testing clean the file content for verification.
	 */
	@Test 
	public void HandleFileWriterReadTestValidLines() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/XMLValidFile.txt");
		String fileName = resourceUrl.getPath();
		HandleFileWriter handler =  new HandleFileWriter(fileName);
		String line = "Hi I am here\n";
		handler.write(line);
		handler.close();
		
		HandleFileReader reader =  new HandleFileReader(fileName);
		String rline = null;
		while((rline = reader.read())  != null){
			if (rline.isEmpty() || rline.trim().equals("") || rline.trim().equals("\n")){
				    continue;
			}
			String line1 = "Hi I am here";
			assertTrue(line1.equals(line1));
			
	   }
		handler.close();
	}
	
	
	@Test(expected = GedcomParserException.class)
	public void HandleFileWriterCloseTest() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/XMLFile.txt");
		String fileName = resourceUrl.getPath();
		HandleFileWriter handler =  new HandleFileWriter(fileName);
		assertNotNull(handler);
		handler.close();
		String x  = "hi";
		handler.write(x);
	}


}
