package by.testing.dto;

/**
 * Created by Анастасия on 06.09.2016.
 */
public class SimpleValueDto<E> {
    private E value;

    public SimpleValueDto() {
    }

    public SimpleValueDto(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }
}
