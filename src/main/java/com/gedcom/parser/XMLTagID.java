package com.gedcom.parser;

public class XMLTagID extends XMLTagBase {

	@Override
	public String createXmlStartTagString() {
		String xmlString = "<"+ xmlTagName + " id=\"" + xmlTagValue + "\"> \n";
		return xmlString;
	}
	
	@Override
	public String createXmlEndTagString() {
		String xmlString = "</" + xmlTagName + "> \n";
		return xmlString;
	}
		

	@Override
	public void setXmlTagName(String xmlTagName) {
		this.xmlTagName = xmlTagName;
		
	}

	@Override
	public void setXmlTagValue(String xmlTagValue) {
		this.xmlTagValue = xmlTagValue;
	}

	@Override
	public String createXmlTagString() {
		String xmlString = "<"+ xmlTagName + " id=\"" + xmlTagValue + "\"/> \n";
		return xmlString;
	}

}
