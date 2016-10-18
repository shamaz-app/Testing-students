package by.testing.dto.test;

import by.testing.entities.test.Test;

import javax.validation.constraints.NotNull;

/**
 * Created by Анастасия on 09.09.2016.
 */
public class TestDto {

    private String id;

    @NotNull
    private String description;


    public TestDto() {
        //do nothing
    }

    public TestDto(Test test) {
        this.id = test.getId();
        this.description = test.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
