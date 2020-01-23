package estruturadados.fila;

import estruturadados.estruturadinamica.EstruturaDinamica;

public class FilaDinamica<T> extends EstruturaDinamica<T> {

	protected final int POS = 0;
	public FilaDinamica() {
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
