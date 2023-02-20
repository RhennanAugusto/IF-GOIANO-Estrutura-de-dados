import java.util.Scanner;
public class Ex42 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Double angulo,rang;
        System.out.print("\nEntre com o angulo em graus : ");
        
        angulo = scan.nextDouble();
        rang = angulo * Math.PI / 180; 

        System.out.printf("\nSeno: %.2f", Math.sin(rang));
        System.out.printf("\nCo-seno: %.2f", Math.cos(rang));
        System.out.printf("\nTangente: %.2f", Math.tan(rang));
        System.out.printf("\nCo-secante: %.2f", 1 / Math.sin(rang));
        System.out.printf("\nSecante: %.2f", 1 / Math.cos(rang));
        System.out.printf("\nCotangente: %.2f", 1 / Math.tan(rang));

        scan.close();

      
   }
}
