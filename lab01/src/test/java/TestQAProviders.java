import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.resources.ResourceReaderProvider;
import ru.otus.spring.services.AnswerProviderService;
import ru.otus.spring.services.QuestionProviderService;
import java.util.stream.Collectors;

public class TestQAProviders {

    private static final String TEST_QUESTION = "What is part of par of Java API?";
    private static final String TEST_ANSWER = "java.lang";

    @Test
    @DisplayName("Проверка тестового вопроса")
    public void testQuestions(){
        var questionsResourceProvider = new ResourceReaderProvider("test-questions.csv");
        var questions = new QuestionProviderService(questionsResourceProvider);
        var context = questions.provide().stream().map(question -> question.getContext()).collect(Collectors.toList());
        Assertions.assertTrue(context.contains(TEST_QUESTION));
    }
    @Test
    @DisplayName("Проверка тестового ответа")
    public void testAnswers(){
        var answersResourceProvider = new ResourceReaderProvider("test-answeres.csv");
        var answers = new AnswerProviderService(answersResourceProvider);
        var context = answers.provide().stream().map(answer -> answer.getContext()).collect(Collectors.toList());
        Assertions.assertTrue(context.contains(TEST_ANSWER));
    }
}
