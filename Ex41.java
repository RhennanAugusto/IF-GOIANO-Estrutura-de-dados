import java.util.Scanner;
public class Ex41 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a, b, c,d, mp;
        System.out.print("\nEntre com o 1 numero : ");
        a = scan.nextInt();
        System.out.print("\nEntre com o 2 numero : ");
        b = scan.nextInt();
        System.out.print("\nEntre com o 3 numero : ");
        c = scan.nextInt();
        System.out.print("\nEntre com o 4 numero : ");
        d = scan.nextInt();
        mp =  (a*1 + b*2 + c*3 + d*4)/10 ;
        System.out.printf("\nmedia ponderada :" + mp);
        System.out.println("\n");

        scan.close();

      
   }
}
