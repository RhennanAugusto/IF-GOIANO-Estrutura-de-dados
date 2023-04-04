package Exercicio;
import java.util.Stack;



public class Pilhainverter {
    public static String invertePalavras(String str) {
        Stack<Character> pilha = new Stack<>();
        StringBuilder resultado = new StringBuilder();
        StringBuilder palavra = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                pilha.push(c);
            } else {
                while (!pilha.isEmpty()) {
                    palavra.append(pilha.pop());
                }
                resultado.append(palavra).append(c);
                palavra.setLength(0);
            }
        }
        
        while (!pilha.isEmpty()) {
            palavra.append(pilha.pop());
        }
        resultado.append(palavra);
        
        return resultado.toString();
    }
    
    public static void main(String[] args) {
        String str1 = "NA MINHA OPINIÃO NEYMAR NO AUGE FOI O MELHOR JOGADOR QUE JA VI JOGAR";
        String str2 = "ESARF ATERCES ODALERAHCAB ME AICNEIC AD OACATUPMOC FI ONAIOG SUPMAC SOHNIRROM HE MU SOD SEROHLEM SOSRUC ED OACATUPMOC OD ODATSE ED SAIOG";
        
        System.out.println(invertePalavras(str1));
        System.out.println(invertePalavras(str2));
    }
}

