package by.testing.entities.test;

import by.testing.dto.test.QuestionDto;
import by.testing.entities.IdEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анастасия on 07.09.2016.
 */
@Entity
public class Question extends IdEntity {

    @NotNull
    private String question;

    @NotNull
    @ManyToOne(targetEntity = Theme.class)
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @JoinColumn(name = "QUESTION_ID")
    @OneToMany
    @NotNull
    private List<AnswerOption> answerOption = new ArrayList<>();

    public Question() {
        //default constructor
    }

    public Question(QuestionDto questionDto) {
        this.question = questionDto.getQuestion();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public List<AnswerOption> getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(List<AnswerOption> answerOption) {
        this.answerOption = answerOption;
    }
}
