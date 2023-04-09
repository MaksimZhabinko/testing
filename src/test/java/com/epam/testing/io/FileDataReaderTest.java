package com.epam.testing.io;

import com.epam.testing.exception.UnresolvablePathException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("io")
class FileDataReaderTest {

    private final FileDataReader sut = new FileDataReader();

    @Test
    @EnabledOnOs(value = OS.WINDOWS)
    void shouldReadDataFromFile() {
        String filePath = "src/test/resources/test.txt";
        String expected = "Test data\nTest data2\nTest data3";

        String actual = sut.readData(filePath);

        assertThat(actual, is(expected));
    }

    @Test
    @EnabledOnOs(value = OS.WINDOWS)
    void shouldThrowRuntimeExceptionWhenNonExistingFileGiven() {
        String nonExistingFilePath = "src/test/resources/invalidPath.txt";

        assertThrows(UnresolvablePathException.class, () -> sut.readData(nonExistingFilePath));
    }
}
