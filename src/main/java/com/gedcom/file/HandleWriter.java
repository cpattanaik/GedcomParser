package com.gedcom.file;

import com.gedcom.exception.GedcomParserException;

public interface HandleWriter {

	public void write(String line) throws GedcomParserException;
	public void close() throws GedcomParserException;

}
