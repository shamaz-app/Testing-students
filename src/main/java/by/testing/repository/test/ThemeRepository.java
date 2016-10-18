package by.testing.repository.test;

import by.testing.entities.test.Theme;
import by.testing.repository.SimpleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Date;
import java.util.List;

/**
 * Created by Анастасия on 07.09.2016.
 */
public interface ThemeRepository extends SimpleRepository<Theme>, QueryByExampleExecutor<Theme> {
    @Query(value = "Select th " +
            "from Theme th " +
            "where th.test.id = :testId ")
    Page<Theme> findByTestId(@Param("testId") String testId,
                           Pageable pageable);

}