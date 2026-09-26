class Employees {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;
    Employees(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}
public class Main {
    public static void main(String[] args) {
        Employees e1 = new Employees("A", 30000);
        Employees e2 = new Employees("B", 40000);
        Employees e3 = new Employees("C", 50000);
        System.out.println("3 Employees objects created");
        Employees.printCompanyInfo();
    }
}