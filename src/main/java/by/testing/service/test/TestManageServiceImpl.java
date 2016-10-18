package by.testing.service.test;

import by.testing.dto.test.QuestionDto;
import by.testing.dto.test.TestDto;
import by.testing.dto.test.ThemeDto;
import by.testing.entities.test.Test;
import by.testing.entities.test.TestStatus;
import by.testing.entities.test.Theme;
import by.testing.filters.test.TestFilter;
import by.testing.repository.test.TestRepository;
import by.testing.repository.test.ThemeRepository;
import by.testing.service.SimpleServiceImpl;
import by.testing.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by Анастасия on 09.09.2016.
 */
@Service
public class TestManageServiceImpl extends SimpleServiceImpl<Test, TestRepository> implements TestManageService {

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public void saveTest(TestDto testDto) {
        if (!testDto.getDescription().isEmpty()) {
            Test test = new Test();
            if (testDto.getId() != null && !testDto.getId().isEmpty()) {
                test = get(testDto.getId());
            }
            test.setDescription(testDto.getDescription());
            test.setTestStatus(TestStatus.WAITING);
            repository.save(test);
        }
    }

    @Override
    public void saveTheme(ThemeDto themeDto) {
        if (!themeDto.getTheme().isEmpty() && !themeDto.getTestId().isEmpty()) {
            Theme theme = new Theme();
            if (themeDto.getId() != null && !themeDto.getId().isEmpty()) {
                theme = themeRepository.findById(themeDto.getId());
            }
            theme.setTheme(themeDto.getTheme());
            theme.setTest(get(themeDto.getTestId()));
            themeRepository.save(theme);
        }
    }

    @Override
    public void deleteTheme(String themeId) {
        if (!themeId.isEmpty()) {
            themeRepository.delete(themeId);
        }
    }

    @Override
    public Page<ThemeDto> getThemesForTest(TestFilter testFilter) {
        if (testFilter.getTestId() == null) {
            ExceptionUtils.throwNullPointerException(this.getClass());
            return null;
        }
        testFilter.setSortProperty("theme");
        return themeRepository.findByTestId(testFilter.getTestId(), testFilter.getPageableObject())
                .map(ThemeDto::new);
    }

    @Override
    public Page<TestDto> getTestList(TestFilter testFilter) {
        Test test = new Test();
        test.setDescription(testFilter.getDescriptionStartWith());
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("description", ExampleMatcher.GenericPropertyMatcher::startsWith);

        Example<Test> example = Example.of(test, matcher);

        testFilter.setSortProperty("description");
        return repository.findAll(example, testFilter.getPageableObject())
                .map(TestDto::new);
    }
}
