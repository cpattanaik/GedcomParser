package com.gedcom.test.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gedcom.parser.GedComParser;

public class GedComParserTest {
	GedComParser gedcomParser = null;
	
	@Before
	public void init(){
		gedcomParser = new GedComParser();
		
	}
	@After
	public void destroy(){
		//Not Implemented
	}
	
	@Test
	public void GedcomParserTestWithNullFilePath() throws Exception {
		String InputFilePath = null;
		String OutputFilePath = null;
		gedcomParser.generateXML(InputFilePath, OutputFilePath);
	}
	/*
	@Test
	public void GedcomParserTestWithEmptyFilePath() throws Exception {
		String InputFilePath = "";
		String OutputFilePath = "";
		gedcomParser.generateXML(InputFilePath, OutputFilePath);
	}
	
	@Test
	public void GedcomParserTestWithEmptyInputFilePath() throws Exception {
		String InputFilePath = "";
		String OutputFilePath = "";
		gedcomParser.generateXML(InputFilePath, OutputFilePath);
	}	
	
	@Test
	public void GedcomParserTestWithNullInputFilePath() throws Exception {
		String InputFilePath = null;
		String OutputFilePath = "";
		gedcomParser.generateXML(InputFilePath, OutputFilePath);
	}	
	
	@Test
	public void GedcomParserTestWithEmptyOutputFilePath() throws Exception {
		String InputFilePath = "";
		String OutputFilePath = "";
		gedcomParser.generateXML(InputFilePath, OutputFilePath);
	}	
	
	@Test
	public void GedcomParserTestWithNullOutputFilePath() throws Exception {
		String InputFilePath = "";
		String OutputFilePath = null;
		gedcomParser.generateXML(InputFilePath, OutputFilePath);
	}		
	@Test
	public void GedcomParserTestWithValidFilePaths() throws Exception {
		String InputFilePath = "";
		String OutputFilePath = "";
		gedcomParser.generateXML(InputFilePath, OutputFilePath);
	}			
*/
}
