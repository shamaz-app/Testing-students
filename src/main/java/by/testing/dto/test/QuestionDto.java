package by.testing.dto.test;

import by.testing.entities.test.Question;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Анастасия on 09.09.2016.
 */
public class QuestionDto {

    private String id;

    @NotNull
    private String question;

    @NotNull
    private ThemeDto themeDto;

    @NotNull
    private List<AnswerOptionDto> answerOptions = new ArrayList<>();

    public QuestionDto() {
        // do nothing
    }

    public QuestionDto(Question question) {
        this.id = question.getId();
        this.question = question.getQuestion();
        this.answerOptions = question.getAnswerOption().stream().map(AnswerOptionDto::new).collect(Collectors.toList());
        this.themeDto = new ThemeDto(question.getTheme());
    }

    public ThemeDto getThemeDto() {
        return themeDto;
    }

    public void setThemeDto(ThemeDto themeDto) {
        this.themeDto = themeDto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerOptionDto> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<AnswerOptionDto> answerOptions) {
        this.answerOptions = answerOptions;
    }
}
