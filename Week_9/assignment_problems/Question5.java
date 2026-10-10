import java.util.Scanner;
abstract class Appliance {
    double hours;
    Appliance(double hours) {
        this.hours = hours;
    }
    abstract double getPower();
}
interface SaverMode {
    double SAVING = 0.75;
}
class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }
    double getPower() {
        return 150;
    }
}
class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }
    double getPower() {
        return 1500;
    }
}
class TV extends Appliance {
    TV(double h) {
        super(h);
    }
    double getPower() {
        return 100;
    }
}
class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }
    double getPower() {
        return 500;
    }
}
public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");
            if (saver) {
                sc.next();
            }
            Appliance a;
            switch (type) {
                case "FRIDGE":
                    a = new Fridge(hours);
                    break;
                case "AC":
                    a = new AC(hours);
                    break;
                case "TV":
                    a = new TV(hours);
                    break;
                case "WASHER":
                    a = new Washer(hours);
                    break;
                default:
                    continue;
            }
            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }
            double units = a.getPower() * hours / 1000.0;
            if (saver) {
                units *= 0.75;
            }
            double cost = units * 8;
            total += cost;
            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );
        }
        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}
