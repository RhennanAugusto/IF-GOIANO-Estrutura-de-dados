package ListaDinamica;

import java.util.*;

public class Ex1 {
    public static void main(String[] args) {
        Stack<Integer> pilha1 = new Stack<>();
        Stack<Integer> pilha2 = new Stack<>();
        Stack<Integer> pilha3 = new Stack<>();
        
        
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int numero = random.nextInt(9) + 1;
            if (numero >= 1 && numero <= 3) {
                pilha1.push(numero);
            } else if (numero >= 4 && numero <= 6) {
                pilha2.push(numero);
            } else {
                pilha3.push(numero);
            }
        }
        
       
        for (int i = 0; i < 100; i++) {
            if (pilha1.isEmpty() || pilha2.isEmpty() || pilha3.isEmpty()) {
                System.out.println("O programa foi encerrado.");
                break;
            }
            
            int sorteio = random.nextInt(3) + 1;
            switch (sorteio) {
                case 1:
                    if (!pilha2.isEmpty() && !pilha3.isEmpty()) {
                        int num1 = pilha2.pop();
                        int num2 = pilha3.pop();
                        pilha1.push(num1);
                        pilha1.push(num2);
                        System.out.println("Empilhando os números " + num1 + " e " + num2 + " na pilha 1");
                    }
                    break;
                case 2:
                    if (!pilha1.isEmpty() && !pilha3.isEmpty()) {
                        int num1 = pilha1.pop();
                        int num2 = pilha3.pop();
                        pilha2.push(num1);
                        pilha2.push(num2);
                        System.out.println("Empilhando os números " + num1 + " e " + num2 + " na pilha 2");
                    }
                    break;
                case 3:
                    if (!pilha1.isEmpty() && !pilha2.isEmpty()) {
                        int num1 = pilha1.pop();
                        int num2 = pilha2.pop();
                        pilha3.push(num1);
                        pilha3.push(num2);
                        System.out.println("Empilhando os números " + num1 + " e " + num2 + " na pilha 3");
                    }
                    break;
            }
        }
        
       
        System.out.println("\nPilha 1: ");
        while (!pilha1.isEmpty()) {
            System.out.println(pilha1.pop());
        }
        
        System.out.println("\nPilha 2: ");
        while (!pilha2.isEmpty()) {
            System.out.println(pilha2.pop());
        }
        
        System.out.println("\nPilha 3: ");
        while (!pilha3.isEmpty()) {
            System.out.println(pilha3.pop());
        }
    }
}
