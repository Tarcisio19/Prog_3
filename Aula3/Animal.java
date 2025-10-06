public class Animal {
    
    public void emitirSom(){
        System.out.println("...\n");
    }

    public static class Cachorro extends Animal{

        @Override
        public void emitirSom(){
            System.out.println("Au Au\n");
        }
    }

    public static class Gato extends Animal{
        
        @Override
        public void emitirSom(){
            System.out.println("Miau Miau\n");
        }
    }

    public static void main(String[] args){

        Animal[] VetAnimal = new Animal[4];

        VetAnimal[0] = new Cachorro();
        VetAnimal[1] = new Gato();
        VetAnimal[2] = new Cachorro();
        VetAnimal[3] = new Gato();

        for (Animal animal : VetAnimal) {
            animal.emitirSom();
        }
    }
}
