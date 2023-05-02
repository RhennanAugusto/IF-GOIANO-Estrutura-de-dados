package Exercicio;

import java.util.Stack;

public class Hanoi {

    private static long count = 0;

    private static void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> auxiliary) {
        if (n > 0) {
            move(n - 1, source, auxiliary, target);
            target.push(source.pop());
            count++;
            move(n - 1, auxiliary, target, source);
        }
    }

    public static void main(String[] args) {
        int[] discs = {1, 10, 20, 30, 35, 40, 41};

        for (int d : discs) {
            Stack<Integer> source = new Stack<>();
            Stack<Integer> target = new Stack<>();
            Stack<Integer> auxiliary = new Stack<>();
            count = 0;
            for (int i = d; i > 0; i--) {
                source.push(i);
            }

            long startTime = System.currentTimeMillis();
            move(d, source, target, auxiliary);
            long endTime = System.currentTimeMillis();

            long timeTaken = endTime - startTime;
            int hours = (int) (timeTaken / (1000 * 60 * 60));
            int minutes = (int) (timeTaken / (1000 * 60)) % 60;
            int seconds = (int) (timeTaken / 1000) % 60;

            System.out.printf( "Discos: %d | Movimentos: %d | Tempo: %02d:%02d:%02d\n", d, count, hours, minutes, seconds);
            }
    }
}




