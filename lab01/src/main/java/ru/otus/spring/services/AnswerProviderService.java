package ru.otus.spring.services;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ru.otus.spring.dao.Answer;
import ru.otus.spring.execption.ResourceNotFoundException;
import ru.otus.spring.resources.ReaderProvider;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerProviderService implements ProviderServiceI<Answer>{

    private final ReaderProvider readerProvider;

    public AnswerProviderService(ReaderProvider readerProvider) {
        this.readerProvider = readerProvider;
    }

    @Override
    public List<Answer> provide() {
        List<Answer> result = new ArrayList<>();
        final ColumnPositionMappingStrategy<Answer> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Answer.class);
        strategy.setColumnMapping(new String[]{"id","context"});

        try(Reader reader = readerProvider.getReader()) {
            CsvToBean<Answer> rawAnswers = new CsvToBeanBuilder<Answer>(reader).withSeparator(',').withMappingStrategy(strategy).build();
            result = rawAnswers.stream().collect(Collectors.toList());
        } catch (Exception e){
            throw new ResourceNotFoundException("Could not read from resource ", e);
        }
        return result;
    }
}
