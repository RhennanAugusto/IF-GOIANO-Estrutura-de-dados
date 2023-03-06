import java.util.Scanner;

public class Ex358 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = 5; // número de mercadorias
        
        int countLucroMenor10 = 0; // contador de mercadorias com lucro inferior a 10%
        int countLucroEntre10e20 = 0; // contador de mercadorias com lucro entre 10% e 20%
        int countLucroMaior20 = 0; // contador de mercadorias com lucro superior a 20%
        
        for (int i = 1; i <= n; i++) {
            System.out.println("Mercadoria " + i + ":");
            System.out.print("Preço de compra: ");
            double precoCompra = sc.nextDouble();
            System.out.print("Preço de venda: ");
            double precoVenda = sc.nextDouble();
            
            double lucro = (precoVenda - precoCompra) / precoCompra * 100; // calcula o lucro em porcentagem
            
            if (lucro < 10) {
                countLucroMenor10++;
            } else if (lucro <= 20) {
                countLucroEntre10e20++;
            } else {
                countLucroMaior20++;
            }
        }
        
        System.out.println("Mercadorias com lucro inferior a 10%: " + countLucroMenor10);
        System.out.println("Mercadorias com lucro entre 10% e 20%: " + countLucroEntre10e20);
        System.out.println("Mercadorias com lucro superior a 20%: " + countLucroMaior20);
        
        sc.close();
    }
}