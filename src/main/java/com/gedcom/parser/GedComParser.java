package com.gedcom.parser;

import java.util.Stack;

import com.gedcom.exception.GedcomParserException;
import com.gedcom.file.HandleReader;
import com.gedcom.file.HandleFactoryReader;
import com.gedcom.file.HandleWriter;
import com.gedcom.file.HandleFactoryWriter;

public class GedComParser {
	
	CompositeElement rootElement =  new CompositeElement();
	
	private void generateXMLFileFromElementTree(String outputFilePath) throws GedcomParserException{
		HandleWriter handler = HandleFactoryWriter.getHandler(outputFilePath);
		rootElement.createXML(1, handler);
		handler.close();
	}
	
	private void generateElementTreeFromInput(String inputFilePath) throws GedcomParserException{
		
		HandleReader handler = HandleFactoryReader.getHandler(inputFilePath);
		
		String line = null;
		
		Stack<LineParser> parserStack = new Stack<LineParser> ();
		
		Stack<CompositeBase> elementStack = new Stack<CompositeBase>();
		Stack<Integer> elementLevelStack = new Stack<Integer>();
		
		Stack<CompositeBase> elementOrdringStack = new Stack<CompositeBase>();
		
		
		try{
			while ((line = handler.read()) != null) {
				
				//Skipping blank line
				if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")){
					continue;
				}
				
				LineParser parser = new LineParser(line);
				int currentLevel = parser.getLevel();
			
				while(!parserStack.empty() && currentLevel <= parserStack.peek().getLevel()){
					LineParser tempParser  = parserStack.pop();
					if(elementLevelStack.isEmpty() || elementLevelStack.peek() <= tempParser.getLevel()){
						CompositeBase element = new CompositeLeafElement(tempParser);
						elementStack.push(element);
						elementLevelStack.push(tempParser.getLevel());
					}else{
						CompositeElement temp = new CompositeElement(tempParser);
						while(!elementLevelStack.isEmpty() && elementLevelStack.peek() == tempParser.getLevel()+1){
							elementLevelStack.pop();
							elementOrdringStack.push(elementStack.pop());
						}
						while(!elementOrdringStack.isEmpty()){
								temp.addElement(elementOrdringStack.pop());
							}
						elementStack.push(temp);
						elementLevelStack.push(tempParser.getLevel());
					}
				}
				parserStack.push(parser);
		    }	
			
			//Special case if stk is not empty after comming out of the loop
			while(!parserStack.empty()){
				LineParser tempParser  = parserStack.pop();
				if(elementLevelStack.isEmpty() || elementLevelStack.peek() <= tempParser.getLevel()){
					CompositeBase element = new CompositeLeafElement(tempParser);
					elementStack.push(element);
					elementLevelStack.push(tempParser.getLevel());
				}else{
					CompositeElement temp = new CompositeElement(tempParser);
					while(!elementLevelStack.isEmpty() && elementLevelStack.peek() == tempParser.getLevel()+1){
						elementLevelStack.pop();
						elementOrdringStack.push(elementStack.pop());
					}
					while(!elementOrdringStack.isEmpty()){
						temp.addElement(elementOrdringStack.pop());
					}
					elementStack.push(temp);
					elementLevelStack.push(tempParser.getLevel());
				}
			}
			
			//adding to root element of composite pattern
			while(!elementStack.isEmpty()){
				elementOrdringStack.push(elementStack.pop());
			}
			while(!elementOrdringStack.isEmpty()){
				rootElement.addElement(elementOrdringStack.pop());
			}
		}catch(GedcomParserException e){
			throw e;
		}
		finally{
			handler.close();
		}
	}

	public void generateXML(String inputFilePath, String outputFilePath) throws GedcomParserException {
		generateElementTreeFromInput(inputFilePath);
		generateXMLFileFromElementTree(outputFilePath);
	}
}
