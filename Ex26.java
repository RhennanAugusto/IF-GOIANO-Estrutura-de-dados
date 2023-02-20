import java.util.Scanner;

    public class Ex26 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int data,dia,mes,ano,novadata;
         System.out.print("Digite a data no formato ddmmaa: ");
        data = scan.nextInt();
        
         dia = data / 10000;
         mes = (data % 10000) / 100;
         ano = data %100;
         novadata = mes * 10000 + dia * 100 + ano ;
        
        System.out.println("Dia: " + dia);
        System.out.println("Mês: " + mes);
        System.out.println("Ano:  "  + ano);
        System.out.println("Data no Formato MMDDAA : " + novadata);
       
        
        scan.close();
    }
}

