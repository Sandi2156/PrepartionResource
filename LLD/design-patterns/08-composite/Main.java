import java.util.ArrayList;
import java.util.List;

interface Component {
    public void show(String indent);
}

class File implements Component {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void show(String indent) {
        System.out.println(indent + "- " + this.name);
    }
}

class Folder implements Component {
    private String name;
    private List<Component> componentList = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(Component component) {
        this.componentList.add(component);
    }

    public void remove(Component component) {
        this.componentList.remove(component);
    }

    public void show(String indent) {
        System.out.println(indent + "+ " + this.name);
        for(Component c: this.componentList) {
            c.show(indent + "  ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Component file1 = new File("file1.pdf");
        Component file2 = new File("fil2.txt");

        Folder folder1 = new Folder("folder1");
        folder1.add(file1);

        Folder folder2 = new Folder("folder2");
        folder2.add(file2);

        Folder root = new Folder("root");
        root.add(folder1);
        root.add(folder2);

        root.show("");
    }
}
