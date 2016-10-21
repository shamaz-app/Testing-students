package by.testing.entities.test;

import by.testing.dto.test.AnswerOptionDto;
import by.testing.entities.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by Анастасия on 07.09.2016.
 */
@Entity
public class AnswerOption extends IdEntity {

    @Column(name = "answer_option")
    @NotNull
    private String option;

    @NotNull
    @ManyToOne
    private Question question;

    @Column(name = "is_right")
    @NotNull
    private boolean right;

    public AnswerOption() {
        //default constructor
    }

    public AnswerOption(AnswerOptionDto answerOptionDto) {
        this.option = answerOptionDto.getOption();
        this.right = answerOptionDto.isRight();
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
