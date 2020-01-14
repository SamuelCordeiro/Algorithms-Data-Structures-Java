package estruturadados.pilha;

import estruturadados.estruturaestatica.EstruturaEstatica;

public class PilhaEstatica<T> extends EstruturaEstatica<T> {

	public PilhaEstatica() {
		super();
	}
	
	public PilhaEstatica(int capacidade) {
		super(capacidade);
	}
	
	public boolean empilhar(T elemento) {
		return super.adiciona(elemento);
	}
	
	public T desempilhar() {
		if(this.estaVazia()) {
			return null;
		}
		return this.elementos[--tamanho];
	}
	public T topoFila() {
		if(this.estaVazia()) {
			return null;
		}
		return this.elementos[tamanho -1];
	}
}
