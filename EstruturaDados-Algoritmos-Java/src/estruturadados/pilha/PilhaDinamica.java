package estruturadados.pilha;

import estruturadados.estruturadinamica.EstruturaEncadeada;

public class PilhaDinamica<T> extends EstruturaEncadeada<T> {

	public PilhaDinamica() {
		super();
	}
	
	public void empilhar(T elemento) {
		super.adiciona(elemento);
	}
	
	public void desempilhar() {
		super.remove(this.tamanho -1);
	}
	
	public Object topoFila() {
		return super.buscarElemento(this.tamanho-1);
	}
}
