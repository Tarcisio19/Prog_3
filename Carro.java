public class Carro {
    
    String Marca;
    String Modelo;
    int Ano;

    void ExibirInfo() {
        System.out.println("Marca: " + Marca);
        System.out.println("Modelo: " + Modelo);
        System.out.println("Ano: " + Ano);
    }

    public static void main(String[] args) {
        Carro C1 = new Carro();
        Carro C2 = new Carro();

        C1.Marca = "Toyota";
        C1.Modelo = "Corolla";
        C1.Ano = 2020;

        C2.Marca = "Honda";
        C2.Modelo = "Civic";
        C2.Ano = 2021;

        System.out.println("Carro 1:");
        C1.ExibirInfo();
        System.out.println("\nCarro 2:");
        C2.ExibirInfo();

    }
}
