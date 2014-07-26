package com.gedcom.parser;


import java.util.ArrayList;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleWriter;



public class CompositeElement implements CompositeBase{
	private LineParser parser;
	private ArrayList<CompositeBase> elementTree = new ArrayList<CompositeBase>();

	public CompositeElement(LineParser parser) {
		super();
		this.parser = parser;
	}
	
	public CompositeElement() {
		parser = new LineParser();
	}

	@Override
	public void createXML(int indent, HandleWriter handler) throws GedcomParserException{
		handler.write(String.format("%" + indent + "s" + "%s", " ", parser.createXmlStartTagString()));
		for ( CompositeBase compositeBase : elementTree)  
        {  
			if(compositeBase != null){
				compositeBase.createXML(indent+2, handler);
			}
        }
		handler.write(String.format("%" + indent + "s" + "%s", " ",parser.createXmlEndTagString())); 
	}

	public void addElement(CompositeBase element) {
		elementTree.add(element);
		
	}

	

}
