package com.gedcom.test.rootsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.gedcom.test.exception.ExceptionTestSuite;
import com.gedcom.test.file.HandlerTestSuite;
import com.gedcom.test.parser.GedcomParserTestSuite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
		ExceptionTestSuite.class,
		HandlerTestSuite.class,
		GedcomParserTestSuite.class
})

public class GedcomTestSuite {

}
