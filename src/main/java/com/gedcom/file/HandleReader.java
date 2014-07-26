package com.gedcom.file;

import com.gedcom.exception.GedcomParserException;

public interface HandleReader {
	public String read() throws GedcomParserException;
	public void close() throws GedcomParserException;
	
}
