package ru.otus.spring.services;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ru.otus.spring.dao.Question;
import ru.otus.spring.execption.ResourceNotFoundException;
import ru.otus.spring.resources.ReaderProvider;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionProviderService implements ProviderServiceI<Question> {

    private final ReaderProvider readerProvider;

    public QuestionProviderService(ReaderProvider readerProvider) {
        this.readerProvider = readerProvider;
    }

    @Override
    public List<Question> provide() {
        List<Question> questionList = new ArrayList<>();
        final ColumnPositionMappingStrategy<Question> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Question.class);
        strategy.setColumnMapping(new String[]{"id", "context", "answersList", "correctAnswers"});
        try (Reader reader = readerProvider.getReader()) {
            CsvToBean<Question> rawQuestions = new CsvToBeanBuilder<Question>(reader).withSeparator(',').withMappingStrategy(strategy).build();
            questionList = rawQuestions.stream().collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Could not read from resource ", e);
        }
        return questionList;
    }
}
