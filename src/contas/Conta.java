package contas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Conta {

	protected String nome;
	protected String cpf;
	protected Double rendaMensal;
	private Integer numConta = 0;
	private Agencia agencia;
	protected Double saldo = 0.0;
	private List<Transacao> transacoes = new ArrayList<>();

	public Conta() {
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public Integer getNumConta() {
		return numConta;
	}

	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Double getSaldo() {
		return saldo;
	}

	// Método para Printar os dados da conta
	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", cpf=" + cpf + ", rendaMensal=" + rendaMensal + ", agencia=" + agencia
				+ ", saldo=" + saldo + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getRendaMensal()="
				+ getRendaMensal() + ", getConta()=" + getNumConta() + ", getAgencia()=" + getAgencia()
				+ ", getSaldo()=" + getSaldo() + ", toString()=" + super.toString() + "]";
	}

	// Métodos
	public void metDeposito(double valor) {
		System.out.println("\n--------------------------------");
		System.out.println("             EXTRATO            ");
		System.out.println("--------------------------------");
		System.out.printf("Valor depositado +R$ %.2f", valor);

		Transacao transacao = new Transacao();
		transacao.setValor(valor);
		transacao.setDataTransacao(new Date());
		transacao.setTipoTransacao(TipoTransacao.DEPOSITO);

		transacoes.add(transacao);

		this.saldo += valor;

		System.out.printf("\nSaldo atual R$ %.2f%n", saldo);
		System.out.println("--------------------------------");
		System.out.println();
	}

	public void metSaque(double valor) {
		if (saldo > 0) {
			this.saldo -= valor;

			Transacao transacao = new Transacao();
			transacao.setValor(valor);
			transacao.setDataTransacao(new Date());
			transacao.setTipoTransacao(TipoTransacao.SAQUE);

			transacoes.add(transacao);

			System.out.println("\n--------------------------------");
			System.out.println("             EXTRATO            ");
			System.out.println("--------------------------------");
			System.out.printf("Valor sacado -R$ %.2f", valor);

			System.out.printf("\nSaldo atual R$ %.2f%n", this.saldo);
			System.out.println("--------------------------------");
			System.out.println();
		} else {
			System.out.println("Saldo insuficiente");
			return;
		}

	}

	public void metSaldo() {
		System.out.println("Saldo disponível: R$ " + this.saldo);
		System.out.println();
	}

	public void metExtrato() {
		System.out.println("EXTRATO");
		System.out.println("--------------------- ");
		System.out.println("Nome: " + this.nome);
		System.out.println("Agência: " + agencia);
		System.out.println("Conta: " + this.numConta);
		System.out.printf("Saldo atual: %.2f\n", saldo);

		for (int i = 0; i < transacoes.size(); i++) {
			Transacao transacao = transacoes.get(i);
			System.out.println(transacao);
		}

//		for (Transacao t : transacoes) {
//			System.out.println(t);
//		}
//
//		transacoes.forEach(transacao -> {
//			System.out.println(transacao);
//		});
//
//		transacoes.forEach(transacao -> System.out.println(transacao));
//
//		transacoes.forEach(System.out::println);
//
//		List<Transacao> transacoesSaque = transacoes.stream()
//				.filter(transacao -> transacao.getTipoTransacao().equals(TipoTransacao.SAQUE))
//				.collect(Collectors.toList());
	}

	public void metTransfrencia(double valor) {

		Transferencia transferir = new Transferencia();

		transferir.setNomeContaOrigem(nome);
		transferir.setCpfContaOrigem(cpf);
		transferir.setNomeContaDestino(nome);
		transferir.setCpfContaDestino(cpf);

		transferir.setValor(valor);
		transferir.setDataTransacao(new Date());
		transferir.setTipoTransacao(TipoTransacao.TRANSFERENCIA);

		transacoes.add(transferir);

		System.out.println("\n--------------------------------");
		System.out.println("             EXTRATO            ");
		System.out.println("--------------------------------");
		System.out.printf("Valor a transferir -R$ %.2f", valor);

		System.out.printf("\nSaldo atual R$ %.2f%n", this.saldo);
		System.out.println("--------------------------------");
		System.out.println();
	}

	public void metAlteraCadastro() {
		Scanner tecladoCadastro = new Scanner(System.in);
		System.out.println("----- Alteração de Cadastro -----");
		System.out.print("Nome atual: " + this.getNome());
		System.out.print("\nInforme o nome correto:");

		this.setNome(tecladoCadastro.next());
		this.setRendaMensal(tecladoCadastro.nextDouble());

	}

		public void metRelatorio(List<Conta> contasCadastradas) {

			for (int i = 0; i < contasCadastradas.size(); i++) {
				Conta relatorio = contasCadastradas.get(i);
				System.out.println(relatorio);
			}
	}

	// Menu Primeira Operação
	public void menuPrimeiraOperacao(List<Conta> contasCadastradas) {
		Scanner tecladoMenu2 = new Scanner(System.in);

		int opcao2 = 0;
		while (opcao2 == 1) {

			System.out.println("\nEscolha a opção desejada:");
			System.out.println("1 - Depositar");
			System.out.println("2 - Menu Principal");
			System.out.println("3 - Sair");

			System.out.print("Opção: ");
			opcao2 = tecladoMenu2.nextInt();

			if (opcao2 == 1) {
				System.out.println("\nInforme o valor a ser depositado: R$ ");
				Double primeiroDeposito = tecladoMenu2.nextDouble();
				this.metDeposito(primeiroDeposito);

				System.out.println("\nDeseja continuar? 1- Sim   2- Não");
				System.out.print("Opção: ");
				int opcaoInterna = tecladoMenu2.nextInt();

				if (opcaoInterna == 1) {
					menuPrimeiraOperacao(contasCadastradas);
				}
			} else if (opcao2 == 2) {
				System.out.println("\nVoltar ao Menu Principal. Você será redirecionado em intantes...");
				ContaCorrente menuCorrente = new ContaCorrente();
				menuCorrente.menuInterno(contasCadastradas);

			} else if (opcao2 == 3) {

				System.out.println("Sessão finalizada!");
				opcao2 = 4;
			} else {
				System.out.println("opção inválida!.");
			}
		}
	}
}