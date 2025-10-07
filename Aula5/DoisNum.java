import java.util.Scanner;

public class DoisNum {
    
    public static double Divisao(int n1, int n2)
        throws ArithmeticException
    {
        return n1/n2;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        boolean Continua = true;
        do{
            
            try{
            System.out.println("Digite um número: ");
            int Num1 = scanner.nextInt();
    
            System.out.println("Digite outro número: ");
            int Num2 = scanner.nextInt();
    
            double Divisao = Num1/Num2;
            System.out.printf("Divisão de %d por %d é igual a: %f\n", Num1, Num2, Divisao);
            Continua = false;
            }

            catch(ArithmeticException arithmeticexception) //Erro no calculo da divisão
            {
                System.err.printf("Exceção: %f\n", arithmeticexception);
                scanner.nextLine();
                System.out.println("Divisão por zero impossível! Tente novamente!\n");
            }
        }while(Continua);
    }
    
}
