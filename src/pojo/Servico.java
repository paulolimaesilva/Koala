package pojo;

public class Servico {

	private int idServico;
	private String nomeServico;

	public Servico(int idServico, String nomeServico) {
		super();
		this.idServico = idServico;
		this.nomeServico = nomeServico;
	}

	public Servico(String nomeServico) {
		super();
		this.nomeServico = nomeServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public int getIdServico() {
		return idServico;
	}

}
