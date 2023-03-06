import java.util.Scanner;

public class Ex360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int dia, mes;
        
        while (true) {
            System.out.print("Digite a data de nascimento (ddmm) ou 9999 para sair: ");
            int data = sc.nextInt();
            
            if (data == 9999) {
                break; // sai do laço caso seja digitado 9999
            }
            
            dia = data / 100; // obtém o dia
            mes = data % 100; // obtém o mês
            
            String signo = ""; // inicializa a variável que irá armazenar o signo
            
            switch (mes) {
                case 1:
                    if (dia <= 20) {
                        signo = "Capricórnio";
                    } else {
                        signo = "Aquário";
                    }
                    break;
                case 2:
                    if (dia <= 19) {
                        signo = "Aquário";
                    } else {
                        signo = "Peixes";
                    }
                    break;
                case 3:
                    if (dia <= 20) {
                        signo = "Peixes";
                    } else {
                        signo = "Áries";
                    }
                    break;
                case 4:
                    if (dia <= 20) {
                        signo = "Áries";
                    } else {
                        signo = "Touro";
                    }
                    break;
                case 5:
                    if (dia <= 20) {
                        signo = "Touro";
                    } else {
                        signo = "Gêmeos";
                    }
                    break;
                case 6:
                    if (dia <= 20) {
                        signo = "Gêmeos";
                    } else {
                        signo = "Câncer";
                    }
                    break;
                case 7:
                    if (dia <= 21) {
                        signo = "Câncer";
                    } else {
                        signo = "Leão";
                    }
                    break;
                case 8:
                    if (dia <= 22) {
                        signo = "Leão";
                    } else {
                        signo = "Virgem";
                    }
                    break;
                case 9:
                    if (dia <= 22) {
                        signo = "Virgem";
                    } else {
                        signo = "Libra";
                    }
                    break;
                case 10:
                    if (dia <= 22) {
                        signo = "Libra";
                    } else {
                        signo = "Escorpião";
                    }
                    break;
                case 11:
                    if (dia <= 21) {
                        signo = "Escorpião";
                    } else {
                        signo = "Sagitário";
                    }
                    break;
                case 12:
                    if (dia <= 21) {
                        signo = "Sagitário";
                    } else {
                        signo = "Capricórnio";
                    }
                    break;
                default:
                    break;
            }
            
            System.out.println("Seu signo é " + signo);
        }
        
        sc.close();
    }
}