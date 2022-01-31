//package application;
//
//import java.util.Scanner;
//
//import contas.Agencia;
//import contas.Conta;
//
//public class MenuInterno extends Conta {
//	
//	public MenuInterno(String nome, Integer cpf, Integer conta, Agencia agencia) {
//		super(nome, cpf, agencia);
//		// TODO Auto-generated constructor stub
//	}
//
//	public void exibeMenu() {
//		Scanner teclado = new Scanner(System.in);
//        
//		//PulaLinha
//		System.out.println();
//		
//		System.out.println("Escolha a opção desejada");
//		System.out.println("1 - Sacar");
//        System.out.println("2 - Depositar");
//        System.out.println("3 - Saldo");
//        System.out.println("4 - Extrato");
//        System.out.println("5 - Transferência");
//        System.out.println("6 - Alterar Cadastro");
//        System.out.println("7 - Sair\n");
////        System.out.printf("Opção: ");
//        
//        int opcao = teclado.nextInt();
//        
//        if (opcao == 1) {
//        	System.out.print("Informe o valor a ser sacado: R$ ");
//        	Double saque = teclado.nextDouble();
//        	this.metSaque(saque);
//        } else if (opcao == 2) {
//        	System.out.print("Informe o valor a ser depositado: R$ ");
//        	Double deposito = teclado.nextDouble();
//        	this.metDeposito(deposito);
//        	
//        } else if (opcao == 3) {
//        	this.metSaldo();
//        }
//        
//        teclado.close();
//	}
//	
//	
//}
