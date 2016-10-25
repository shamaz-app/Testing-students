package by.testing.filters.test;

import by.testing.filters.BaseFilter;

import javax.validation.constraints.NotNull;

/**
 * Created by Анастасия on 12.09.2016.
 */
public class QuestionFilter extends BaseFilter {

    @NotNull
    private String testId;

    private String themeId;

    private String questionFilter;

    public String getQuestionFilter() {
        return questionFilter == null ? null : "%" + this.questionFilter + "%";
    }

    public void setQuestionFilter(String questionFilter) {
        this.questionFilter = questionFilter;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }
}
