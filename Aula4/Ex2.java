public class Ex2 {
    
    public enum NivelAcesso{BASICO, INTERMEDIARIO, ADMIN};

    public static class Usuario{

        private String Nome;
        private NivelAcesso NivelDeAcesso;

        Usuario(String nome, NivelAcesso nvac){
            this.Nome = nome;
            this.NivelDeAcesso = nvac;
        }

        public void ImprimeU(){
            if(this.NivelDeAcesso == NivelAcesso.BASICO){
                System.out.println(this.Nome + ": Gosto de laranja\n");
            } else if (this.NivelDeAcesso == NivelAcesso.INTERMEDIARIO){
                System.out.println(this.Nome + ": Gosto de morango\n");
            } else {
                System.out.println(this.Nome + ": Freud foi um vigarista\n");
            }
        }

        public static void main(String[] args) {
            
            Usuario U1 = new Usuario("Fernanda", NivelAcesso.BASICO);
            Usuario U2 = new Usuario("Danilo", NivelAcesso.INTERMEDIARIO);
            Usuario U3 = new Usuario("Tarcísio", NivelAcesso.ADMIN);


            U1.ImprimeU();
            U2.ImprimeU();
            U3.ImprimeU();

        }
    }
}
