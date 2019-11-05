package estruturadados.vetorgenerico;

import estruturadados.estruturaestatica.EstruturaEstatica;

public class VetorGenerico<T> extends EstruturaEstatica<T> {

	public VetorGenerico() {
		super();
	}

	public VetorGenerico(int capacidade) {
		super(capacidade);
	}

	public boolean adiciona(T elemento) {
		return super.adiciona(elemento);
	}

	public boolean adiciona(T elemento, int posicao) {
		return super.adiciona(elemento, posicao);
	}

	public void remove(int posicao) {
		super.removePorPosicao(posicao);
	}

	public Object buscaElemento(int posicao) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição invalida");
		}
		return this.elementos[posicao];
	}

	public int buscaElemento(T elemento) {
		for(int i = 0; i < this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}

	public boolean comtem(T elemento) {
		return buscaElemento(elemento) > -1;
	}

	public int ultimoIndice(T elemento) {
		for(int i = this.tamanho - 1; i >= 0; i--) {
			if(this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}

	public void limpar() {
		this.elementos = (T[]) new Object[this.elementos.length];
	}
}
