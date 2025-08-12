package search_filter;

import search_filter.filter.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("abc.pdf", 35);
        File file2 = new File("defa.pdf", 18);
        File file3 = new File("abcd.pdf", 25);
        File file4 = new File("jkakbkc.pdf", 35);
        File file5 = new File("ikli.pdf", 300);
        File file6 = new File("ujkabc.pdf", 40);

        Directory directory = new Directory();
        directory.addFile(file1);
        directory.addFile(file2);
        directory.addFile(file3);
        directory.addFile(file4);
        directory.addFile(file5);
        directory.addFile(file6);

        IFilter nameFilter = new NameFilter("abc");
        IFilter sizeFilter = new SizeFilter(35, 40);

        List<IFilter> filters = new ArrayList<>();
        filters.add(nameFilter);
        filters.add(sizeFilter);
        IFilter andFilter = new AndFilter(filters);
        IFilter orFilter = new OrFilter(filters);

        DirectoryManager directoryManager = new DirectoryManager(directory);
        System.out.println("Result of AND Filter - ");
        directoryManager.getFilteredFiles(andFilter).forEach(file -> System.out.println(file.getName()));
        System.out.println("\n");

        System.out.println("Result of OR Filter - ");
        directoryManager.getFilteredFiles(orFilter).forEach(file -> System.out.println(file.getName()));
    }
}
