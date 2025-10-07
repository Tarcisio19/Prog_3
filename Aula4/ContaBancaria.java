abstract class ContaBancaria {
    protected double saldo;
    protected String titular;
    
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    //Métodos abstratos
    public abstract boolean sacar(double valor);
    public abstract void depositar(double valor);
    
    //Getters
    public double getSaldo() {
        return saldo;
    }
    
    public String getTitular() {
        return titular;
    }
}

class ContaCorrente extends ContaBancaria {
    private final double TAXA_SAQUE = 1.00;
    
    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }
    
    @Override
    public boolean sacar(double valor) {
        double valorTotal = valor + TAXA_SAQUE;
        if (saldo >= valorTotal) {
            saldo -= valorTotal;
            System.out.printf("Saque realizado: R$ %.2f (Taxa: R$ %.2f) - Saldo atual: R$ %.2f%n", 
                            valor, TAXA_SAQUE, saldo);
            return true;
        } else {
            System.out.printf("Saque negado! Saldo insuficiente. Saldo atual: R$ %.2f%n", saldo);
            return false;
        }
    }
    
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito realizado: R$ %.2f - Saldo atual: R$ %.2f%n", valor, saldo);
        } else {
            System.out.println("Valor de depósito deve ser positivo!");
        }
    }
}

class ContaPoupanca extends ContaBancaria {
    
    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }
    
    @Override
    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.printf("Saque realizado: R$ %.2f - Saldo atual: R$ %.2f%n", valor, saldo);
            return true;
        } else {
            System.out.printf("Saque negado! Saldo insuficiente. Saldo atual: R$ %.2f%n", saldo);
            return false;
        }
    }
    
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito realizado: R$ %.2f - Saldo atual: R$ %.2f%n", valor, saldo);
        } else {
            System.out.println("Valor de depósito deve ser positivo!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== TESTE DO SISTEMA BANCÁRIO ===\n");
        
        // Criando contas
        ContaCorrente cc = new ContaCorrente("Tarcísio", 1000.00);
        ContaPoupanca cp = new ContaPoupanca("Fernanda", 500.00);
        
        System.out.println("--- CONTA CORRENTE ---");
        System.out.printf("Titular: %s - Saldo inicial: R$ %.2f%n", cc.getTitular(), cc.getSaldo());
        
        // Testando operações na conta corrente
        cc.depositar(200.00);
        cc.sacar(150.00);  // Saque com taxa de R$ 1,00
        cc.sacar(2000.00); // Tentativa de saque sem saldo suficiente
        
        System.out.println("\n--- CONTA POUPANÇA ---");
        System.out.printf("Titular: %s - Saldo inicial: R$ %.2f%n", cp.getTitular(), cp.getSaldo());
        
        // Testando operações na conta poupança
        cp.depositar(100.00);
        cp.sacar(50.00);   // Saque sem taxa
        cp.sacar(800.00);  // Tentativa de saque sem saldo suficiente
        
        System.out.println("\n--- SALDOS FINAIS ---");
        System.out.printf("Conta Corrente (%s): R$ %.2f%n", cc.getTitular(), cc.getSaldo());
        System.out.printf("Conta Poupança (%s): R$ %.2f%n", cp.getTitular(), cp.getSaldo());
    }
}
