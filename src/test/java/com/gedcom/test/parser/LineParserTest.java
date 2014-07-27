package com.gedcom.test.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.parser.LineParser;

public class LineParserTest {

	@Test
	public void LineParserCreateTagNameTestWithGetXMLTagMethods1() throws GedcomParserException{
		String line = "0 THU abcd efg";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
		assertTrue(parser.getLevel() == 0);
		assertTrue(parser.createXmlStartTagString().equals("<THU value=\"abcd efg\"> \n"));
		assertTrue(parser.createXmlEndTagString().equals("</THU> \n"));
		assertTrue(parser.createXmlTagString().equals("<THU>abcd efg</THU> \n"));
	}
	@Test
	public void LineParserCreateTagNameTestWithGetXMLTagMethods2() throws GedcomParserException{
		String line = "0 THU ";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
		assertTrue(parser.getLevel() == 0);
		assertTrue(parser.createXmlStartTagString().equals("<THU> \n"));
		assertTrue(parser.createXmlEndTagString().equals("</THU> \n"));
		assertTrue(parser.createXmlTagString().equals("<THU></THU> \n"));
	}	
	@Test
	public void LineParserCreateTagRootTestWithGetXMLTagMethods(){
		LineParser parser = new LineParser();
		assertTrue(parser.getLevel() == -1);
		assertTrue(parser.createXmlStartTagString().equals("<gedcom> \n"));
		assertTrue(parser.createXmlEndTagString().equals("</gedcom> \n"));
		assertTrue(parser.createXmlTagString().equals("<gedcom></gedcom> \n"));
	}	
	
	@Test
	public void LineParserCreateTagIDTestWithGetXMLTagMethods() throws GedcomParserException{
		String line = "0 @ID@ THU";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
		assertTrue(parser.getLevel() == 0);
		assertTrue(parser.createXmlStartTagString().equals("<THU id=\"@ID@\"> \n"));
		assertTrue(parser.createXmlEndTagString().equals("</THU> \n"));
		assertTrue(parser.createXmlTagString().equals("<THU id=\"@ID@\"/> \n"));
	}	
	@Test
	public void LineParserGetLevelTest() throws GedcomParserException{	
		String line = "4 @ID@ THU";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
		assertTrue(parser.getLevel() == 4);
	}
	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWithLineNull() throws GedcomParserException{
		String line = null;
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWithLineEmpty() throws GedcomParserException{
		String line = "";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}	
		
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestLevelValidation1() throws GedcomParserException{
		String line = "abc THU xyz";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);			
	}	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestLevelValidation2() throws GedcomParserException{
		String line = "a THU xyz";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);			
	}	
	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWithTagIDValueValidation1() throws GedcomParserException{
		String line = "1 TH xyz";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWithTagIDValueValidation2() throws GedcomParserException{
		String line = "1 THRST xyz";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWithTagIDValueValidation3() throws GedcomParserException{
		String line = "1 THrS xyz mnl";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWithTagIDValueValidation4() throws GedcomParserException{
		String line = "1 @ID@ xyz";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}	
	@Test
	public void LineParserValidationTestWithTagIDValueValidation5() throws GedcomParserException{
		String line = "1 @ID@ XYRZ";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWithTagIDValueValidation6() throws GedcomParserException{
		String line = "1 @ID@ XYZZZ";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWithTagIDValueValidation7() throws GedcomParserException{
		String line = "1 @ID@ YZ";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWithTagIDValueValidation8() throws GedcomParserException{
		String line = "1 uYZ ";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWithTagIDValueValidation9() throws GedcomParserException{
		String line = "1 @ID@ ";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWitTagIDValueValidation10() throws GedcomParserException{
		String line = "1 ";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}	
	
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWitTagIDValueValidation11() throws GedcomParserException{
		String line = " XYZ ";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}			
	@Test(expected = GedcomParserException.class)
	public void LineParserValidationTestWitTagIDValueValidation12() throws GedcomParserException{
		String line = "  XYZ abc";
		LineParser parser = new LineParser(line);
		assertNotNull(parser);
	}			
}
