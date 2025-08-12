package search_filter.filter;

import search_filter.File;

import java.util.List;

public class AndFilter implements IFilter{
    private List<IFilter> filters;

    public AndFilter(List<IFilter> filters) {
        this.filters = filters;
    }

    public boolean matches(File file) {
        for(IFilter filter: filters) {
            if(!filter.matches(file)) return false;
        }
        return true;
    }
}
