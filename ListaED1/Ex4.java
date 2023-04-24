package ListaED1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex4 {
    public static Queue<Integer> inverterFila(Queue<Integer> F1) {
        Stack<Integer> pilhaAuxiliar = new Stack<Integer>();
        while (!F1.isEmpty()) {
            pilhaAuxiliar.push(F1.poll());
        }
        Queue<Integer> F2 = new LinkedList<Integer>();
        while (!pilhaAuxiliar.isEmpty()) {
            F2.offer(pilhaAuxiliar.pop());
        }
        return F2;
    }

    public static void main(String[] args) {
        Queue<Integer> F1 = new LinkedList<Integer>();
        for (int i = 1; i <= 100; i++) {
            F1.offer((int)(Math.random() * 100));
        }
        System.out.println("F1: " + F1);

        Queue<Integer> F2 = inverterFila(F1);
        System.out.println("F2: " + F2);
    }
}

