package contas;

import java.util.List;
import java.util.Scanner;

public class ContaPoupanca extends Conta {

	private Integer mes = 0;
	private Double taxa = 0.55 / 100;
	private Double valor = 0.0;

	// Construtor
	public ContaPoupanca() {
		this.setAgencia(Agencia.FLORIANOPOLIS);
	}

	// Getter e Setter
	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	// Métodos
	public void simulaRendimentoPoupanca() {
		Scanner teclado = new Scanner(System.in);

		double valorRendimento = 0;

		System.out.println("");
		System.out.println("Simule o rendimento do seu dinheiro aqui!");

		// PulaLinha
		System.out.println("------------------------------------------");

		System.out.print("Informe um valor R$ ");
		valorRendimento = teclado.nextDouble();

		System.out.print("Informe o tempo da aplicação em meses: ");
		this.mes = teclado.nextInt();
		
		double anterior = 0.0;
		for (int i = 1; i <= mes; i++) {

			double valorTotal = valorRendimento * Math.pow((1 + taxa), i);			
			double juros = valorTotal - valorRendimento - anterior;
			
			anterior += juros;		
			
			System.out.println("");			
			System.out.printf("%dº mês rendeu R$ %.2f = Valor total = R$ %.2f", i, juros, valorTotal, "\n");

		}
	}

	@Override
	public String toString() {
		return "ContaPoupanca{" + "nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", rendaMensal=" + rendaMensal
				+ ", saldo=" + saldo + ", mes=" + mes + ", taxa=" + taxa + ", valor=" + valor + '}';
	}

	// Menu Principal
	public void menuInterno(List<Conta> contasCadastradas) {
		Scanner tecladoMenu2 = new Scanner(System.in);

		while (true) {
			// PulaLinha
			System.out.println();

			System.out.println("Escolha a opção desejada");
			System.out.println("1 - Sacar");
			System.out.println("2 - Depositar");
			System.out.println("3 - Saldo");
			System.out.println("4 - Extrato");
			System.out.println("5 - Simular Rendimento");
			System.out.println("6 - Alterar Cadastro");
			System.out.println("7 - Relatório");
			System.out.println("8 - Sair\n");
			
			System.out.print("Opção: ");
			int opcao1 = tecladoMenu2.nextInt();

			if (opcao1 == 1) {

				if (this.getSaldo() < 0) {
					System.out.println(
							"Você não tem dinheiro para sacar. Deseja utilizar o cheque especial? Escolha a opção 6 do menu.");
				}
				System.out.println("Informe o valor a ser sacado: R$ ");
				Double saque = tecladoMenu2.nextDouble();
				this.metSaque(saque);
			} else if (opcao1 == 2) {
				System.out.println("Informe o valor a ser depositado: R$ ");
				Double deposito = tecladoMenu2.nextDouble();
				this.metDeposito(deposito);
			} else if (opcao1 == 3) {
				this.metSaldo();
			} else if (opcao1 == 4) {
				this.metExtrato();
			} else if (opcao1 == 5) {
				this.simulaRendimentoPoupanca();
			} else if (opcao1 == 6) {
				this.metAlteraCadastro();
			} else if (opcao1 == 7) {
				this.metRelatorio(contasCadastradas);
			} else {
				System.out.println("Sessão finalizada.");
				return;
			}
//			tecladoMenu2.close();
		}
	}
}