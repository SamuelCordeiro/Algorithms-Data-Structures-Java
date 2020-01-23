package estruturadados.fila;

import estruturadados.estruturadinamica.EstruturaEncadeada;

public class FilaEncadeada<T> extends EstruturaEncadeada<T> {

	protected final int POS = 0;
	public FilaEncadeada() {
		super();
	}
	
	public void enfileirar(T elemento) {
		this.adiciona(elemento);
	}
	
	public void desenfileirar () {
		
		super.remove(POS);
	}
	
	public Object espiarInicioFila() {
		return super.buscarElemento(POS);
	}
	
}
