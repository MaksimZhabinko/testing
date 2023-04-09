package com.epam.testing.extension;

import com.epam.testing.testutils.TestResultMessageGenerator;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class TestReporterPostProcessorExtension implements AfterTestExecutionCallback {

    public static final String OUTPUT_EXECUTION_FILE = "src/test/resources/testResults.txt";

    private final TestResultMessageGenerator generator = new TestResultMessageGenerator();

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        File file = new File(OUTPUT_EXECUTION_FILE);

        FileUtils.writeStringToFile(file, generator.generateResultMessage(extensionContext), StandardCharsets.UTF_8, true);
    }

}
