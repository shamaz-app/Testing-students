package by.testing.entities.test;

import by.testing.entities.IdEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Анастасия on 07.09.2016.
 */
@Entity
public class Test extends IdEntity {

    @NotNull
    private String description;

    /**
     * Define status of test.
     * May be 'running', 'waiting' or 'finished'
     */
    @Enumerated(EnumType.STRING)
    private TestStatus testStatus;


    public TestStatus getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(TestStatus testStatus) {
        this.testStatus = testStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
