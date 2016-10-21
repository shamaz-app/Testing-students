package by.testing.repository.test;

import by.testing.entities.test.Question;
import by.testing.repository.SimpleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * Created by Анастасия on 07.09.2016.
 */
public interface QuestionRepository extends SimpleRepository<Question>, QueryByExampleExecutor<Question> {

    @Query(value = "Select q " +
            "from Question q " +
            "join q.theme th " +
            "where th.test.id = :testId ")
    Page<Question> findByTestId(@Param("testId") String testId,
                                Pageable pageable);

    @Query(value = "Select q " +
            "from Question q " +
            "join q.theme th " +
            "where th.id = :themeId ")
    Page<Question> findByThemeId(@Param("themeId") String themeId,
                                Pageable pageable);
}
