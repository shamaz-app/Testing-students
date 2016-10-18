package by.testing.filters;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Анастасия on 09.09.2016.
 */
public class BaseFilter {

    @NotNull
    protected Integer page = 0;

    @NotNull
    @Min(1)
    @Max(50)
    protected Integer limit = 5;

    @NotNull
    protected String sortProperty = "id";

    @NotNull
    protected Sort.Direction sortDirection = Sort.Direction.ASC;

    public Pageable getPageableObject() {
        Sort sort = new Sort(new Sort.Order(sortDirection, sortProperty));
        return new PageRequest(page, limit, sort);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSortProperty() {
        return sortProperty;
    }

    public void setSortProperty(String sortProperty) {
        this.sortProperty = sortProperty;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }
}