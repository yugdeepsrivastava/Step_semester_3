import java.util.*;
import java.time.LocalDate;
abstract class Plan {
    String name;
    LocalDate startDate;
    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    abstract int getValidityDays();
    LocalDate getRenewalDate() {
        return startDate.plusDays(
            getValidityDays());
    }
}
class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    int getValidityDays() {
        return 30;
    }
}
class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    int getValidityDays() {
        return 90;
    }
}
class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }
    int getValidityDays() {
        return 365;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Plan[] plans = new Plan[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();
            LocalDate startDate = LocalDate.parse(date);
            if (type.equals("BASIC")) {
                plans[i] = new BasicPlan( name, startDate);
            }
            else if (type.equals("STANDARD")) {
                plans[i] =
                    new StandardPlan( name, startDate);
            }
            else {
                plans[i] = new PremiumPlan(name, startDate);
            }
        }
        for (Plan p : plans) {
            System.out.println(p.name + ": " + p.getRenewalDate());
        }
    }
}