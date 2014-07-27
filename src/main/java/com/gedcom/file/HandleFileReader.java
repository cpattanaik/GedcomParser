package com.gedcom.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.gedcom.exception.GedcomParserException;

public class HandleFileReader implements HandleReader{
	private BufferedReader br = null;
	
	public HandleFileReader(String filePath) throws GedcomParserException{
		if(filePath == null || filePath.isEmpty()){
			throw new GedcomParserException("You Passed Null/Empty File Name");
		}
			
		FileReader fr = null;
		
		File file = new File(filePath);
		if (!file.exists()) {
			throw new GedcomParserException("File Does Not Exist: "+ filePath);
		}
		
		try {
			fr = new FileReader(file.getAbsoluteFile());
		} catch (IOException e) {
			 throw new GedcomParserException(e.getMessage());
		}
		br = new BufferedReader(fr);	
	}
	
	public String read() throws GedcomParserException {
		try {
			  return br.readLine();
		} catch (IOException e) {
			throw new GedcomParserException(e.getMessage());
		}
	}
	
	public void close() throws GedcomParserException{
		try {
			br.close();
		} catch (IOException e) {
			throw new GedcomParserException(e.getMessage());
		}
	}
	
}
