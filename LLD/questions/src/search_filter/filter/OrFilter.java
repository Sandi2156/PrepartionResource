package search_filter.filter;

import search_filter.File;

import java.util.List;

public class OrFilter implements IFilter {
    private List<IFilter> filters;

    public OrFilter(List<IFilter> filters) {
        this.filters = filters;
    }

    public boolean matches(File file) {
        for(IFilter filter: filters) {
            if(filter.matches(file)) return true;
        }
        return false;
    }
}
