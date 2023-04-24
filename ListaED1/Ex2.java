package ListaED1;

import java.util.*;

public class Ex2 {
    
    public static void main(String[] args) {
      
        Stack<String[]> pilha = new Stack<String[]>();
        
       
        pilha.push(new String[]{"chave1", "valor1"});
        pilha.push(new String[]{"chave2", "valor2"});
        pilha.push(new String[]{"chave3", "valor3"});
        
        String[] nomesJogadores = {"Neymar", "Messi", "CR7"};
        
        // exibe a pilha original
        System.out.println("Pilha original:");
        for (String[] item : pilha) {
            int indice = Integer.parseInt(item[0].substring(5)) - 1;
            System.out.println("- " + item[0] + ": " + nomesJogadores[indice] + " - " + item[1]);
        }
        
       
        System.out.println("Escolha a chave do item a ser removido:");
        for (String[] item : pilha) {
            System.out.println("- " + item[0] + ": " + nomesJogadores[Integer.parseInt(item[0].substring(5)) - 1]);
        }
        
       
        Scanner scanner = new Scanner(System.in);
        String chave = scanner.nextLine();
        
       
        Stack<String[]> aux = new Stack<String[]>();
        while (!pilha.isEmpty()) {
            String[] item = pilha.pop();
            if (item[0].equals(chave)) {
                break;
            } else {
                aux.push(item);
            }
        }
        while (!aux.isEmpty()) {
            pilha.push(aux.pop());
        }
        
        
        System.out.println("Pilha modificada:");
        for (String[] item : pilha) {
            int indice = Integer.parseInt(item[0].substring(5)) - 1;
            System.out.println("- " + item[0] + ": " + nomesJogadores[indice] + " - " + item[1]);
            
        }scanner.close();
    }
}
