package com.gedcom.test.file;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleConsoleWriter;
import com.gedcom.file.HandleFactoryWriter;
import com.gedcom.file.HandleFileWriter;
import com.gedcom.file.HandleWriter;

public class HandleFactoryWriterTest {
	@Test
	public void HandleFactoryWriterGetHandlerTestWithEmptyFilePath() throws GedcomParserException{
		HandleWriter writer = HandleFactoryWriter.getHandler("");
		assertTrue(writer instanceof HandleConsoleWriter);
	}
	
	@Test
	public void HandleFactoryWriterGetHandlerTestWithNullFilePath() throws GedcomParserException{
		HandleWriter writer = HandleFactoryWriter.getHandler("");
		assertTrue(writer instanceof HandleConsoleWriter);
	}
	
	@Test
	public void HandleFactoryWriterGetHandlerTestWithPathExist() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/XMLFile.txt");
		String fileName = resourceUrl.getPath();
		
		HandleWriter writer = HandleFactoryWriter.getHandler(fileName);
		assertTrue(writer instanceof HandleFileWriter);
	}
	
	@Test
	public void HandleFactoryWriterGetHandlerTestWithPathNotExist() throws GedcomParserException{
		URL resourceUrl = getClass().getResource("/XMLFile.txt");
		String fileName = resourceUrl.getPath();
		String path = fileName.substring(0, fileName.lastIndexOf('/')+1);
		path += "FileWasNotThereBefore.txt";
		
		@SuppressWarnings("unused")
		boolean success = (new File(path)).delete();	
		
		HandleWriter writer = HandleFactoryWriter.getHandler(path);
		assertNotNull(writer);
	}
}
