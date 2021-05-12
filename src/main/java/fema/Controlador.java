package fema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
  
@Named
@SessionScoped  
public class Controlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Conteudo conteudo = new Conteudo();

	private Livro livro = new Livro();

	private Categoria categoria = new Categoria();
	
	private Editora editora = new Editora();

	private List<Livro> livros = new ArrayList<Livro>();

	private List<Categoria> categorias = new ArrayList<Categoria>();

	private List<Editora> editoras = new ArrayList<Editora>();
	
	private List<String> locals = new ArrayList<String>();

	private Integer categoriaSelecionado;

	private Integer editoraSelecionada;

	public Controlador() {
		// TODO Auto-generated constructor stub
		this.populaCategorias();
		this.populaEditora();
		this.populaLocals();
		this.populaLivros();
		 
		this.livro.setCod(this.livros.size() + 1);
		this.categoria.setCod(this.categorias.size() + 1);
		this.editora.setCod(this.editoras.size() + 1);
	}

	public boolean isMostrarTable() {
		return this.livros.size() > 0 ? true : false;
	}
	
	public boolean isMostrarTableCategorias() {
		return this.categorias.size() > 0 ? true : false;
	}
	
	public boolean isMostrarTableEditoras() {
		return this.editoras.size() > 0 ? true : false;
	}

	public void mostrarCoteudoCampo(AjaxBehaviorEvent event) {
		System.out.println(this.livro.getNome());
	}

	public String addLivro() {
 
		Editora selEditora = null;
		for (Editora editora : editoras) {
			if (editora.getCod().equals(editoraSelecionada)) {
				selEditora = editora;
			}
		}

		this.livro.setEditora(selEditora);

//		System.out.println(categoriaSelecionado);
		System.out.println(editoraSelecionada);
//		System.out.println(selCat);
		System.out.println(selEditora);

		livros.add(this.livro);
		
		System.out.println(livro.toString());
		this.livro = new Livro();
		
		this.livro.setCod(this.categorias.size() + 1);
		return "mostrarlivro.xhtml";
	}

	public String addCategoria() {
		this.categorias.add(this.categoria);
		this.categoria = new Categoria();
		this.categoria.setCod(this.categorias.size() + 1);
		return "categoria.xhtml";
	}
	
	
	public String addEditora() {
		
		// Buscando Categoria selecionda
		Categoria selCat = null;
		for (Categoria cat : categorias) {
			if (cat.getCod().equals(categoriaSelecionado)) {
				selCat = cat;
			}
		}
		// setando categoria
		this.editora.setCategoria(selCat);
		
		this.editoras.add(this.editora);
		this.editora = new Editora();
		this.categoria.setCod(this.editoras.size() + 1);
		return "editora.xhtml";
	}

	public String remover(Livro livro) {
		System.out.println(livro);
		livros.remove(livro);
		return "#";
	}
	
	public String venderLivro(Livro livro) { 
		int depoisVenda = livro.getQtd() - 1;
		if( depoisVenda < 0 ) { 
			System.out.println("Erro ao vender, exemplar não disponivel");
			return "#";
		} 
		System.out.println("Antes da venda >> " + livro.getQtd());
		livro.setQtd(depoisVenda);
		System.out.println("vender >> " + livro.getQtd());
		return "#";  
	}
	
	public String removerCategoria(Categoria categoria) {
		System.out.println(categoria);
		categorias.remove(categoria);
		this.categoria.setCod(this.categorias.size() + 1);
		return "#";
	}

	public String removerEditora(Editora editora) {
		System.out.println(editora.toString());
		editoras.remove(editora);
		this.editora.setCod(this.editoras.size() + 1);
		return "editora.xhtml";
	}
	
	public String mostrarMensagem() {
		return "mostrarmensagem.xhtml";
	}

	public String voltar() {
		return "formLivro.xhtml";
	}

	public String mostrarLivro() {
		System.out.println("Livro >>>  " + this.livro.toString());
		return "mostrarlivro.xhtml";
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Integer getCategoriaSelecionado() {
		return categoriaSelecionado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Integer getEditoraSelecionada() {
		return editoraSelecionada;
	}

	public void setEditoraSelecionada(Integer editoraSelecionada) {
		this.editoraSelecionada = editoraSelecionada;
	}

	public void setCategoriaSelecionado(Integer categoriaSelecionado) {
		this.categoriaSelecionado = categoriaSelecionado;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Editora> getEditoras() {
		return editoras;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}

	public String isEstoqueTxt(Livro l) {
		if (l.getQtd() > 0) {
			return "Sim.";
		} else {
			return "Não.";
		}
	}

	private void populaCategorias() {
		this.categorias.add(new Categoria(1, "Romance", "Livro que relata historias longas e emocionantes de amor."));
		this.categorias.add(new Categoria(2, "Terror", "Historias de arrpiar, etigantes e muitas vezes eloqueceidora"));
		this.categorias.add(new Categoria(3, "Aventura", "Momentos de adrenalina e perigos..."));
	}

	private void populaEditora() {
		this.editoras.add(new Editora(1, "Terror4ever", this.categorias.get(1), "USA"));
		this.editoras.add(new Editora(2, "RomanticosAnonimos", this.categorias.get(0), "BR"));
		this.editoras.add(new Editora(3, "Adventure Pixs", this.categorias.get(2), "USA"));
	}
	
	private void populaLivros() {
		this.livros.add(new Livro(1, "Livro de aventuras", "Autor aventureiro", "Resumo de Aventura", this.editoras.get(2), 1344, 90 ));
	}
	
	public Integer uidCat() {
		this.categorias.size();
		return this.categorias.size() + 1;
	}
	
	private void populaLocals() {
		locals.add("USA");
		locals.add("BR");
		locals.add("AT");
		locals.add("AU");
		locals.add("RU");
		locals.add("AF");	
	}

	public List<String> getLocals() {
		return locals;
	}

	public void setLocals(List<String> locals) {
		this.locals = locals;
	}

}
