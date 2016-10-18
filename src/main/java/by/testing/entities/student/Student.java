package by.testing.entities.student;

import by.testing.entities.IdEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by Анастасия on 07.09.2016.
 */
@Entity
public class Student extends IdEntity {

    @NotNull
    private String name;

    @NotNull
    private String group;

    private String sheetNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSheetNumber() {
        return sheetNumber;
    }

    public void setSheetNumber(String sheetNumber) {
        this.sheetNumber = sheetNumber;
    }
}
