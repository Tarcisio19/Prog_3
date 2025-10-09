import java.io.*;
import java.util.Scanner;

public class Ex_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o caminho para um arquivo ou diretório: ");
        String caminho = scanner.nextLine();
        
        File arquivo = new File(caminho);
        
        if (arquivo.exists()) {
            if (arquivo.isFile()) {
                System.out.println("É um arquivo");
                System.out.println("Tamanho: " + arquivo.length() + " bytes");
            } else if (arquivo.isDirectory()) {
                System.out.println("É um diretório");
                System.out.println("Arquivos contidos:");
                String[] arquivos = arquivo.list();
                if (arquivos != null) {
                    for (String nomeArquivo : arquivos) {
                        System.out.println("  " + nomeArquivo);
                    }
                }
            }
            System.out.println("Caminho absoluto: " + arquivo.getAbsolutePath());
        } else {
            System.out.println("O arquivo ou diretório não existe");
        }
        
        scanner.close();
    }
}