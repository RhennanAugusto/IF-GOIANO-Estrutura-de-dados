import java.util.Scanner;

    public class Ex25 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int data,dia,mes,ano;
         System.out.print("Digite a data no formato ddmmaa: ");
        data = scan.nextInt();
        
         dia = data / 10000;
         mes = (data % 10000) / 100;
         ano = data%100;
         
        
        System.out.println("Dia: " + dia);
        System.out.println("Mês: " + mes);
        System.out.println("Ano:  "  + ano);
       
        
        scan.close();
    }
}


