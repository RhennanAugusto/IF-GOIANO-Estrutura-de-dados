import java.util.Scanner;

public class Ex23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número inteiro de 3 casas: ");
        int numero = sc.nextInt();
        
        int dezena = (numero / 10) % 10;
        System.out.println("O algarismo da casa das dezenas é: " + dezena);
        
        sc.close();
    }
}
