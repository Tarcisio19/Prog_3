import java.io.*;

public class Ex_1 {
    public static void main(String[] args) {
        System.out.print("Digite o nome do arquivo: ");
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            String nomeArquivo = teclado.readLine();
            
            FileInputStream fis = new FileInputStream(nomeArquivo);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
            
            br.close();
            isr.close();
            fis.close();
            teclado.close();
            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}