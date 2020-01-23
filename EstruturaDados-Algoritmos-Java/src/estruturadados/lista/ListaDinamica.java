package estruturadados.lista;

import estruturadados.estruturadinamica.EstruturaDinamica;
import estruturadados.estruturadinamica.NoEncadeado;

public class ListaDinamica<T> extends EstruturaDinamica<T> {

	public ListaDinamica() {
		super();
	}
	
	public void adiciona(T elemento) {
		super.adiciona(elemento);
	}

	public void adiciona(T elemento, int posicao) {
		super.adiciona(elemento, posicao);
	}
	
	public void remove(int posicao) {
		super.remove(posicao);
	}
	
	public Object buscaElemento(int posicao) {
		return super.buscarElemento(posicao);
	}
	
	public int buscaElemento(T elemento) {
		return super.buscarElemento(elemento);
	}
	
	public void limpar() {
		this.inicio = this.ultimo = null;
		this.tamanho = 0;
	}
}
