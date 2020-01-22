package estruturadados.pilha;

import estruturadados.estruturadinamica.EstruturaDinamica;

public class PilhaDinamica<T> extends EstruturaDinamica<T> {

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
