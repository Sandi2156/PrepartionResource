package package_dependency;

import java.util.*;

public class PackageManager {
    private Map<String, List<String>> packages;
    private Set<String> installedPackages;
    private DependencyHandlingStrategy dependencyHandlingStrategy;
    private Installer installer;

    public PackageManager(DependencyHandlingStrategy dependencyHandlingStrategy, Installer installer) {
        packages = new HashMap<>();
        installedPackages = new HashSet<>();
        this.dependencyHandlingStrategy = dependencyHandlingStrategy;
        this.installer = installer;
    }

    private void installPackage(String packageName) {
        if(dependencyHandlingStrategy.isCyclic(packages)) {
            System.out.println("We can not install the package! there is dependencies.");
            return;
        }

        List<String> orderedPackages = dependencyHandlingStrategy.getOrder(packages);
        installer.install(orderedPackages);
    }

    public void addPackage(String packageName, List<String> dependencies) {
        if(dependencyHandlingStrategy.isCyclic(packages)) {
            System.out.println("We can not add the package! there is dependencies.");
            return;
        }
        packages.put(packageName, dependencies);
    }

    public void install(String packageName) {
        if(installedPackages.contains(packageName)) {
            System.out.println("This package is already installed!");
            return;
        }

        this.installPackage(packageName);
    }

    public void installAll() {
        for(String packageName: packages.keySet()) {
            this.install(packageName);
        }
    }

    public void getInstalledPackages() {
        for(String packageName: installedPackages) {
            System.out.println(packageName);
        }
    }
}
