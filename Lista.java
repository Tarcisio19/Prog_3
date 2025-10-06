import java.util.ArrayList;
import java.util.Iterator;

public class Lista {
    
    public static class Aluno{
        private String Nome;

        Aluno(String nome){
            Nome = nome;
        }
    }
    public static void main(String[] args){

        ArrayList ListaNomes = new ArrayList<>();
        Aluno A1 = new Aluno("Tarcísio");
        Aluno A2 = new Aluno("Danilo");
        Aluno A3 = new Aluno("Rafael");
        Aluno A4 = new Aluno("Tales");
        Aluno A5 = new Aluno("Tainá");

        ListaNomes.add(A1);
        ListaNomes.add(A2);
        ListaNomes.add(A3);
        ListaNomes.add(A4);
        ListaNomes.add(A5);

        Iterator i = ListaNomes.iterator();

        while(i.hasNext()){
            A1 = (Aluno)i.next();
            System.out.println("Nome: " + A1.Nome + "\n");
        }

    }
}
