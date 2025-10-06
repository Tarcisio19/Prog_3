public class Livro {
    
    String Titulo;
    String Autor;

    Livro(){
        Titulo = " ";
        Autor = " ";
    }

    Livro(String titulo, String autor){
        Titulo = titulo;
        Autor = autor;
    }

    public static void main(String args[]){

        Livro L1 = new Livro();
        Livro L2 = new Livro("O senhor dos anais", "J.R.R Tolkien");

        System.out.println("Livro 1: " + L1.Titulo + " - " + L1.Autor);
        System.out.println("Livro 2: " + L2.Titulo + " - " + L2.Autor);
    }
}
