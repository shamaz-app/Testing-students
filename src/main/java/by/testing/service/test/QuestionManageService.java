package by.testing.service.test;

import by.testing.dto.test.QuestionDto;
import by.testing.entities.test.Question;
import by.testing.filters.test.QuestionFilter;
import by.testing.service.SimpleService;
import org.springframework.data.domain.Page;

/**
 * Created by Анастасия on 09.09.2016.
 */
public interface QuestionManageService extends SimpleService<Question> {

    /**
     * Save or update question with answer options by QuestionDto object.
     *
     * Need to test cascade of mapping Question-AnswerOptions
     *
     * @param questionDto
     */
    void saveQuestion(QuestionDto questionDto);


    /**
     * Get question list by question filter(By theme id)
     *
     * Need to test this Query By Example(Spring Data)
     *
     * @param questionFilter
     * @return
     */
    Page<QuestionDto> getQuestionList(QuestionFilter questionFilter);
}
