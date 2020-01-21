package estruturadados.lista;

import estruturadados.estruturadinamica.EstruturaDinamica;

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
}
