import java.util.Scanner;
public class Ex43 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Double num,logaritimo ;
        System.out.print("\nEntre com o logaritimo : ");
        num = scan.nextDouble();
        logaritimo = Math.log(num)/Math.log(10);
        System.out.printf("\nlogaritimo : "+ logaritimo);
        System.out.println("\n");

        scan.close();

   }


}
