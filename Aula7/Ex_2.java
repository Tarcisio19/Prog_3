import java.io.*;
import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            PrintStream ps = new PrintStream("saida.txt");
            String linha;
            
            System.out.println("Digite as linhas (digite 'FIM' para encerrar):");
            
            while (!(linha = scanner.nextLine()).equals("FIM")) {
                ps.println(linha);
            }
            
            ps.close();
            scanner.close();
            System.out.println("Arquivo 'saida.txt' criado com sucesso!");
            
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }
}