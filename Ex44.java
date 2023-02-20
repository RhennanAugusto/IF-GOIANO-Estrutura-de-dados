import java.util.Scanner;
public class Ex44 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num , quad ,raizquad;
        System.out.print("\ndigite numero: ");
        num = scan.nextDouble();
        quad = num * (num);
        raizquad = Math.sqrt(num);
        System.out.printf("\nnumero: "+ num);
        System.out.printf("\nquadrado : "+ quad);
        System.out.printf("\nraiz quadrada : "+ raizquad);
        System.out.println("\n");

        scan.close();


    }
}
