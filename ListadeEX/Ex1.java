package ListadeEX;

import java.util.Scanner;
import java.util.Stack;

public class Ex1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a expressão matemática: ");
        String expressao = scanner.nextLine();
        scanner.close();

        if (verificarParametrizacao(expressao)) {
            System.out.println("A expressão está correta.");
        } else {
            System.out.println("A expressão está incorreta.");
        }
    }

    public static boolean verificarParametrizacao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (abreParenteses(caractere) || abreColchete(caractere) || abreChave(caractere)) {
                pilha.push(caractere);
            } else if (fechaParenteses(caractere)) {
                if (pilha.isEmpty() || pilha.pop() != '(') {
                    return false;
                }
            } else if (fechaColchete(caractere)) {
                if (pilha.isEmpty() || pilha.pop() != '[') {
                    return false;
                }
            } else if (fechaChave(caractere)) {
                if (pilha.isEmpty() || pilha.pop() != '{') {
                    return false;
                }
            }
        }

        return pilha.isEmpty();
    }

    public static boolean abreParenteses(char caractere) {
        return caractere == '(';
    }

    public static boolean fechaParenteses(char caractere) {
        return caractere == ')';
    }

    public static boolean abreColchete(char caractere) {
        return caractere == '[';
    }

    public static boolean fechaColchete(char caractere) {
        return caractere == ']';
    }

    public static boolean abreChave(char caractere) {
        return caractere == '{';
    }

    public static boolean fechaChave(char caractere) {
        return caractere == '}';
    }
}
