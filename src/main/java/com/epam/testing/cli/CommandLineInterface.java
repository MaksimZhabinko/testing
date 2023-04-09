package com.epam.testing.cli;

import com.epam.testing.facade.Facade;
import com.epam.testing.io.FileDataPublisher;
import com.epam.testing.io.FileDataReader;
import com.epam.testing.logic.MailServer;
import com.epam.testing.logic.Messenger;
import com.epam.testing.template.TemplateEngine;
import com.epam.testing.utils.DataParser;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "messenger")
public class CommandLineInterface implements Runnable {
    @Option(names = "-enableFileMode")
    private boolean fileModeOn;

    @Option(names = "-inputTemplate")
    private String inputTemplate;

    @Option(names = "-outputFile")
    private String outputFile;

    @Override
    public void run() {
        FileDataReader fileDataReader = new FileDataReader();
        FileDataPublisher fileDataPublisher = new FileDataPublisher();
        TemplateEngine templateEngine = new TemplateEngine();
        MailServer mailServer = new MailServer();
        Messenger messenger = new Messenger(mailServer, templateEngine);
        DataParser dataParser = new DataParser();
        Facade facade = new Facade(fileDataReader, fileDataPublisher, dataParser, messenger, templateEngine);
        facade.execute(fileModeOn, inputTemplate, outputFile);
    }
}
