import java.util.Scanner;

public class Ex351 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] nomes = new String[5];
        
      
        System.out.println("Digite cinco nomes:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Nome " + (i + 1) + ": ");
            nomes[i] = input.nextLine();
        }
        
       
        System.out.print("Digite um número correspondente a uma pessoa (de 1 a 5): ");
        int numero = input.nextInt();
        
        if (numero >= 1 && numero <= 5) {
            System.out.println("O nome correspondente ao número " + numero + " é: " + nomes[numero - 1]);
        } else {
            System.out.println("Número inválido.");
        }
        
        input.close();
    }

}