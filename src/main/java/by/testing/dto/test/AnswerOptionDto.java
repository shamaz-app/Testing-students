package by.testing.dto.test;

import by.testing.entities.test.AnswerOption;

import javax.validation.constraints.NotNull;

/**
 * Created by Анастасия on 09.09.2016.
 */
public class AnswerOptionDto {

    private String id;

    @NotNull
    private String option;

    @NotNull
    private boolean isRight;

    private boolean deleted;

    public AnswerOptionDto() {
        //default constructor
    }

    public AnswerOptionDto(AnswerOption answerOption) {
        this.id = answerOption.getId();
        this.option = answerOption.getOption();
        this.isRight = answerOption.isRight();
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
