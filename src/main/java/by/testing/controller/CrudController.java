package by.testing.controller;

import by.testing.entities.IdEntity;
import by.testing.service.SimpleService;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Анастасия on 06.09.2016.
 */
public abstract class CrudController<E extends IdEntity, S extends SimpleService<E>> extends GenericController<S> {

    protected CrudController(S service) {
        super(service);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<E> get(@RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "limit", defaultValue = "25") @Range(min = 1, max = 50) int limit) {

        return service.getAll(page, limit);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public E getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void addOrUpdate(@RequestBody E entity) {
        service.save(entity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}