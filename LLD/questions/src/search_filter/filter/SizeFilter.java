package search_filter.filter;

import search_filter.File;

public class SizeFilter implements  IFilter{
    private int minSize, maxSize;

    public SizeFilter(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    public boolean matches(File file) {
        return file.getSize() >= minSize && file.getSize() <= maxSize;
    }
}
