package ru.otus.spring.services;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;


public class ConsoleIOService implements IOInputStreamServiceI {

    private final Scanner userInput ;
    private final PrintStream outputStream;

    public ConsoleIOService() {
        this.userInput = new Scanner(System.in);
        this.outputStream  = System.out;
    }

    @Override
    public List<String> readListWithPrompt(String prompt) {
        outputStream.println(prompt);
        return List.of(userInput.nextLine().split("\\s"));
    }

    @Override
    public String readStringWithPrompt(String prompt) {
        outputStream.println(prompt);
        return userInput.nextLine();
    }

    @Override
    public String readString(String s) {
        return userInput.nextLine();
    }

    @Override
    public void outputString(String s) {
        outputStream.println(s);
    }
}
