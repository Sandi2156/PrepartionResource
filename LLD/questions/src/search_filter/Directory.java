package search_filter;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private List<File> fileList;

    public Directory() {
        fileList = new ArrayList<>();
    }

    public void addFile(File file) {
        this.fileList.add(file);
    }

    public void removeFile(File file) {
        this.fileList.remove(file);
    }

    public List<File> getFileList() {
        return this.fileList;
    }
}
