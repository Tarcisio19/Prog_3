public class ContaBancaria {
    private int numero;

    ContaBancaria(int num) {
        this.numero = num;
    }

    public String toString() {
        return String.valueOf(numero);
        
    }

    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        ContaBancaria that = (ContaBancaria) obj;

        return numero == that.numero;

}

    public static void main(String[] args){

        ContaBancaria conta1 = new ContaBancaria(11111);
        ContaBancaria conta2 = new ContaBancaria(11111);

        System.out.println(conta1.equals(conta2));
        System.out.println(conta1.toString());
    }
}
