public class ControleDados {
	// ATRIBUTOS
	private int ag;
	private String conta;
	private String telefone;
	private String nome;
	private String email; 
	private double saldo;
	
	// CONSTRUTOR DO CADASTRO
	public ControleDados (int agencia, String conta, String nome, String email, String telefone, double saldo) {
		this.ag = agencia;
		this.conta = conta;
		this.nome = nome;
		this.email = email; 
		this.telefone = telefone;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Ag: " + getAg() + ", conta: " + getConta() + ", cliente: " + getNome() + ", e-mail: " + getEmail() + ", telefone: " + getTelefone() + ", saldo: " + String.format("R$%.2f", getSaldo());
	}
	
	public int getAg() {
		return ag;
	}

	public void setAg(int ag) {
		this.ag = ag;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
