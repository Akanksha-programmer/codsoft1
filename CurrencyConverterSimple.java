import java.util.Scanner;

public class CurrencyConverterSimple {

    public static double getRate(String base, String target) {

        
        if (base.equals("USD") && target.equals("INR")) return 83.20;
        if (base.equals("INR") && target.equals("USD")) return 0.012;
        if (base.equals("EUR") && target.equals("INR")) return 90.50;
        if (base.equals("INR") && target.equals("EUR")) return 0.011;

        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Base Currency (USD/INR/EUR): ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter Target Currency: ");
        String target = sc.next().toUpperCase();

        
        double rate = getRate(base, target);

        if (rate == -1) {
            System.out.println("Conversion not available!");
            return;
        }

        
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        
        double result = amount * rate;

        
        System.out.println("\n==== RESULT ====");
        System.out.println(amount + " " + base + " = " + result + " " + target);
    }
}