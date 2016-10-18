package by.testing.service;

import org.springframework.data.domain.Page;

/**
 * Created by Анастасия on 06.09.2016.
 */
public interface SimpleService<E> {

    E get(String id);

    Page<E> getAll(int page, int size);

    void delete(String id);

    String save(E entity);
}
