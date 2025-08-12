package search_filter;

import search_filter.filter.IFilter;

import java.util.ArrayList;
import java.util.List;

public class DirectoryManager {
    private Directory directory;

    public DirectoryManager(Directory directory) {
        this.directory = directory;
    }

    public List<File> getFilteredFiles(IFilter filter) {
        List<File> files = new ArrayList<>();
        directory.getFileList().forEach(file -> {
            if(filter.matches(file)) files.add(file);
        });

        return files;
    }
}
 