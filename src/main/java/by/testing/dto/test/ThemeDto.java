package by.testing.dto.test;

import by.testing.entities.test.Theme;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Анастасия on 09.09.2016.
 */
public class ThemeDto implements Serializable{

    private String id;

    @NotNull
    private String theme;

    private String testId;

    public ThemeDto() {
        //do nothing
    }

    public ThemeDto(Theme theme) {
        this.id = theme.getId();
        this.theme = theme.getTheme();
        this.testId = theme.getTest().getId();
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
