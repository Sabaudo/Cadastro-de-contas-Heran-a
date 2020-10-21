

import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
public class ContaMain {
	public static void main(String args[]) {
		
		Scanner input = new Scanner(System.in);
		ArrayList<ContaCorrente> tipo1 = new ArrayList<>();
		ArrayList<ContaPoupanca> tipo2 = new ArrayList<>();
		int op1, op2;
		String nome, numConta, numAux;
		BigDecimal valor, saldo;
		
		do{
			System.out.printf("%n%n%n");
			System.out.println("******** MENU CONTA BANCARIA ********");
			System.out.println("1 - Cadastrar a conta (corrente ou poupança) de um cliente");
			System.out.println("2 - Sacar um valor da sua conta (corrente ou poupança");
			System.out.println("3 - Atualizar uma conta poupança com o seu rendimento");
			System.out.println("4 - Depositar um valor em sua conta (corrente ou poupança)");
			System.out.println("5 - Mostrar o saldo de sua conta (corrente ou poupança)");
			System.out.println("0 - Sair do app");
			System.out.println("Escolha uma opção: ");
			op1 = input.nextInt();
			switch(op1) {
				case 1:
					System.out.println("Qual o tipo de conta será cadastrada?");
					System.out.println("1 - Conta corrente");
					System.out.println("2 - Conta poupança");
					System.out.println("Escolha uma opção: ");
					op2 = input.nextInt();
					if(op2 == 1) {
						System.out.println("Nome do cliente: ");
						nome = input.next();
						System.out.println("Numero da conta: ");
						numConta = input.next();
						System.out.println("Saldo inicial da conta: ");
						saldo = input.nextBigDecimal();
						ContaCorrente c = new ContaCorrente(nome, numConta, saldo);
						tipo1.add(c);
					}else if(op2 == 2){
						System.out.println("Nome do cliente: ");
						nome = input.next();
						System.out.println("Numero da conta: ");
						numConta = input.next();
						System.out.println("Saldo inicial da conta: ");
						saldo = input.nextBigDecimal();
						ContaPoupanca p = new ContaPoupanca(nome, numConta, saldo);
						tipo2.add(p);
					}
					else {
						System.out.println("Opção inválida");
					}
					break;
				case 2:
					System.out.println("Em qual conta sera efetuado o saque?");
					System.out.println("1 - Conta corrente");
					System.out.println("2 - Conta poupança");
					System.out.println("Escolha uma opção: ");
					op2 = input.nextInt();
					if(op2 == 1) {
						System.out.println("Qual o numero da conta?");
						numAux = input.next();
						for(int i = 0;i < tipo1.size(); i++) {
							if(tipo1.get(i).getNumeroConta().compareTo(numAux) == 0) {
								System.out.println("Saldo antes do saque: R$" + tipo1.get(i).getSaldo());
								System.out.println("Qntd a ser sacada: ");
								valor = input.nextBigDecimal();
								tipo1.get(i).sacar(valor);
								System.out.println("Saldo depois do saque: R$" + tipo1.get(i).getSaldo());
								System.out.println("O saque de R$"+ valor + " foi efetuado com sucesso");
							}
						}
					}
					else if(op2 == 2) {
						System.out.println("Qual o numero da conta?");
						numAux = input.next();
						for(int i = 0;i < tipo2.size(); i++) {
							if(tipo2.get(i).getNumeroConta().compareTo(numAux) == 0) {
								System.out.printf("Saldo antes do saque: R$%.2f%n", tipo2.get(i).getSaldo());
								System.out.println("Qntd a ser sacada: ");
								valor = input.nextBigDecimal();
								tipo2.get(i).sacar(valor);
								System.out.printf("Saldo depois do saque: R$%.2f%n", tipo2.get(i).getSaldo());
								System.out.printf("O saque de R$%.2f foi efetuado com sucesso", valor);
							}
						}
					}
					else {
						System.out.println("Opção inválida");
					}
					break;
				case 3:
					System.out.println("Qual o numero da conta poupança?");
					numAux = input.next();
					for(int i = 0; i < tipo2.size();i++) {
						if(tipo2.get(i).getNumeroConta().compareTo(numAux) == 0) {
							System.out.printf("Saldo anterior: R$%.2f%n", tipo2.get(i).getSaldo());
							tipo2.get(i).calcularNovoSaldo();
							System.out.printf("Saldo atualizado: R$%.2f%n", tipo2.get(i).getSaldo());
							System.out.println("Saldo da conta poupança atualizado com sucesso.");
							
						}
					}
					break;
				case 4:
					System.out.println("Em qual conta sera efetuado o depósito?");
					System.out.println("1 - Conta corrente");
					System.out.println("2 - Conta poupança");
					System.out.println("Escolha uma opção: ");
					op2 = input.nextInt();
					if(op2 == 1) {
						System.out.println("Qual o numero da conta?");
						numAux = input.next();
						for(int i = 0;i < tipo1.size(); i++) {
							if(tipo1.get(i).getNumeroConta().compareTo(numAux) == 0) {
								System.out.println("Saldo antes do deposito: R$" + tipo1.get(i).getSaldo());
								System.out.println("Valor a ser depositado: ");
								valor = input.nextBigDecimal();
								tipo1.get(i).depositar(valor);
								System.out.println("Saldo depois do deposito: R$" + tipo1.get(i).getSaldo());
							}
						}
					}else if(op2 == 2) {
						System.out.println("Qual o numero da conta?");
						numAux = input.next();
						for(int i = 0;i < tipo2.size(); i++) {
							if(tipo2.get(i).getNumeroConta().compareTo(numAux) == 0) {
								System.out.printf("Saldo antes do deposito: R$%.2f%n", tipo2.get(i).getSaldo());
								System.out.println("Valor a ser depositado: ");
								valor = input.nextBigDecimal();
								tipo2.get(i).depositar(valor);
								System.out.printf("Saldo depois do deposito: R$%.2f%n", tipo2.get(i).getSaldo());
							}
						}
					}else {
						System.out.println("Opção inválida");
					}
					break;
				case 5:
					System.out.println("Deseja ver o saldo de qual conta?");
					System.out.println("1 - Conta corrente");
					System.out.println("2 - Conta poupança");
					System.out.println("Escolha uma opção: ");
					op2 = input.nextInt();
					if(op2 == 1) {
						System.out.println("Qual o numero da conta?");
						numAux = input.next();
						for(int i = 0;i < tipo1.size(); i++) {
							if(tipo1.get(i).getNumeroConta().compareTo(numAux) == 0) {
								System.out.println("Nome do proprietario da conta:" + tipo1.get(i).getCliente());
								System.out.println("Saldo: R$" + tipo1.get(i).getSaldo());
							}
						}
					}
					else if(op2 == 2) {
						System.out.println("Qual o numero da conta?");
						numAux = input.next();
						for(int i = 0;i < tipo2.size(); i++) {
							if(tipo2.get(i).getNumeroConta().compareTo(numAux) == 0) {
								System.out.println("Nome do proprietario da conta:" + tipo2.get(i).getCliente());
								System.out.printf("Saldo: R$%.2f", tipo2.get(i).getSaldo());
							}
						}
					}else {
						System.out.println("Opção inválida");
					}
					break;
				case 0:
					System.out.println("Encerrando aplicação. . .");
					break;
				default: System.out.println("Opção inválida");
			}
		}while(op1 != 0);
		input.close();
	}
}
