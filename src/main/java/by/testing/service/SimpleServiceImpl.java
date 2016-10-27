package by.testing.service;

import by.testing.entities.IdEntity;
import by.testing.repository.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Анастасия on 06.09.2016.
 */
public abstract class SimpleServiceImpl<E extends IdEntity, R extends SimpleRepository<E>>
        implements SimpleService<E> {

    @Autowired
    protected R repository;

    @Override
    public E get(String id) {
        return repository.findById(id);
    }

    /**
     * Return all is pageable
     * @param page pagination page number
     * @param size pagination size
     *
     * @return
     */
    @Override
    public Page<E> getAll(int page, int size) {
        return repository.findAll(new PageRequest(page, size));
    }

    @Override
    @Transactional
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    @Transactional
    public String save(E entity) {
        repository.save(entity);
        return entity.getId();
    }

}
