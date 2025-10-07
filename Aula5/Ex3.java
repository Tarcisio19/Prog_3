import java.util.Scanner;

public class Ex3 {
        public static void main(String[] args){
            
            String num;
            Scanner scanner = new Scanner(System.in);
        
            System.out.println("Digite um número inteiro: ");
            num = scanner.nextLine();

            try {
        
                int numero = Integer.parseInt(num);
                System.out.printf("Você digitou o número inteiro: %d\n", numero);
            } 
            catch (NumberFormatException excecao) {
        
                System.err.printf("Exceção: %s\n", excecao.getMessage());
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
            }
            finally{
        
                System.out.println("Finalizando o programa...");
            }
        }
    }


