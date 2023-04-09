package com.epam.testing.utils;

import com.epam.testing.entity.Client;
import com.epam.testing.template.Template;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class DataParserTest {

    private static final String DATA = "Hello! I wanted to share #{item} with you\n" +
            "item=this\n" +
            "Client@mail.ru";

    private final DataParser sut = new DataParser();

    @Test
    void shouldParseTemplate() {
        Template expected = new Template("Hello! I wanted to share #{item} with you", Map.of("item", "this"));

        Template actual = sut.parseData(Template.class, DATA);

        assertThat(actual, is(expected));
    }

    @Test
    void shouldParseClient() {
        Client expected = new Client("Client@mail.ru");

        Client actual = sut.parseData(Client.class, DATA);

        assertThat(actual, is(expected));
    }
}
