


import java.math.BigDecimal;

public class ContaPoupanca extends ContaBancaria{
	
	BigDecimal diaRendimento = new BigDecimal(0.11);
	
	public ContaPoupanca(String cliente, String numeroConta, BigDecimal saldo) {
		super(cliente, numeroConta, saldo);
	}
	
	
	public void calcularNovoSaldo() {
		BigDecimal m = diaRendimento.multiply(saldo);
		saldo = saldo.add(m);
	}
}
