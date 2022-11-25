package ru.otus.spring.services;

import ru.otus.spring.dao.Student;
import java.util.stream.Collectors;

public class QuizService {
    private final QuestionProviderService questionProviderService;
    private final AnswerProviderService answerProviderService;
    private final ConsoleIOService consoleIOService;

    public QuizService(QuestionProviderService questionProviderService,
                       AnswerProviderService answerProviderService,
                       ConsoleIOService consoleIOService) {
        this.questionProviderService = questionProviderService;
        this.answerProviderService = answerProviderService;
        this.consoleIOService = consoleIOService;
    }
    public void run(){
        var student = new Student();
        student.setFirstName(consoleIOService.readStringWithPrompt("Please Enter your First Name"));
        student.setLastName(consoleIOService.readStringWithPrompt("Please Enter your Last Name"));
        var questions = questionProviderService.provide();
        var answers = answerProviderService.provide();
        questions.forEach( question -> {
                    var questionContext = question.getContext();
                    consoleIOService.outputString(questionContext);
                    var allAnswers = question.getAnswersList();
                    var mappedAnswers = answers.stream().filter(answer -> allAnswers.contains(answer.getId()))
                            .map(answer -> answer.getContext()).collect(Collectors.toList());
                    mappedAnswers.forEach(consoleIOService::outputString);
                }
        );
    }


}
