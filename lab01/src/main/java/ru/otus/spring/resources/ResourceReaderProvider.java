package ru.otus.spring.resources;

import org.springframework.core.io.DefaultResourceLoader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class ResourceReaderProvider implements ReaderProvider {

    private final Reader reader;

    public ResourceReaderProvider(String fileName) {
        var in = new DefaultResourceLoader().getClassLoader().getResourceAsStream(fileName);
        this.reader = new BufferedReader(new InputStreamReader(in));
    }

    @Override
    public Reader getReader() {
        return this.reader;
    }

}
