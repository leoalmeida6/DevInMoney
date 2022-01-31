package contas;

import java.util.Scanner;

public class ContaInvestimento extends Conta {

	protected Double valorInvestimento;

	public ContaInvestimento() {
		this.setAgencia(Agencia.SAO_JOSE);

	}

	// Getter e Setter
	public Double getValorInvestimento() {
		return valorInvestimento;
	}

	public void setValorInvestimento(Double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}

	@Override
	public String toString() {
		return "ContaInvestimento{" + "nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", rendaMensal=" + rendaMensal
				+ ", saldo=" + saldo + ", valorInvestimento=" + valorInvestimento + '}';
	}

	// Método
	public void simulaPoupanca() {
		Scanner teclado = new Scanner(System.in);

		int mes = 12;
		double valorRendimento = 0;
		double taxaPoupanca = 0.55 / 100;

		System.out.println("");
		System.out.println("Simule o rendimento do seu dinheiro aqui!");

		// PulaLinha
		System.out.println("------------------------------------------");

		System.out.print("Informe um valor R$ ");
		valorRendimento = teclado.nextDouble();

		System.out.print("Informe o tempo da aplicação em meses: ");
		mes = teclado.nextInt();

		double anterior = 0.0;
		for (int i = 1; i <= mes; i++) {

			double valorTotal = valorRendimento * Math.pow((1 + taxaPoupanca), i);
			double juros = valorTotal - valorRendimento - anterior;

			anterior += juros;

			System.out.println("");
			System.out.printf("%dº mês rendeu R$ %.2f = Valor total = R$ %.2f", i, juros, valorTotal, "\n");

		}
	}
	
	//SELIC
	public void simulaSelic() {
		Scanner teclado = new Scanner(System.in);

		int mes = 12;
		double valorRendimento = 0;
		double taxaSelic = 0.77 / 100;

		System.out.println("");
		System.out.println("Simule o rendimento do seu dinheiro aqui!");

		// PulaLinha
		System.out.println("------------------------------------------");

		System.out.print("Informe um valor R$ ");
		valorRendimento = teclado.nextDouble();

		System.out.print("Informe o tempo da aplicação em meses: ");
		mes = teclado.nextInt();

		double anterior = 0.0;
		for (int i = 1; i <= mes; i++) {

			double valorTotal = valorRendimento * Math.pow((1 + taxaSelic), i);
			double juros = valorTotal - valorRendimento - anterior;

			anterior += juros;

			System.out.println("");
			System.out.printf("%dº mês rendeu R$ %.2f = Valor total = R$ %.2f", i, juros, valorTotal, "\n");

		}
	}
	
	// TESOURO DIRETO
	public void simulaConsorcio() {
		Scanner teclado = new Scanner(System.in);

		int mes = 12;
		double valorRendimento = 0;
		double taxaConsorcio = 0.97 / 100;

		System.out.println("");
		System.out.println("Simule o rendimento do seu dinheiro aqui!");

		// PulaLinha
		System.out.println("------------------------------------------");

		System.out.print("Informe um valor R$ ");
		valorRendimento = teclado.nextDouble();

		System.out.print("Informe o tempo da aplicação em meses: ");
		mes = teclado.nextInt();

		double anterior = 0.0;
		for (int i = 1; i <= mes; i++) {

			double valorTotal = valorRendimento * Math.pow((1 + taxaConsorcio), i);
			double juros = valorTotal - valorRendimento - anterior;

			anterior += juros;

			System.out.println("");
			System.out.printf("%dº mês rendeu R$ %.2f = Valor total = R$ %.2f", i, juros, valorTotal, "\n");

		}
	}
	
	// Menu Principal
	public void menuInterno() {

		while (true) {
			Scanner tecladoMenu3 = new Scanner(System.in);

			// PulaLinha
			System.out.println();

			System.out.println("Escolha a opção desejada");
			System.out.println("1 - Simular Poupança");
			System.out.println("2 - Simuar Selic");
			System.out.println("3 - Simular Consórcio");
			System.out.println("4 - Alterar Cadastro");
			System.out.println("5 - Relatório");
			System.out.println("6 - Sair\n");

			int opcao1 = tecladoMenu3.nextInt();

			if (opcao1 == 1) {
				this.simulaPoupanca();
			} else if (opcao1 == 2) {
				this.simulaSelic();
			} else if (opcao1 == 3) {
				this.simulaConsorcio();
			} else if (opcao1 == 4) {
				this.metAlteraCadastro();
			} else if (opcao1 == 5) {
				this.metRelatorio();
			} else {
			System.out.println("Sessão finalizada.");
				return;
			}
		}
//		teclado.close();
	}
}