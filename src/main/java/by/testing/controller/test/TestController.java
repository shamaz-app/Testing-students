package by.testing.controller.test;

import by.testing.controller.GenericController;
import by.testing.dto.test.TestDto;
import by.testing.dto.test.ThemeDto;
import by.testing.entities.test.Test;
import by.testing.filters.BaseFilter;
import by.testing.filters.test.TestFilter;
import by.testing.service.test.QuestionManageService;
import by.testing.service.test.TestManageService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Анастасия on 09.09.2016.
 */
@RestController
@RequestMapping("/api/test")
public class TestController extends GenericController<TestManageService>{

    @Autowired
    public TestController(TestManageService service) {
        super(service);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<TestDto> getAllTests(TestFilter testFilter) {
        return service.getTestList(testFilter);
    }

    /**
     * Get themes for test
     * @param testFilter
     * @return
     */
    @RequestMapping(value = "/theme", method = RequestMethod.GET)
    public List<ThemeDto> getThemesByTest(TestFilter testFilter) throws IOException {
      return service.getThemesForTest(testFilter);
    }
    @RequestMapping(value = "/theme", method = RequestMethod.PUT)
    public void addOrUpdateTheme(@RequestBody ThemeDto themeDto) {
        service.saveTheme(themeDto);
    }


    @RequestMapping(value = "/theme/{id}", method = RequestMethod.DELETE)
    public void deleteTheme(@PathVariable("id") String id) {
        service.deleteTheme(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TestDto getById(@PathVariable("id") String id) {
        return new TestDto(service.get(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void addOrUpdateTest(@RequestBody TestDto testDto) {
        service.saveTest(testDto);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
