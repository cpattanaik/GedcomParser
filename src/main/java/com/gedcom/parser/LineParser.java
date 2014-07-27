/*
 * It works as a builder class to generate xml strings based on line feed
 */
package com.gedcom.parser;

import com.gedcom.exception.GedcomParserException;

public class LineParser {
	private String level;
	private XMLTagBase xmlTag;
	
	public LineParser(String line) throws GedcomParserException{
		if(line == null || line.trim().isEmpty()){
			throw new GedcomParserException("Validation Failure:  null or empty line passed");
		}
		String[] words = line.split("\\s+");
		if(!validateLine(words)){
			throw new GedcomParserException("Validation Failure:  "+ line);
		}
		
		level = words[0];
		
		if(words[1].matches("@(.*)@")){
			xmlTag =  new XMLTagID();
			xmlTag.setXmlTagName(words[2]);
			xmlTag.setXmlTagValue(words[1]);
		}else{
			xmlTag =  new XMLTagName();
			xmlTag.setXmlTagName(words[1]);
			
			String temp = "";
			for(int i = 2; i<words.length; i++){
				temp += words[i] + " ";
			}
			xmlTag.setXmlTagValue(temp.trim());
		}
	}
    private boolean validateLine(String[] words) {
    	//Minimal Number of Words Validation
    	if(words.length < 2){
    		return false;
    	}
    	
    	// Level Validation
    	try{ 
        	Integer.parseInt(words[0].toString());
    	}catch(NumberFormatException e) { 
    		return false; 
    	}
    	
    	//ID Validation
    	if(words[1].matches("@(.*)@")){
    		if(words.length !=  3 ){
    			return false;
    		}
    		// ID Tag Validation
    		if(words[2].length() < 3 || words[2].length() > 4 ){
    			return false;
    		}
    		if(!words[2].matches("^[A-Z ]+$")){
    			return false;
    		}
        }
    	// Non-ID Tag Validation
    	else{
    		if(words[1].length() < 3 || words[1].length() > 4 ){
    			return false;
    		}
    		if(!words[1].matches("^[A-Z ]+$")){
    			return false;
    		}
    	}
    	return true;
	}

	public LineParser(){
		level = "-1";
		xmlTag =  new XMLTagRoot();
	}
	public int getLevel() {
		return Integer.parseInt(level);
	}
	
	public String createXmlStartTagString() {
		return xmlTag.createXmlStartTagString();
	}
	
	public String createXmlEndTagString() {
		return xmlTag.createXmlEndTagString();
	}
	
	//It will be only called from leaf element
	public String createXmlTagString() {
		return xmlTag.createXmlTagString();
	}
}
