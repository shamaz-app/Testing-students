package by.testing.controller.test;

import by.testing.controller.GenericController;
import by.testing.dto.test.QuestionDto;
import by.testing.filters.test.QuestionFilter;
import by.testing.service.test.QuestionManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Анастасия on 12.09.2016.
 */
@RestController
@RequestMapping(value = "/api/test/question")
public class QuestionController extends GenericController<QuestionManageService>{

    @Autowired
    public QuestionController(QuestionManageService service) {
        super(service);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void addOrUpdateQuestion(@RequestBody QuestionDto questionDto) {
        service.saveQuestion(questionDto);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<QuestionDto> getAllQuestionsByTestId(QuestionFilter questionFilter) {
        return service.getQuestionList(questionFilter);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteQuestionById(@PathVariable("id") String id) {
        service.delete(id);
    }
}
