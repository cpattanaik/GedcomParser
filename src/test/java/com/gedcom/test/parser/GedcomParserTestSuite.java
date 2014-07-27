package com.gedcom.test.parser;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
		XMLTagTest.class,
		LineParserTest.class,
		CompositeTest.class,
		GedComParserTest.class,
})

public class GedcomParserTestSuite {

}
