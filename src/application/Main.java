package application;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaInvestimento;
import contas.ContaPoupanca;
import contas.Transacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Integer identificador = 0;

		List<Conta> contasCadastradas = new ArrayList<>();

		// Design
		Design logo = new Design();
		logo.Logo();

		// PulaLinha
		System.out.println();

		Scanner teclado = new Scanner(System.in);

		System.out.println("\nSeja muito bem vindo ao Banco DevInMoney! Escolha uma opção abaixo: ");
		System.out.println("1- Abrir uma conta");
		System.out.print("Opção: ");
		while (teclado.hasNext()) {
			int escolha1 = teclado.nextInt();

			// PulaLinha
			System.out.println();

			if (escolha1 == 1) {
				System.out.println("Legal! Vamos abrir uma conta:\n");

				System.out.println("Qual tipo de conta você deseja abrir?");
				System.out.println("01 - Conta Corrente");
				System.out.println("02 - Conta Poupança");
				System.out.println("03 - Conta Investimento");

				System.out.print("Opção: ");
				int tipoConta = teclado.nextInt();

				identificador = identificador + 1;

				if (tipoConta == 1) {
					ContaCorrente contaCorrente = new ContaCorrente();
					contaCorrente.setNumConta(identificador);

					System.out.printf("\nInforme seu nome: ");
					contaCorrente.setNome(teclado.next());

					System.out.printf("Informe seu CPF: ");
					contaCorrente.setCpf(teclado.next());

					System.out.print("Informe sua renda mensal: R$ ");
					contaCorrente.setRendaMensal(teclado.nextDouble());

					contasCadastradas.add(contaCorrente);

					System.out.println("\nConta criada com sucesso! Vamos fazer o seu primeiro depósito?\n" + "1- Sim"
							+ "\n2- Não");

					System.out.print("Opção: ");
					int primeiraOperacao = teclado.nextInt();

					contaCorrente.menuPrimeiraOperacao(contasCadastradas);

					contaCorrente.menuInterno(contasCadastradas);

				} else if (tipoConta == 2) {
					ContaPoupanca contaPoupanca = new ContaPoupanca();

					System.out.printf("\nInforme seu nome: ");
					contaPoupanca.setNome(teclado.next());
					System.out.printf("Informe seu CPF: ");
					contaPoupanca.setCpf(teclado.next());
					System.out.print("Informe sua renda mensal: R$ ");
					contaPoupanca.setRendaMensal(teclado.nextDouble());

					contasCadastradas.add(contaPoupanca);

					System.out.println("\nConta criada com sucesso! Vamos fazer o seu primeiro depósito?\n" + "1- Sim"
							+ "\n2- Não");

					System.out.print("Opção: ");
					int primeiraOperacao = teclado.nextInt();

					contaPoupanca.menuPrimeiraOperacao(contasCadastradas);

					contaPoupanca.menuInterno(contasCadastradas);

				} else if (tipoConta == 3) {
					ContaInvestimento contaInvestimento = new ContaInvestimento();

					System.out.printf("\nInforme seu nome: ");
					contaInvestimento.setNome(teclado.next());
					System.out.printf("Informe seu CPF: ");
					contaInvestimento.setCpf(teclado.next());
					contaInvestimento.getAgencia();
					System.out.print("Informe sua renda mensal: R$ ");
					contaInvestimento.setRendaMensal(teclado.nextDouble());

					contasCadastradas.add(contaInvestimento);

					contaInvestimento.menuInterno(contasCadastradas);

				} else if (escolha1 == 2) {
					System.out.println("Opção Invalida. Você não tem conta neste banco. Como quer entrar em uma? ");
				} else if (escolha1 == 3) {
					System.out.println("\nSessão finalizada.\n");

					while (true) {
						break;
					}
				}
			}
			System.out.println("\nSeja muito bem vindo ao Banco DevInMoney! Escolha uma opção abaixo: ");
			System.out.println("1- Abrir uma conta");
			System.out.print("Opção: ");
		}

	}
}