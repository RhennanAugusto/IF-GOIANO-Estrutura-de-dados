package ProblemaJoshepus;
import java.util.*;

public class Ex {
    public static void main(String[] args) {
        int n = 20; 
       
        Random rand = new Random(); 

        
        Stack<Integer> stack = new Stack<>();
        for (int i = n; i >= 1; i--) {
            stack.push(i);
        }

        List<Integer> eliminados = new ArrayList<>(); 
        
        while (stack.size() > 1) {
            int indexToRemove = rand.nextInt(stack.size()); 
            int count = 0;
            Stack<Integer> tempStack = new Stack<>();
            while (count < indexToRemove) { 
                tempStack.push(stack.pop());
                count++;
            }
            eliminados.add(stack.pop()); 
            while (!tempStack.isEmpty()) { 
                stack.push(tempStack.pop());
            }
        }
        int sobrevivente = stack.pop();
        System.out.println("A pessoa sobrevivente é a número " + sobrevivente);
        
        
        System.out.print("Pessoas eliminadas: ");
        for (int i = eliminados.size() - 1; i >= 0; i--) {
            System.out.print(eliminados.get(i) + " ");
        }
    }
}


