package package_dependency;

import java.util.List;

public class NodeInstaller implements Installer{
    public void install(List<String> packages) {
        for(String p: packages) {
            System.out.println("Installed package: " + p);
        }
    }
}
