package by.testing.service.test;

import by.testing.dto.test.TestDto;
import by.testing.dto.test.ThemeDto;
import by.testing.entities.test.Test;
import by.testing.filters.test.TestFilter;
import by.testing.service.SimpleService;
import org.springframework.data.domain.Page;

/**
 * Created by Анастасия on 09.09.2016.
 */
public interface TestManageService extends SimpleService<Test> {

    /**
     * Save or update student by dto entity
     * @param testDto
     */
    void saveTest(TestDto testDto);

    void saveTheme(ThemeDto themeDto);

    void deleteTheme(String themeId);

    /**
     * Get theme of test
     * @param testFilter
     * @return
     */
    Page<ThemeDto> getThemesForTest(TestFilter testFilter);

    Page<TestDto> getTestList(TestFilter testFilter);

}
