package by.testing.repository.test;

import by.testing.entities.test.Test;
import by.testing.repository.SimpleRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * Created by Анастасия on 07.09.2016.
 */
public interface TestRepository extends SimpleRepository<Test>, QueryByExampleExecutor<Test> {
}
