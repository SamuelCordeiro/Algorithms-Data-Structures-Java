package estruturadados.fila;

public class FilaComPrioridadeEstatica<T> extends FilaEstatica<T> {
	
	public void enfileirar(Object elemento) {
		Comparable<Object> chave =  (Comparable<Object>) elemento;
		int i;
		for(i = 0; i < this.tamanho; i++) {
			if(chave.compareTo(this.elementos[i]) < 0) {
				break;
			}
		}
		this.adiciona((T) elemento, i);
	}
}
