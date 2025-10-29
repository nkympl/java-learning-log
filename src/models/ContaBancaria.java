package models;

// A Classe que define o molde para todas as outras contas
public class ContaBancaria {
    // ATRIBUTOS (Variáveis de Instância)
    private int numeroConta;
    private String titular;
    private double saldo; // Deve ser privado para proteger o valor!

    // CONSTRUTOR: Para garantir que toda conta nasça com número e titular
    public ContaBancaria(int numeroConta, String titular) {
        // O 'this' resolve a ambiguidade (atributo = parâmetro)
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0; // Inicializamos o saldo com zero
    }

    // MÉTODOS DE AÇÃO (Lógica do Negócio)

    /** Realiza um depósito na conta. */

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor; // saldo = saldo + valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("ERRO: O valor do depósito deve ser positivo");
        }
    }

    /** Realiza um saque na conta, com validação de saldo. */
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor; // saldo = saldo - valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            return true;
        } else if (valor <= 0) {
            System.out.println("ERRO: O valor do saque deve ser positivo.");
            return false;
        } else {
            System.out.println("ERRO: Saldo insuficiente. Saldo atual: R$" + this.saldo);
            return false;
        }
    }

    // GETTERS (Para leitura dos dados)

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public String getTitular() {
        return this.titular;
    }
}
