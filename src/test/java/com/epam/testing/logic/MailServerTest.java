package com.epam.testing.logic;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MailServerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final MailServer sut = new MailServer();

    @Test
    void shouldPrintOutMessage() {
        System.setOut(new PrintStream(outContent));
        String date = new Date(System.currentTimeMillis()).toString();
        sut.send("Alex322", "Hello, how are u?");
        assertThat(outContent.toString(), is("Message: Hello, how are u?\nWas sent to: Alex322\nWas sent at: " + date + "\r\n"));
    }
}
