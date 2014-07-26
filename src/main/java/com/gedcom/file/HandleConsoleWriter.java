package com.gedcom.file;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.gedcom.exception.GedcomParserException;

public class HandleConsoleWriter implements HandleWriter  {
	private BufferedWriter bw = null;
	public HandleConsoleWriter(){
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public void write(String line) throws GedcomParserException {
	   try{
			bw.write(line);
	   }catch (IOException e) {
		   	throw new GedcomParserException(e.getMessage());
	   }
	}
	public void close() throws GedcomParserException{
		try {
			bw.close();
		} catch (IOException e) {
			throw new GedcomParserException(e.getMessage());
		}
	}
}
	

