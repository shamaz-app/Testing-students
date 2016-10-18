package by.testing.entities.test;

/**
 * Created by Анастасия on 09.09.2016.
 */
public enum TestStatus {
    WAITING("В ожидании"),
    RUNNING("Идет тест"),
    FINISHED("Закончен");

    private String name;

    TestStatus(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
