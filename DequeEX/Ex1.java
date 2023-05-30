package DequeEX;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {
        Deque<Pessoa> filaAtendimento = new ArrayDeque<>();
        Deque<Pessoa> naoAtendidas = new ArrayDeque<>();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int idade = random.nextInt(90) + 10; 
            boolean necessidadeEspecial = random.nextBoolean();
            boolean gestante = random.nextBoolean();
            boolean lactante = random.nextBoolean();

            filaAtendimento.add(new Pessoa(i + 1, idade, necessidadeEspecial, gestante, lactante));
        }

        
        int quantidadeAtendida = 1;
        for (int grupo = 1; grupo <= 10; grupo++) {
            for (int i = 0; i < quantidadeAtendida; i++) {
                Pessoa pessoa = filaAtendimento.pollFirst();

                if (pessoa != null) {
                    int prioridade = obterPrioridade(pessoa);
                    if (prioridade < grupo - 1) {
                        naoAtendidas.add(pessoa); 
                    } else {
                       
                        System.out.println("Grupo " + grupo + ": Atendendo pessoa " + pessoa.getId() +
                                " - Prioridade: " + prioridadeToString(prioridade));
                    }
                }
            }
            quantidadeAtendida++;
        }

       
        System.out.println("\nPessoas não atendidas:");
        for (Pessoa pessoa : naoAtendidas) {
            System.out.println("ID: " + pessoa.getId() + ", Prioridade: " + prioridadeToString(obterPrioridade(pessoa)));
        }
    }

    
    private static int obterPrioridade(Pessoa pessoa) {
        if (pessoa.getIdade() >= 60) {
            return 1;
        } else if (pessoa.isNecessidadeEspecial()) {
            return 2;
        } else if (pessoa.isGestante() || pessoa.isLactante()) {
            return 3;
        } else {
            return 0;
        }
    }

    
    private static String prioridadeToString(int prioridade) {
        switch (prioridade) {
            case 0:
                return "Normal";
            case 1:
                return "Acima de 60 anos";
            case 2:
                return "Necessidades especiais";
            case 3:
                return "Gestante/Lactante";
            default:
                return "";
        }
    }
}

class Pessoa {
    private int id;
    private int idade;
    private boolean necessidadeEspecial;
    private boolean gestante;
    private boolean lactante;

    public Pessoa(int id, int idade, boolean necessidadeEspecial, boolean gestante, boolean lactante) {
        this.id = id;
        this.idade = idade;
        this.necessidadeEspecial = necessidadeEspecial;
        this.gestante = gestante;
        this.lactante = lactante;
    }

    public int getId() {
        return id;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public boolean isGestante() {
        return gestante;
    }

    public boolean isLactante() {
        return lactante;
    }
}
