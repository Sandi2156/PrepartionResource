package search_filter.filter;

import search_filter.File;

public class NameFilter implements IFilter {
    private String pattern;

    public NameFilter(String pattern) {
        this.pattern = pattern;
    }

    public boolean matches(File file) {
        return file.getName().contains(pattern);
    }
}
