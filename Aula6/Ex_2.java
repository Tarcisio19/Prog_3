import java.util.HashSet;
import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> palavras = new HashSet<>();
        
        System.out.println("Digite palavras (digite 'fim' para parar):");
        String palavra;
        while (true) {
            palavra = scanner.nextLine();
            if (palavra.equalsIgnoreCase("fim")) {
                break;
            }
            palavras.add(palavra);
        }
        
        System.out.println("Palavras únicas digitadas:");
        for (String p : palavras) {
            System.out.println(p);
        }
        
        System.out.print("Digite uma palavra para verificar se foi digitada: ");
        String verificar = scanner.nextLine();
        
        if (palavras.contains(verificar)) {
            System.out.println("A palavra '" + verificar + "' foi digitada.");
        } else {
            System.out.println("A palavra '" + verificar + "' não foi digitada.");
        }
        
        scanner.close();
    }
}