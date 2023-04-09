package com.epam.testing.io;

import com.epam.testing.exception.UnresolvablePathException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileDataPublisher {
    public void publishData(String filePath, String data) {
        try {
            File outputFile = new File(filePath);
            FileUtils.writeStringToFile(outputFile, data, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UnresolvablePathException("Could not to resolve the path: " + filePath);
        }
    }
}
