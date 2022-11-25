package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.services.QuizService;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
       var context = new ClassPathXmlApplicationContext("context.xml");
       var quizService = context.getBean(QuizService.class);
       quizService.run();

    }
}
