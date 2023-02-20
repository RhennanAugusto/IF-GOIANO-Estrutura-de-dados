import java.util.Scanner;
public class Ex40 {
     public static void main(String[] args) {
           Scanner scan = new Scanner(System.in);
           int quoc, rest, val1, val2;
           System.out.print("\nEntre com o dividendo : ");
           val1 = scan.nextInt();
           System.out.print("\nEntre com o quociente : ");
           val2 = scan.nextInt();

           quoc = (val1/val2);
           rest = (val1 % val2);

           System.out.println("\n\n\n");
           System.out.printf("\ndividendo :"+val1);
           System.out.printf("\ndivisor :"+val2);
           System.out.printf("\nquociente :"+quoc);
           System.out.printf("\nresto :"+rest);
           System.out.println("\n");


           scan.close();
        }

    }


