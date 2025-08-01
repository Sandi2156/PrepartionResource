package package_dependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KahnAlgo implements DependencyHandlingStrategy{
    public boolean isCyclic(Map<String, List<String>> packages) {
        // use kahn algorithm to check for cyclic or use normal dfs
        return true;
    }

    public List<String> getOrder(Map<String, List<String>> packages) {
        // use kahn algo to get toplogical sorted list
        return new ArrayList<>();
    }
}
