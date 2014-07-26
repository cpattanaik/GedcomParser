package com.gedcom.test.parser;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleFactoryWriter;
import com.gedcom.file.HandleWriter;
import com.gedcom.parser.CompositeBase;
import com.gedcom.parser.CompositeElement;
import com.gedcom.parser.CompositeLeafElement;
import com.gedcom.parser.LineParser;


public class CompositeTest {
	@Test
	public void CompositeTestWithOneLeaf() throws GedcomParserException, IOException{
		String line = "0 TUN xyz";	
		LineParser parser  = new LineParser(line);
		
		ByteArrayOutputStream outCont = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(outCont);
	    System.setOut(ps);
	    HandleWriter handler = HandleFactoryWriter.getHandler(null);
		
		CompositeBase leaf = new CompositeLeafElement(parser);
		leaf.createXML(1, handler);
		
		handler.close();
		System.setOut(System.out);
		
		String str = " <TUN>xyz</TUN> \n";
		assertEquals(str, outCont.toString());			
	}
	@Test
	public void CompositeTestWithOneComposite() throws GedcomParserException, IOException{
		String line1 = "0 TUN xyz";	
		String line2 = "0 MUN klm";		
		LineParser parser1  = new LineParser(line1);
		LineParser parser2  = new LineParser(line2);
		
		ByteArrayOutputStream outCont = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(outCont);
	    System.setOut(ps);
	    HandleWriter handler = HandleFactoryWriter.getHandler(null);
		
		CompositeBase leaf = new CompositeLeafElement(parser1);
		CompositeElement comp = new CompositeElement(parser2);
		comp.addElement(leaf);
		comp.createXML(1, handler);
		
		handler.close();
		System.setOut(System.out);
		
		String str = " <MUN value=\"klm\"> \n   <TUN>xyz</TUN> \n </MUN> \n";
		assertEquals(str, outCont.toString());			
	}
	
	@Test
	public void CompositeTestWithTwoComposite() throws GedcomParserException, IOException{
		String line1 = "0 TUN xyz";	
		String line2 = "0 MUN klm";	
		
		LineParser parser1  = new LineParser(line1);
		LineParser parser2  = new LineParser(line2);
		
		ByteArrayOutputStream outCont = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(outCont);
	    System.setOut(ps);
	    HandleWriter handler = HandleFactoryWriter.getHandler(null);
		
	    CompositeElement leaf = new CompositeElement(parser1);
	    CompositeElement comp = new CompositeElement(parser2);
		comp.addElement(leaf);
		comp.createXML(1, handler);
		
		handler.close();
		System.setOut(System.out);
				
		String str = " <MUN value=\"klm\"> \n   <TUN value=\"xyz\"> \n   </TUN> \n </MUN> \n";
		assertEquals(str, outCont.toString());			
	}

	@Test
	public void CompositeTestWithTwoCompositeOneLeaf() throws GedcomParserException, IOException{
		String line1 = "0 TUN xyz";	
		String line2 = "0 MUN klm";	
		String line3 = "0 KUN abc";	
		
		LineParser parser1  = new LineParser(line1);
		LineParser parser2  = new LineParser(line2);
		LineParser parser3  = new LineParser(line3);
		
		ByteArrayOutputStream outCont = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(outCont);
	    System.setOut(ps);
	    HandleWriter handler = HandleFactoryWriter.getHandler(null);
		
		CompositeBase leaf = new CompositeLeafElement(parser3);
		CompositeElement comp1 = new CompositeElement(parser1);
		CompositeElement comp2 = new CompositeElement(parser2);
		
		comp2.addElement(leaf);
		comp1.addElement(comp2);
		comp1.createXML(1, handler);
		
		handler.close();
		System.setOut(System.out);
		
		String str = " <TUN value=\"xyz\"> \n   <MUN value=\"klm\"> \n     <KUN>abc</KUN> \n   </MUN> \n </TUN> \n";
		assertEquals(str, outCont.toString());			
	}

}
