import java.util.Scanner;

public class Ex348 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] nomes = new String[5]; 
        double[] notas1 = new double[5]; 
        double[] notas2 = new double[5]; 
        double[] medias = new double[5]; 
        
       
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o nome do " + (i+1) + "º aluno:");
            nomes[i] = sc.nextLine();
            
           
            sc.nextLine();
            
            System.out.println("Digite a primeira nota do aluno:");
            notas1[i] = sc.nextDouble(); 
            System.out.println("Digite a segunda nota do aluno:");
            notas2[i] = sc.nextDouble(); 
            
       
            medias[i] = (notas1[i] + notas2[i]) / 2;
            
            
            sc.nextLine();
        }
        
        
        System.out.println("Listagem de alunos:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Aluno: " + nomes[i]);
            System.out.println("Nota 1: " + notas1[i]);
            System.out.println("Nota 2: " + notas2[i]);
            System.out.println("Média: " + medias[i]);
            System.out.println();
        }
        sc.close();
    }

}