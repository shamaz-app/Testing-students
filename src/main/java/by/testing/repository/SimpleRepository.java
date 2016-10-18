package by.testing.repository;

import by.testing.entities.IdEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Анастасия on 06.09.2016.
 */
@NoRepositoryBean
public interface SimpleRepository<E extends IdEntity> extends CrudRepository<E, String> {
    E findById(String id);

    Page<E> findAll(Pageable pageable);
}
