package com.gedcom.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gedcom.exception.GedcomParserException;

public class HandleConsoleReader implements HandleReader{
	private BufferedReader br = null;
	public HandleConsoleReader() throws GedcomParserException{
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	@Override
	public String read() throws GedcomParserException {
	   try{
			return br.readLine();
	   }catch (IOException e) {
		   	throw new GedcomParserException(e.getMessage());
	   }
	}
	
	@Override
	public void close() throws GedcomParserException{
		try {
			br.close();
		} catch (IOException e) {
			throw new GedcomParserException(e.getMessage());
		}
	}
}
