package ru.otus.spring.dao;

public class Answer {
    private Long id;
    private String context;

    public Answer() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public long getId() {
        return id;
    }

    public String getContext() {
        return context;
    }


}
