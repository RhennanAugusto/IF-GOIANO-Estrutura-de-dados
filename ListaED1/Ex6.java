package ListaED1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex6 {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<Integer>();
        Stack<Integer> pilha = new Stack<Integer>();

        for (int i = 0; i < 1000; i++) {
            int num = (int) (Math.random() * 1000) - 500;
            fila.offer(num);
        }
        for (int i = 0; i < 1000; i++) {
            int num = (int) (Math.random() * 1000);
            fila.offer(num);
        }

        while (!fila.isEmpty()) {
            int num = fila.peek();
            if (num >= 0) {
                fila.poll();
                pilha.push(num);
            } else {
                if (!pilha.isEmpty()) {
                    System.out.println("Número retirado da pilha: " + pilha.pop());
                }
                fila.poll();
            }
        }
    }
}
