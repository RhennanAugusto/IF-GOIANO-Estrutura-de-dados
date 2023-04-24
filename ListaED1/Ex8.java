package ListaED1;

import java.util.Random;
import java.util.Stack;

public class Ex8 {
    public static void main(String[] args) {
        Random rand = new Random();
        Stack<Integer> N = new Stack<>();
        Stack<Integer> P = new Stack<>();

        // Sorteia 1000 números entre -100 e 100 e adiciona na pilha P ou N
        for (int i = 0; i < 1000; i++) {
            int num = rand.nextInt(201) - 100; // números variando entre -100 e 100
            if (num > 0) {
                P.push(num);
            } else if (num < 0) {
                N.push(num);
            } else {
                if (!N.empty() && !P.empty()) {
                    System.out.println(N.pop() + " " + P.pop());
                }
            }
        }
    }
}

