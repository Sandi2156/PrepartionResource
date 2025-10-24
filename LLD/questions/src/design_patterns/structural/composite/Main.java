package design_patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

// It's mainly useful for tree like structural problem
interface Employee {
    public void showDetails(String indent);
}



// Leaf
class Developer implements Employee {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public void showDetails(String indent) {
        System.out.println(indent + name);
    }
}

class Designer implements Employee {
    private String name;

    public Designer(String name) {
        this.name = name;
    }

    public void showDetails(String indent) {
        System.out.println(indent + name);
    }
}

// Composite
class Manager implements Employee {
    private String name;
    private List<Employee> employees;

    public Manager(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void showDetails(String indent) {
        System.out.println(indent+name);
        for(Employee employee: employees) {
            employee.showDetails(indent + "-");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee developer = new Developer("sandipan");
        Employee designer = new Designer("rishav");
        Manager manager = new Manager("rajarshi");
        manager.add(developer);

        Manager manager1 = new Manager("Srijita");
        manager1.add(manager);
        manager1.add(designer);
        manager1.showDetails("");
    }
}
