package fema;

public class Categoria {

	private Integer cod;

	private String nome;

	private String descricao;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Categoria(Integer cod, String nome, String descricao) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
