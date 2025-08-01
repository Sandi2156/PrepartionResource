package package_dependency;

import java.util.List;
import java.util.Map;

public interface DependencyHandlingStrategy {
    public boolean isCyclic(Map<String, List<String>> packages);
    public List<String> getOrder(Map<String, List<String>> packages);
}
