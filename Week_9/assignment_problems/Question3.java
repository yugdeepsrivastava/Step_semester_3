import java.util.Scanner;
abstract class Student {
    String name;
    Student(String name) {
        this.name = name;
    }
    abstract double getFee();
}
interface BusUser {
    double BUS_FEE = 12000.0;
}
class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }
    double getFee() {
        return 40000 + BUS_FEE;
    }
}
class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }
    double getFee() {
        return 40000 + 60000;
    }
}
class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }
    double getFee() {
        return 20000 + BUS_FEE;
    }
}
public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            Student s;
            switch (type) {
                case "DAY_SCHOLAR":
                    s = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    s = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    s = new Scholar(name);
                    break;
                default:
                    continue;
            }
            double fee = s.getFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
