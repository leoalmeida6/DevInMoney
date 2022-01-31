package contas;

import java.util.List;
import java.util.Scanner;

public class ContaCorrente extends Conta {

	private Double chequeEspecial = 0.0;

	public ContaCorrente() {
		this.setAgencia(Agencia.FLORIANOPOLIS);
	}

	// Getter e Setter
	public Double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(Double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	@Override
	public String toString() {
		return "ContaCorrente{" + "nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", rendaMensal=" + rendaMensal
				+ ", saldo=" + saldo + ", chequeEspecial=" + chequeEspecial + '}';
	}

	// Métodos
	public void metChequeEspecial(List<Conta> contasCadastradas) {
		Scanner tecladoCheque = new Scanner(System.in);

		if (this.getSaldo() == 0) {
			System.out.println("Você deseja usar o cheque especial? \n1- Sim    2- Não");

			int escolhaCheque = tecladoCheque.nextInt();
			if (escolhaCheque == 1) {
				if (rendaMensal < 1000) {
					System.out.println("Renda Mensal: R$ " + this.getRendaMensal());
					this.chequeEspecial = 325.50;
					System.out.println("Cheque Especial disponível: R$ " + this.chequeEspecial);
				} else if (rendaMensal >= 2000 && rendaMensal <= 5000) {
					System.out.println("Renda Mensal: R$ " + rendaMensal);
					this.chequeEspecial = 750.00;
					System.out.println("Cheque Especial disponível: R$ " + this.chequeEspecial);
				} else {
					System.out.println("Renda Mensal: R$ " + rendaMensal);
					this.chequeEspecial = 1250.75;
					System.out.println("Cheque Especial disponível: R$ " + this.chequeEspecial);
				}
				setSaldo(this.chequeEspecial);
				System.out.println("Saldo: " + getSaldo());

				menuInterno(contasCadastradas);

			} else {
				System.out.println("Sessão finalizada.");
				menuInterno(contasCadastradas);
			}
		}
//		tecladoCheque.close();
	}
	
	public void metRelatorio(List<Conta> contasCadastradas) {

		for (int i = 0; i < contasCadastradas.size(); i++) {
			Conta relatorio = contasCadastradas.get(i);
			System.out.println(relatorio);
		}
}

	// Menu Principal
	public void menuInterno(List<Conta> contasCadastradas) {
		Scanner tecladoMenu1 = new Scanner(System.in);

		while (true) {
			// PulaLinha
			System.out.println();

			System.out.println("Escolha a opção desejada");
			System.out.println("1 - Sacar");
			System.out.println("2 - Depositar");
			System.out.println("3 - Saldo");
			System.out.println("4 - Extrato");
			System.out.println("5 - Transferência");
			System.out.println("6 - Cheque Especial");
			System.out.println("7 - Alterar Cadastro");
			System.out.println("8 - Relatórios");
			System.out.println("9 - Sair\n");

			int opcao1 = tecladoMenu1.nextInt();
			System.out.printf("Opção: ", opcao1);

			if (opcao1 == 1) {

				if (this.getSaldo() < 0) {
					System.out.println(
							"Você não tem dinheiro para sacar. Deseja utilizar o cheque especial? Escolha a opção 6 do menu.");
				}
				System.out.println("Informe o valor a ser sacado: R$ ");
				Double saque = tecladoMenu1.nextDouble();
				this.metSaque(saque);
			} else if (opcao1 == 2) {
				System.out.println("Informe o valor a ser depositado: R$ ");
				Double deposito = tecladoMenu1.nextDouble();
				this.metDeposito(deposito);
			} else if (opcao1 == 3) {
				this.metSaldo();
			} else if (opcao1 == 4) {
				this.metExtrato();
			} else if (opcao1 == 5) {
				this.metTransfrencia(0);
			} else if (opcao1 == 6) {
				this.metChequeEspecial(contasCadastradas);
			} else if (opcao1 == 7) {
				this.metAlteraCadastro();
			} else if (opcao1 == 8) {
				metRelatorio(contasCadastradas);
			} else {
				System.out.println("Sessão finalizada.");
				return;
			}
//			tecladoMenu1.close();
		}
	}
}
