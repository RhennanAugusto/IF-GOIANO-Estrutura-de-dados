package ListaED1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        ArrayList<String[]> filaAvioes = new ArrayList<String[]>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Controle de Pista de Decolagem ---");
            System.out.println("1. Listar número de aviões aguardando na fila");
            System.out.println("2. Autorizar decolagem do primeiro avião da fila");
            System.out.println("3. Adicionar um avião à fila de espera");
            System.out.println("4. Listar todos os aviões na fila de espera");
            System.out.println("5. Listar características do primeiro avião da fila");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            if (opcao == 1) {
                System.out.println("Aviões aguardando na fila: " + filaAvioes.size());
            } else if (opcao == 2) {
                if (filaAvioes.isEmpty()) {
                    System.out.println("Não há aviões aguardando na fila!");
                } else {
                    String[] aviao = filaAvioes.remove(0);
                    System.out.println("Avião " + aviao[0] + " autorizado para decolagem!");
                }
            } else if (opcao == 3) {
                System.out.print("Digite o nome do avião: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o número de identificação do avião: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                String[] aviao = {nome, Integer.toString(id)};
                filaAvioes.add(aviao);
                System.out.println("Avião " + nome + " adicionado à fila de espera!");
            } else if (opcao == 4) {
                System.out.println("Aviões na fila de espera:");
                for (String[] aviao : filaAvioes) {
                    System.out.println(aviao[0] + " - " + aviao[1]);
                }
            } else if (opcao == 5) {
                if (filaAvioes.isEmpty()) {
                    System.out.println("Não há aviões aguardando na fila!");
                } else {
                    String[] aviao = filaAvioes.get(0);
                    System.out.println("Nome: " + aviao[0]);
                    System.out.println("Identificador: " + aviao[1]);
                }
            } else if (opcao == 0) {
                System.out.println("Encerrando o programa...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
            
        }scanner.close();
    } 
}
