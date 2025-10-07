public class Ex3 {
    
    public interface Corredor{
        public abstract void correr();
    }

    public interface Nadador{
        public abstract void nadar();
    }

    public interface Ciclista{
        public abstract void pedalar();
    }

    public static class Triatleta implements Corredor, Nadador, Ciclista{

        public void correr(){
            System.out.println("Correndo");
        }

        public void nadar(){
            System.out.println("Nadando");
        }

        public void pedalar(){
            System.out.println("Pedalando");
        }
        
        public static void main(String[] args) {

            Triatleta t1 = new Triatleta();
            
            t1.correr();
            t1.nadar();
            t1.pedalar();
        }
    }

}
