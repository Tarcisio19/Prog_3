public class Ex_2 {
    public static void main(String[] args) {
        int primeiro = 1, segundo = 1;
        
        System.out.print(primeiro + " " + segundo + " ");
        
        for (int i = 2; i < 30; i++) {
            int proximo = primeiro + segundo;
            System.out.print(proximo + " ");
            primeiro = segundo;
            segundo = proximo;
        }
        
        System.out.println();
    }
}