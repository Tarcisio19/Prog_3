public class Contador {
    
    static int Contador = 0;

    Contador(){
        Contador++;
    }

    public static void mostraTotal(){
        System.out.println("Total de objetos criados: " + Contador + "\n");
    }

    public static void main(String[] args){

        Contador C1 = new Contador();
        Contador C2 = new Contador();
        Contador C3 = new Contador();
        Contador C4 = new Contador();

        C4.mostraTotal();
    }
}
