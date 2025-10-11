import java.util.Scanner;

public class Ex_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a idade: ");
        int idade = scanner.nextInt();
        
        if (idade < 16) {
            System.out.println("Não pode votar");
        } else if ((idade >= 16 && idade <= 17) || idade > 65) {
            System.out.println("Voto facultativo");
        } else {
            System.out.println("Voto obrigatório");
        }
        
        scanner.close();
    }
}