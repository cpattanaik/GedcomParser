package com.gedcom.test.parser;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.parser.GedComParser;

public class GedComParserTest {
	GedComParser gedcomParser = null;
	
	@Before
	public void init(){
		gedcomParser = new GedComParser();
	}
	
	@Test
	public void GedcomParserTestWithValidInputFilePath1() throws GedcomParserException, IOException{
		URL url1 = getClass().getResource("/sample1.txt");
		String InputFilePath = url1.getPath();
		
		URL url2 = getClass().getResource("/sample1.xml");
		String OutputFilePath = url2.getPath();
		
		URL url3 = getClass().getResource("/expected1.xml");
		String ExpectedFilePath = url3.getPath();
		
		gedcomParser.generateXML(InputFilePath, OutputFilePath);
		
		boolean isEqual = compareFiles(OutputFilePath, ExpectedFilePath);
		assertTrue(isEqual);
	}	
	
	@Test
	public void GedcomParserTestWithValidInputFilePath2() throws GedcomParserException, IOException{
		URL url1 = getClass().getResource("/sample2.txt");
		String InputFilePath = url1.getPath();
		
		URL url2 = getClass().getResource("/sample2.xml");
		String OutputFilePath = url2.getPath();
		
		URL url3 = getClass().getResource("/expected2.xml");
		String ExpectedFilePath = url3.getPath();
		
		gedcomParser.generateXML(InputFilePath, OutputFilePath);
		
		boolean isEqual = compareFiles(OutputFilePath, ExpectedFilePath);
		assertTrue(isEqual);
	}	
	
	@Test(expected = GedcomParserException.class)
	public void GedcomParserTestWithInValidInput() throws GedcomParserException, IOException{
		URL url1 = getClass().getResource("/InvalidSample.txt");
		String InputFilePath = url1.getPath();
		
		URL url2 = getClass().getResource("/sample3.xml");
		String OutputFilePath = url2.getPath();
		
		URL url3 = getClass().getResource("/expected3.xml");
		String ExpectedFilePath = url3.getPath();

		gedcomParser.generateXML(InputFilePath, OutputFilePath);
		
		boolean isEqual = compareFiles(OutputFilePath, ExpectedFilePath);
		assertTrue(isEqual);
	}	
	
	/*
	 * Utility function for comparing files line by line to check if both files are same
	 */
	private boolean compareFiles(String outputFilePath, String expectedFilePath) throws IOException {
		BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFilePath));
		BufferedReader actualReader = new BufferedReader(new FileReader(outputFilePath));

		boolean isEqual = true;

		String line1 = null;
		String line2 = null;

		while (true)
		{
			line1 = expectedReader.readLine() ;
			line2 = actualReader.readLine();
			if(line1 == null && line2 == null){
				break;
			}else if(line1 == null || line2 == null){
				isEqual = false;
				break;
			}else if(!line1.equals(line2)){
				isEqual = false;
				break;
			}
		}
		expectedReader.close();
		actualReader.close();
		return isEqual;
	}
}
