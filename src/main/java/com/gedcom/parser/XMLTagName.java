package com.gedcom.parser;


public class XMLTagName extends XMLTagBase {

	@Override
	public String createXmlTagString()  {
		String xmlString = "<"+ xmlTagName + ">" + xmlTagValue + "</"+ xmlTagName + "> \n";
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
	public String createXmlStartTagString() {
		String xmlString;
		if(!xmlTagValue.isEmpty()){
			xmlString = "<"+ xmlTagName + " value=\"" + xmlTagValue + "\"> \n";
		}else{
			xmlString = "<"+ xmlTagName + "> \n";
		}
		return xmlString;	
	}

	@Override
	public String createXmlEndTagString() {
		String xmlString = "</"+ xmlTagName + "> \n";
		return xmlString;	
	}
}
