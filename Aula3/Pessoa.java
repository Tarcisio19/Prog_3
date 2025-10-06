public class Pessoa {

    private String Nome;
    private int Idade;

    Pessoa(){
        Nome = " ";
        Idade = 0;
    }

    Pessoa(String nome, int idade){
        Nome = nome;
        Idade = idade;
    }

    void setNome(String nome){
        Nome = nome;
    }

    void setIdade(int idade){
        Idade = idade;
    }

    String getNome(){
        return Nome;
    }

    int getIdade(){
        return Idade;
    }
    public static class Aluno extends Pessoa{
        private int Matricula;

        Aluno(){
            super();
            Matricula = 0;
        }

        Aluno(String nome, int idade, int matricula){
            super(nome, idade);
            Matricula = matricula;
        }

        void setMatricula(int matricula){
            Matricula = matricula;
        }

        int getMatricula(){
            return Matricula;
        }

    }

    public static void main(String args[]){

        Aluno A1 = new Aluno();
        Aluno A2 = new Aluno("Ana", 20, 12345);

        System.out.println("Aluno 1:\nNome: " + A1.getNome() + "\nIdade: " + A1.getIdade() + "\nMatricula: " + A1.getMatricula());
        System.out.println("\n");
        System.out.println("Aluno 2:\nNome: " + A2.getNome() + "\nIdade: " + A2.getIdade() + "\nMatricula: " + A2.getMatricula());
        System.out.println("\n");
        A1.setNome("Tarcísio");
        A1.setIdade(20);
        A1.setMatricula(2023117400);
        System.out.println("Aluno 1:\nNome: " + A1.getNome() + "\nIdade: " + A1.getIdade() + "\nMatricula: " + A1.getMatricula());

    }
}
