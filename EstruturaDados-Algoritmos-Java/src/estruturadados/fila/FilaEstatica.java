package estruturadados.fila;

import estruturadados.estruturaestatica.EstruturaEstatica;

public class FilaEstatica<T> extends EstruturaEstatica<T> {

	public FilaEstatica() {
		super();
	}
	
	public FilaEstatica(int capacidade) {
		super(capacidade);
	}
	
	public void enfileirar(T elemento) {
		this.adiciona(elemento);
	}
	
	public T desenfileirar () {
		final int POS = 0;
		T elementoRemovido;
		if(this.estaVazia()) {
			return null;
		}
		elementoRemovido = this.elementos[POS];
		this.removePorPosicao(POS);
		return elementoRemovido;
	}
	
	public T espiarInicioFila() {
		if(this.estaVazia()) {
			return null;
		}
		return this.elementos[0];
	}
}
