package com.gedcom.parser;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleWriter;

public interface CompositeBase {
	//
	// Only one method to generate and write into xml file
	//
	   public void createXML(int indent, HandleWriter handler) throws GedcomParserException;
	   
}
