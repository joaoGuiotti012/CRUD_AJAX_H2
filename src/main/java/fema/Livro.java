package fema;

import java.util.List;

public class Livro {

	private Integer cod;

	private String nome;

	private String resumo;

	private String autor;

	private Editora editora;

	private int qtdPaginas;

	private int qtd;
	

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(Integer cod, String nome, String resumo, String autor, Editora editora, int qtdPaginas, int qtd) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.resumo = resumo;
		this.autor = autor;
		this.editora = editora;
		this.qtdPaginas = qtdPaginas;
		this.qtd = qtd;
	}

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", resumo=" + resumo + ", autor=" + autor + ", editora=" + editora
				+ ", qtdPaginas=" + qtdPaginas + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}


	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	

}
