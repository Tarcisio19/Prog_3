import java.util.Scanner;

public class Ex_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[10];
        double soma = 0;
        
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            soma += notas[i];
        }
        
        double media = soma / 10;
        System.out.println("Média da turma: " + media);
        
        int acimaDaMedia = 0;
        int abaixoDaMedia = 0;
        
        for (int i = 0; i < 10; i++) {
            if (notas[i] > media) {
                acimaDaMedia++;
            } else if (notas[i] < media) {
                abaixoDaMedia++;
            }
        }
        
        System.out.println("Notas acima da média: " + acimaDaMedia);
        System.out.println("Notas abaixo da média: " + abaixoDaMedia);
        
        scanner.close();
    }
}