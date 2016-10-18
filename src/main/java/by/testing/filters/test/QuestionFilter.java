package by.testing.filters.test;

import by.testing.filters.BaseFilter;

import javax.validation.constraints.NotNull;

/**
 * Created by Анастасия on 12.09.2016.
 */
public class QuestionFilter extends BaseFilter {

    @NotNull
    private String themeId;

    @NotNull
    private String testId;

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
