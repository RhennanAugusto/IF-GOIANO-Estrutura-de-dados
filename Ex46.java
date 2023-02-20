import java.util.Scanner;
public class Ex46 {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       double saldo ,nsaldo;
       System.out.print("\ndigite o saldo: ");
       saldo = scan.nextDouble();
       nsaldo = saldo * (1.01);
       System.out.printf("\nnovo saldo: "+ nsaldo);
       System.out.println("\n");
       
       scan.close();
    }
}
