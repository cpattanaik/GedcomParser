package com.gedcom.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.gedcom.exception.GedcomParserException;

public class HandleFileWriter  implements HandleWriter{
	private BufferedWriter bw = null;
	
	public HandleFileWriter(String filePath) throws GedcomParserException{
		if(filePath == null || filePath.isEmpty()){
			throw new GedcomParserException("You Passed Null/Empty File Name");
		}
		
		FileWriter fw = null;
		File file = new File(filePath);
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new GedcomParserException(e.getMessage());
			}
		}
		
		try {
			fw = new FileWriter(file.getAbsoluteFile());
		} catch (IOException e) {
			 throw new GedcomParserException(e.getMessage());
		}
		bw = new BufferedWriter(fw);	
	}
	public void write(String line) throws GedcomParserException {
		try {
			bw.write(line);
		} catch (IOException e) {
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
