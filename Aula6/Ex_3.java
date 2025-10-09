import java.util.HashMap;
import java.util.Scanner;

public class Ex_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> pessoas = new HashMap<>();
        
        System.out.println("Cadastro de pessoas (máximo 5):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o nome da pessoa " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            System.out.print("Digite a idade de " + nome + ": ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            
            pessoas.put(nome, idade);
        }
        
        System.out.print("Digite um nome para buscar: ");
        String nomeBusca = scanner.nextLine();
        
        if (pessoas.containsKey(nomeBusca)) {
            System.out.println(nomeBusca + " tem " + pessoas.get(nomeBusca) + " anos.");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
        
        System.out.print("Digite um nome para remover: ");
        String nomeRemover = scanner.nextLine();
        
        if (pessoas.remove(nomeRemover) != null) {
            System.out.println(nomeRemover + " foi removido.");
        } else {
            System.out.println("Pessoa não encontrada para remoção.");
        }
        
        System.out.println("Mapa atualizado:");
        for (String nome : pessoas.keySet()) {
            System.out.println(nome + " - " + pessoas.get(nome) + " anos");
        }
        
        scanner.close();
    }
}