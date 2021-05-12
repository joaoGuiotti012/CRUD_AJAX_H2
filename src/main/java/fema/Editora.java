package fema;

public class Editora {

	private Integer cod;

	private String nome;
	
	private Categoria categoria;

	private String localidade;

	public Editora() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Editora(Integer cod, String nome, Categoria categoria, String localidade) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.categoria = categoria;
		this.localidade = localidade;
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

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	@Override
	public String toString() {
		return "Editora [cod=" + cod + ", nome=" + nome + ", localidade=" + localidade + "]";
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
