package com.gedcom.test.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gedcom.parser.XMLTagBase;
import com.gedcom.parser.XMLTagID;
import com.gedcom.parser.XMLTagName;
import com.gedcom.parser.XMLTagRoot;

public class XMLTagTest {
	@Test
	public void XMLTagNameCreateXMLTest(){
		XMLTagBase nameTag = new XMLTagName();
		nameTag.setXmlTagName("TEST");
		nameTag.setXmlTagValue("test");
		
		String start = nameTag.createXmlStartTagString();
		assertTrue(start.equals("<TEST value=\"test\"> \n"));
		
		String end = nameTag.createXmlEndTagString();
		assertTrue(end.equals("</TEST> \n"));	
		
		String both = nameTag.createXmlTagString();
		assertTrue(both.equals("<TEST>test</TEST> \n"));			
	}
	
	@Test
	public void XMLTagIDCreateXMLTest(){
		XMLTagBase nameTag = new XMLTagID();
		nameTag.setXmlTagName("TEST");
		nameTag.setXmlTagValue("test");
		
		String start = nameTag.createXmlStartTagString();
		assertTrue(start.equals("<TEST id=\"test\"> \n"));
		
		String end = nameTag.createXmlEndTagString();
		assertTrue(end.equals("</TEST> \n"));	
		
		String both = nameTag.createXmlTagString();
		assertTrue(both.equals("<TEST id=\"test\"/> \n"));			
	}
	
	@Test
	public void XMLTagRootCreateTestWithoutSetCalls(){
		XMLTagBase rootTag = new XMLTagRoot();
		String start = rootTag.createXmlStartTagString();
		assertTrue(start.equals("<gedcom> \n"));
		
		String end = rootTag.createXmlEndTagString();
		assertTrue(end.equals("</gedcom> \n"));	
		
		String both = rootTag.createXmlTagString();
		assertTrue(both.equals("<gedcom></gedcom> \n"));			
	}
}
