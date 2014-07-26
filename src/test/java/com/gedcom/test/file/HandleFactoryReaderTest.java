package com.gedcom.test.file;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleConsoleReader;
import com.gedcom.file.HandleFactoryReader;
import com.gedcom.file.HandleFileReader;
import com.gedcom.file.HandleReader;

public class HandleFactoryReaderTest {
	@Test
	public void HandleFactoryReaderGetHandlerTestWithEmptyFilePath() throws GedcomParserException{
		HandleReader reader = HandleFactoryReader.getHandler("");
		assertTrue(reader instanceof HandleConsoleReader);
	}
	
	@Test
	public void HandleFactoryReaderGetHandlerTestWithNullFilePath() throws GedcomParserException{
		HandleReader reader = HandleFactoryReader.getHandler("");
		assertTrue(reader instanceof HandleConsoleReader);
	}
	
	@Test
	public void HandleFactoryReaderGetHandlerTestWithPathExist() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/TextFile.txt");
		String fileName = resourceUrl.getPath();
		
		HandleReader reader = HandleFactoryReader.getHandler(fileName);
		assertTrue(reader instanceof HandleFileReader);
	}
	
	@Test(expected = GedcomParserException.class)
	public void HandleFactoryReaderGetHandlerTestWithPathNotExist() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/TextFile.txt");
		String fileName = resourceUrl.getPath();
		String path = fileName.substring(0, fileName.lastIndexOf('/')+1);
		path += "FilePathNotExist.txt";
		
		@SuppressWarnings("unused")
		boolean success = (new File(path)).delete();	
		
		HandleReader reader = HandleFactoryReader.getHandler(path);
		assertTrue(reader == null);
	}
}
