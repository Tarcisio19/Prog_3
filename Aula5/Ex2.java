import java.util.Scanner;

public class Ex2 {
    
    public static double calcularRaiz(double numero) 
        throws IllegalArgumentException 
    {
        if (numero < 0) {
            throw new IllegalArgumentException("Número negativo não permitido");
        }
        double raiz = Math.sqrt(numero);
        return raiz;
    }

    public static void main(String[] args) {

        double numero;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número: ");
        numero = scanner.nextDouble();

        try {

            double resultado = calcularRaiz(numero);
            System.out.printf("A raiz quadrada de %.2f é %.2f\n", numero, resultado);
        } catch (IllegalArgumentException excecao) {

            System.err.printf("Exceção: %s\n", excecao.getMessage());
            System.out.println("Número negativo! Raiz quadrada de número negativo não é definida nos números reais.");
        }
    }
}
