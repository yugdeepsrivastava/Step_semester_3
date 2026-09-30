import java.util.*;
abstract class Payment {
    double amount;
    Payment(double amount) {
        this.amount = amount;
    }
    abstract double calculateFinalAmount();   
    abstract String getType();
}
class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }
    double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }
    String getType() {
        return "CARD";
    }
}
class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }
    double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }
    String getType() {
        return "WALLET";
    }
}
class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }
    double calculateFinalAmount() {
        return amount;
    }
    String getType() {
        return "BANKTRANSFER";
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        Payment[] payments = new Payment[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amount);
            } 
            else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } 
            else {
                payments[i] = new BankTransferPayment(amount);
            }
        }
        for (Payment p : payments) {
            double finalAmount = p.calculateFinalAmount();
            System.out.printf("%s: %.2f%n",p.getType(), finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}