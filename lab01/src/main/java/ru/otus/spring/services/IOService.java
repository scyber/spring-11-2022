package ru.otus.spring.services;

import java.util.List;

public interface IOService {
    List<String> readListWithPrompt(String prompt);
    String readStringWithPrompt(String prompt);
    String readString(String s);
}
