package app;

import java.util.Scanner;

import models.ContaBancaria;

public class Terminal {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Cria a Conta Bancária (Instanciação do Objeto)
        // Vou pedir os dados necessários para o construtor:
        System.out.println("--- BEM-VINDO AO BANCO DIGITAL ---");
        System.out.println("Digite o seu nome completo: ");
        String nomeTitular = scanner.nextLine();

        System.out.println("Digite o número da conta (Ex: 1234): ");
        int numeroConta = scanner.nextInt();

        ContaBancaria conta = new ContaBancaria(numeroConta, nomeTitular);

        System.out.println("\nConta criada com sucesso para " + conta.getTitular());

        // 2. Loop principal do Terminal (Menu de interação)
        int opcao = -1;
        while (opcao != 0) { // O loop continuará até o usuário digitar 0

            System.out.println("\n-------------------------------");
            System.out.println("Conta: " + conta.getNumeroConta() + " | Saldo: R$ " + conta.getSaldo());
            System.out.println("\n-------------------------------");
            System.out.println("Escolha uma opção: ");
            System.out.println("1- Depósito");
            System.out.println("2 - Saque");
            System.out.println("3 - Consultar Saldo e Dados");
            System.out.println("0 - Sair");
            System.out.println("Opção: ");

            if (scanner.hasNextInt()) { //Evita erro se o usuário digitar texto
                opcao = scanner.nextInt();
            } else {
                scanner.next(); // Consome a entrada inválida
                opcao = -1;
                continue; //Pula para a próxima iteração
            }

            // 3. Estrutura de Decisão (usando if/else ou switch)
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor para depósito: R$ ");
                    double valDeposito = scanner.nextDouble();
                    conta.depositar(valDeposito); // Chama o método do objeto
                    break;
                case 2:
                    System.out.println("Digite o valor para saque: R$");
                    double valSaque = scanner.nextDouble();
                    conta.sacar(valSaque); // Chama o método do objeto
                    break;
                case 3:
                    System.out.println("\n--- DADOS DA CONTA ---");
                    System.out.println("Titular: " + conta.getTitular());
                    System.out.println("Número: " + conta.getNumeroConta());
                    System.out.println("Saldo: R$" + conta.getSaldo());
                    break;
                case 0:
                    System.out.println("\nObrigada por usar o Banco Digital! Volte sempre.");

            }
        }
        scanner.close(); // Fecha o Scanner
    }
}