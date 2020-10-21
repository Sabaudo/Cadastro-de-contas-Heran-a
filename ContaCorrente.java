
import java.math.BigDecimal;

public class ContaCorrente extends ContaBancaria{

	BigDecimal limite = new BigDecimal(400);
	
	public ContaCorrente(String cliente, String numeroConta, BigDecimal saldo) {
		super(cliente, numeroConta, saldo);
	}
	
	
	@Override
	public BigDecimal sacar(BigDecimal valor) {
		this.saldo = saldo.subtract(valor);
		if(saldo.compareTo(aux) == -1) {
			if(valor.compareTo(limite) == 1) {
				System.out.println("Limite do cheque especial excedido.");
				System.exit(1);
			}
		}
		return this.saldo;
	}
}
