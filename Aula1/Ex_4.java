import java.util.Scanner;

public class Ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        int quantidade = 0;
        int soma = 0;
        
        do {
            System.out.print("Digite um número inteiro (negativo para sair): ");
            numero = scanner.nextInt();
            
            if (numero >= 0) {
                quantidade++;
                soma += numero;
            }
        } while (numero >= 0);
        
        if (quantidade > 0) {
            double media = (double) soma / quantidade;
            System.out.println("Quantidade de números digitados: " + quantidade);
            System.out.println("Média dos números: " + media);
        } else {
            System.out.println("Nenhum número válido foi digitado.");
        }
        
        scanner.close();
    }
}