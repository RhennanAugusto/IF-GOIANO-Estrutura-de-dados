package ListaED1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex5 {
    public static void main(String[] args) {
        Queue<Integer> F = new LinkedList<Integer>();
        Stack<Integer> P = new Stack<Integer>();

        for (int i = 0; i < 1000; i++) {
            int n = (int) (Math.random() * 1000);

            if (!F.contains(n)) {
                F.offer(n);
            } else {
                P.push(n);
            }
        }

        System.out.println("Fila F: " + F);
        System.out.println("Pilha P: " + P);
    }
}
