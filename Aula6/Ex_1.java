import java.util.ArrayList;
import java.util.Scanner;

public class Ex_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros.add(scanner.nextInt());
        }
        
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        double media = (double) soma / numeros.size();
        
        System.out.println("Soma total: " + soma);
        System.out.println("Média: " + media);
        
        numeros.removeIf(numero -> numero % 2 == 0);
        
        System.out.println("Lista atualizada (sem números pares):");
        for (int numero : numeros) {
            System.out.println(numero);
        }
        
        scanner.close();
    }
}