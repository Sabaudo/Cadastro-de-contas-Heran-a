

import java.math.BigDecimal;

public class ContaBancaria {
	String cliente;
	String numeroConta;
	BigDecimal saldo;
	BigDecimal aux = new BigDecimal(0);
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	public ContaBancaria(String cliente, String numeroConta, BigDecimal saldo){
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	public ContaBancaria(){
		
	}
	
	
	public BigDecimal sacar(BigDecimal valor) {
		if(saldo.compareTo(aux) == -1) {
			System.out.println("Erro: o saldo não deve ficar negativo.");
			System.exit(1);
		}else {
			saldo = saldo.subtract(valor);
		}
		return saldo;
	}
	
	public void depositar(BigDecimal valor) {
		if(valor.compareTo(aux) == 1) {
			saldo = saldo.add(valor);
		}
	}
	
	
	
	
}
