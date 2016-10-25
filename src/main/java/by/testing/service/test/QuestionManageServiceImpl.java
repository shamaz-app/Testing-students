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
        question.setQuestion(questionDto.getQuestion());
        question.setTheme(themeRepository.findById(questionDto.getThemeDto().getId()));
        super.save(question);
        for (AnswerOptionDto answerOptionDto : questionDto.getAnswerOptions()) {
            if (answerOptionDto.isDeleted() && answerOptionDto.getId() != null) {
                answerOptionRepository.delete(answerOptionDto.getId());
            } else {
                AnswerOption answerOption;
                if (answerOptionDto.getId() == null) {
                    answerOption = new AnswerOption();
                } else {
                    answerOption = answerOptionRepository.findById(answerOptionDto.getId());
                }
                answerOption.setRight(answerOptionDto.isRight());
                answerOption.setOption(answerOptionDto.getOption());
                answerOption.setQuestion(question);
                answerOptionRepository.save(answerOption);
            }
        }
    }

    @Override
    public Page<QuestionDto> getQuestionList(QuestionFilter questionFilter) {
        Theme theme = themeRepository.findById(questionFilter.getThemeId());
        if (theme == null) {
            return repository.findByTestId(questionFilter.getTestId(), questionFilter.getQuestionFilter(), questionFilter.getPageableObject()).map(QuestionDto::new);
        }
        return repository.findByThemeId(questionFilter.getThemeId(), questionFilter.getQuestionFilter(), questionFilter.getPageableObject()).map(QuestionDto::new);
    }
}
