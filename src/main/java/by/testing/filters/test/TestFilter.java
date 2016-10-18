package by.testing.filters.test;

import by.testing.filters.BaseFilter;

/**
 * Created by Анастасия on 09.09.2016.
 */
public class TestFilter extends BaseFilter {

    private String testId;

    private String descriptionStartWith;

    public String getDescriptionStartWith() {
        return descriptionStartWith;
    }

    public void setDescriptionStartWith(String descriptionStartWith) {
        this.descriptionStartWith = descriptionStartWith;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }
}
