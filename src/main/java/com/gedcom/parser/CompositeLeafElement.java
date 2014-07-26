package com.gedcom.parser;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleWriter;

public class CompositeLeafElement implements CompositeBase {
	private LineParser parser;
	   
	public CompositeLeafElement(LineParser parser) {
		super();
		this.parser = parser;
	}

	@Override
	public void createXML(int indent,  HandleWriter handler) throws GedcomParserException {
		handler.write(String.format("%" + indent + "s" + "%s", " ", parser.createXmlTagString()));
	   }

}
