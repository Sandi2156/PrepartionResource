package search_filter.filter;

import search_filter.File;

public interface IFilter {
    public boolean matches(File file);
}
