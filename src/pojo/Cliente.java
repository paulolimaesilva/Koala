package pojo;

public class Cliente {
	
	private int idCliente;
	private String nomeCliente;
	private String emailCliente;
	private String telefoneCliente;

	public Cliente(int id, String nome, String telefone, String email) {
		super();
		this.idCliente = id;
		this.nomeCliente = nome;
		this.telefoneCliente = telefone;
		this.emailCliente = email;
	}
	
	public Cliente(String nome, String telefone, String email) {
		super();
		this.nomeCliente = nome;
		this.telefoneCliente = telefone;
		this.emailCliente = email;

	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nome) {
		this.nomeCliente = nome;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String email) {
		this.emailCliente = email;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefone) {
		this.telefoneCliente = telefone;
	}

	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int id){
		this.idCliente = id;
	}
	
}
