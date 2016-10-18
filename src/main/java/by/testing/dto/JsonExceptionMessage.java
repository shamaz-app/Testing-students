package by.testing.dto;

/**
 * Created by Анастасия on 06.09.2016.
 */
public class JsonExceptionMessage {

    private String error;
    private String message;

    public JsonExceptionMessage(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
