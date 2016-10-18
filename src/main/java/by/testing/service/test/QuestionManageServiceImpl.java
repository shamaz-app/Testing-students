package by.testing.service.test;

import by.testing.dto.test.AnswerOptionDto;
import by.testing.dto.test.QuestionDto;
import by.testing.entities.test.AnswerOption;
import by.testing.entities.test.Question;
import by.testing.entities.test.Theme;
import by.testing.filters.test.QuestionFilter;
import by.testing.repository.test.AnswerOptionRepository;
import by.testing.repository.test.QuestionRepository;
import by.testing.repository.test.TestRepository;
import by.testing.repository.test.ThemeRepository;
import by.testing.service.SimpleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Created by Анастасия on 09.09.2016.
 */
@Service
public class QuestionManageServiceImpl extends SimpleServiceImpl<Question, QuestionRepository> implements QuestionManageService {

    @Autowired
    private AnswerOptionRepository answerOptionRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private TestRepository testRepository;

    @Override
    public void saveQuestion(QuestionDto questionDto) {
        Question question;
        if (questionDto.getId() != null) {
            question = get(questionDto.getId());
        } else {
            question = new Question(questionDto);
        }
        question.setTheme(themeRepository.findById(questionDto.getThemeDto().getId()));

        for (AnswerOptionDto answerOptionDto : questionDto.getAnswerOptions()) {
            AnswerOption answerOption;
            if (answerOptionDto.getId() != null) {
                answerOption = answerOptionRepository.findById(answerOptionDto.getId());
            } else {
                answerOption = new AnswerOption(answerOptionDto);
            }
            question.getAnswerOption().add(answerOption);
        }

        save(question);
    }

    @Override
    public Page<QuestionDto> getQuestionList(QuestionFilter questionFilter) {
        Theme theme = themeRepository.findById(questionFilter.getThemeId());
        if (theme == null) {
            return repository.findByTestId(questionFilter.getTestId(), questionFilter.getPageableObject()).map(QuestionDto::new);
        }
        Question question = new Question();
        question.setTheme(theme);
        Example<Question> example = Example.of(question);
        return repository.findAll(example, questionFilter.getPageableObject()).map(QuestionDto::new);
    }
}
