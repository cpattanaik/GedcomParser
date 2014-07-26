package com.gedcom.parser;


public abstract class XMLTagBase {
	protected String xmlTagName= "";
	protected String xmlTagValue="";
	public abstract String createXmlStartTagString();
	public abstract String createXmlEndTagString();
	public abstract String createXmlTagString() ;
	public abstract void setXmlTagName(String xmlTagName) ;
	public abstract void setXmlTagValue(String xmlTagValue) ;
}
