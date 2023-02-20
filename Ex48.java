import java.util.Scanner;

public class Ex48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double salarioMinimo, precoKw, valorPagar, valorPagarComDesconto;
        int qtdKw;
        
        System.out.print("Entre com o salário mínimo: ");
        salarioMinimo = sc.nextDouble();
        
        
        precoKw = salarioMinimo / 700;
        
        System.out.print("Entre com a quantidade de quilowatts consumidos: ");
        qtdKw = sc.nextInt();
        
        
        valorPagar = qtdKw * precoKw;
        
       
        valorPagarComDesconto = valorPagar * 0.9;
        
        System.out.printf("\nPreço do quilowatt: R$ %.2f", precoKw);
        System.out.printf("\nValor a ser pago: R$ %.2f", valorPagar);
        System.out.printf("\nValor a ser pago com desconto de 10%%: R$ %.2f", valorPagarComDesconto);
        
        sc.close();
    }
}
