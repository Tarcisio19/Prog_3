public class Calculadora {
    
    public int Somar(int v1, int v2){
        return v1 + v2;
    }

    public double Somar(double v1, double v2){
        return v1 + v2;
    }

    public int Somar (int v1, int v2, int v3){
        return v1 + v2 + v3;
    }

    public static void main(String[] args){

        Calculadora C1 = new Calculadora();
        System.out.println("Dois inteiros: " + C1.Somar(5, 5) + "\n");
        System.out.println("Dois doubles: " + C1.Somar(5.5, 5.5) + "\n");
        System.out.println("Tres inteiros: " + C1.Somar(5, 5, 5) + "\n");
    }
}
