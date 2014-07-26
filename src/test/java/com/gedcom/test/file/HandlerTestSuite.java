package com.gedcom.test.file;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
		HandleConsoleReaderTest.class,
		HandleFileReaderTest.class,
		HandleFactoryReaderTest.class,
		HandleConsoleWriterTest.class,
		HandleFileWriterTest.class,
		HandleFactoryWriterTest.class   
})

public class HandlerTestSuite {
}
