import java.util.Scanner;

public class Ex356 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] nomes = new String[10];
        double[] pr1 = new double[10];
        double[] pr2 = new double[10];
        double[] medias = new double[10];
        String[] situacoes = new String[10];

        
        for (int i = 0; i < 15; i++) {
            System.out.println("Aluno " + (i + 1));
            System.out.print("Nome: ");
            nomes[i] = input.nextLine();
            System.out.print("Nota da PR1: ");
            pr1[i] = input.nextDouble();
            System.out.print("Nota da PR2: ");
            pr2[i] = input.nextDouble();

            medias[i] = Math.round(((pr1[i] + pr2[i]) / 2) * 10) / 10.0;

           
            if (medias[i] >= 6.0) {
                situacoes[i] = "AP";
            } else {
                situacoes[i] = "RP";
            }

            input.nextLine(); 
        }

        System.out.println("Nome\t\tPR1\tPR2\tMédia\tSituação");
        for (int i = 0; i < 15; i++) {
            System.out.println(nomes[i] + "\t" + pr1[i] + "\t" + pr2[i] + "\t" + medias[i] + "\t" + situacoes[i]);
        }

        input.close();
    }
}