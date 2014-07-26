package com.gedcom.file;

import com.gedcom.exception.GedcomParserException;

public class HandleFactoryReader {
	public static HandleReader getHandler(String InputTextPath) throws GedcomParserException {
		if(InputTextPath== null || InputTextPath.isEmpty()){
			return new HandleConsoleReader();
		}else{
			return new HandleFileReader(InputTextPath);
		}
	}
}
