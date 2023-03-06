import java.util.Scanner;

public class Ex346 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String frase = "";
        int opcao = 0;

        System.out.print("Digite a frase que será manipulada: ");
        frase = input.nextLine();

        do {
            System.out.println("MENU");
            System.out.println("1 - Imprime o comprimento da frase");
            System.out.println("2 - Imprime os dois primeiros e os dois últimos caracteres da frase");
            System.out.println("3 - Imprime a frase espelhada");
            System.out.println("4 - Termina o algoritmo");
            System.out.print("Opção: ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("O comprimento da frase é " + frase.length() + " caracteres.");
                    break;
                case 2:
                    if (frase.length() >= 4) {
                        System.out.println("Os dois primeiros caracteres são " + frase.substring(0, 2) + " e os dois últimos caracteres são " + frase.substring(frase.length() - 2, frase.length()));
                    } else {
                        System.out.println("A frase precisa ter no mínimo 4 caracteres.");
                    }
                    break;
                case 3:
                    String fraseEspelhada = new StringBuilder(frase).reverse().toString();
                    System.out.println("A frase espelhada é " + fraseEspelhada);
                    break;
                case 4:
                    System.out.println("Algoritmo encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 4);

        input.close();
    }
}