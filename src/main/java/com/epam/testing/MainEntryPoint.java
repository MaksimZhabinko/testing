package com.epam.testing;

import com.epam.testing.cli.CommandLineInterface;
import picocli.CommandLine;


public class MainEntryPoint {
    public static void main(String[] args) {
        CommandLine.run(new CommandLineInterface(), args);
    }
}
