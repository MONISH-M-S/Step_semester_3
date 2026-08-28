package classes_and_objects.assigment_problems;

class EmployeeStatic {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeStaticDemo {
    public static void main(String[] args) {
        new EmployeeStatic("A", 1000);
        new EmployeeStatic("B", 2000);
        new EmployeeStatic("C", 3000);
        System.out.println("3 Employee objects created");
        EmployeeStatic.printCompanyInfo();
    }
}
