package by.testing.utils;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Анастасия on 07.09.2016.
 */
public final class ExceptionUtils {

    private ExceptionUtils() {
    }

    public static void throwUsernameNotFoundException(Class<?> clazz) {

        String errorMessage = "Username not found!";
        LoggerFactory.getLogger(clazz).error(errorMessage);
        throw new UsernameNotFoundException(errorMessage);
    }

    public static void throwNullPointerException(Class<?> clazz) {

        String errorMessage = clazz.getName() + " throws null pointer!";
        LoggerFactory.getLogger(clazz).error(errorMessage);
        throw new NullPointerException(errorMessage);
    }

}
