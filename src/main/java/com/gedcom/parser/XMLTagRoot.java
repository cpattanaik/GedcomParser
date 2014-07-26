package com.gedcom.parser;

public class XMLTagRoot extends XMLTagBase {

	@Override
	public String createXmlStartTagString() {
		return "<gedcom> \n";
	}

	@Override
	public String createXmlEndTagString() {
		return "</gedcom> \n";
	}

	@Override
	public String createXmlTagString() {
		return "<gedcom></gedcom> \n";
	}

	@Override
	public void setXmlTagName(String xmlTagName) {
		// Not required
	}

	@Override
	public void setXmlTagValue(String xmlTagValue) {
		//Not required
	}

}
