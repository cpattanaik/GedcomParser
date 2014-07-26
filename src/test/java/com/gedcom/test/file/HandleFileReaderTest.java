package com.gedcom.test.file;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleFileReader;

public class HandleFileReaderTest {
	@Test
	public void HandleFileReaderCreateTestWithValidPath() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/TextFile.txt");
		String fileName = resourceUrl.getPath();
		HandleFileReader handler =  new HandleFileReader(fileName);
		assertNotNull(handler);
		handler.close();
	}
	@Test(expected = GedcomParserException.class)
	public void HandleFileReaderCreateTestWithPathNotExist() throws GedcomParserException, URISyntaxException{
		URL resourceUrl = getClass().getResource("/TextFile.txt");
		String fileName = resourceUrl.getPath();
		String path = fileName.substring(0, fileName.lastIndexOf('/')+1);
		path += "FilePathNotExist.txt";
		
		@SuppressWarnings("unused")
		boolean success = (new File(path)).delete();		
		
		HandleFileReader handler =  new HandleFileReader(path);
		assertNotNull(handler);
		handler.close();
	}
	@Test(expected = GedcomParserException.class)
	public void HandleFileReaderCreateTestWithEmptyFilePath() throws GedcomParserException{
		String fileName =  "";
		HandleFileReader handler =  new HandleFileReader(fileName);
		handler.close();
	}
	
	@Test(expected = GedcomParserException.class)
	public void HandleFileReaderCreateTestWithNullFilePath() throws GedcomParserException{
		String fileName =  null;
		HandleFileReader handler =  new HandleFileReader(fileName);
		handler.close();
	}
	/*
	 * This test includes test for lines having : New Line/Space/Tab/ MultiSpace/ MultiTab/Valid line
	 */
	@Test 
	public void HandleFileReaderReadTestValidLines() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/TextFile.txt");
		String fileName = resourceUrl.getPath();
		HandleFileReader handler =  new HandleFileReader(fileName);
		String line = null;
		while((line = handler.read())  != null){
			if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")){
				    continue;
			}
			assertEquals(line, "Hi I am chandra");
	   }
		handler.close();
	}
	
	@Test 
	public void HandleFileReaderReadTestEmptyFile() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/BlankFile.txt");
		String fileName = resourceUrl.getPath();
		HandleFileReader handler =  new HandleFileReader(fileName);
		@SuppressWarnings("unused")
		String line = null;
		boolean checkFlag =  false;
		if((line = handler.read()) != null){
			checkFlag = true;
		}
		assertFalse(checkFlag);
		handler.close();
	}
	
	@Test(expected = GedcomParserException.class)
	public void HandleFileReaderCloseTest() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/TextFile.txt");
		String fileName = resourceUrl.getPath();
		HandleFileReader handler =  new HandleFileReader(fileName);
		assertNotNull(handler);
		handler.close();
		@SuppressWarnings("unused")
		String x  = handler.read();
	}

}
