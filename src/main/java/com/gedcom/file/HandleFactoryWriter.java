package com.gedcom.file;

import com.gedcom.exception.GedcomParserException;

public class HandleFactoryWriter {

	public static HandleWriter getHandler(String OutputXMLPath) throws GedcomParserException {
		if(OutputXMLPath==null || OutputXMLPath.isEmpty()){
			return new HandleConsoleWriter();
		}else{
			return new HandleFileWriter(OutputXMLPath);
		}
	}
}
