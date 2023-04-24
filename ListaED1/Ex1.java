package ListaED1;

import java.util.Scanner;
import java.util.Stack;

public class Ex1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma sequência de caracteres:");
        String texto = scanner.nextLine();

        Stack<Character> pilha = new Stack<>();
        for (int i = 0; i < texto.length(); i++) {
            pilha.push(texto.charAt(i));
        }

       
        System.out.print("O texto na ordem inversa é: ");
        while (!pilha.isEmpty()) {
            System.out.print(pilha.pop());
        }
        System.out.println();

        String textoSemEspacosEPontos = texto.replaceAll("[.\\s]", ""); 
        pilha.clear(); // Limpando a pilha
        for (int i = 0; i < textoSemEspacosEPontos.length(); i++) {
            pilha.push(textoSemEspacosEPontos.charAt(i));
        }
        String textoInvertidoSemEspacosEPontos = "";
        while (!pilha.isEmpty()) {
            textoInvertidoSemEspacosEPontos += pilha.pop();
        }
        String textoSemEspacosEPontosMinusculo = textoSemEspacosEPontos.toLowerCase(); 
        String textoInvertidoSemEspacosEPontosMinusculo = textoInvertidoSemEspacosEPontos.toLowerCase();
        boolean ehPalindromo = textoSemEspacosEPontosMinusculo.equals(textoInvertidoSemEspacosEPontosMinusculo);
        if (ehPalindromo) {
            System.out.println("O texto é um palíndromo!");
        } else {
            System.out.println("O texto não é um palíndromo!");
        }
        scanner.close();
    }
}


