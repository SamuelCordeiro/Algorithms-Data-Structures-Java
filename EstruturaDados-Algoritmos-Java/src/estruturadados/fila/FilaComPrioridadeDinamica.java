package estruturadados.fila;

import estruturadados.estruturadinamica.No;

public class FilaComPrioridadeDinamica<T> extends FilaDinamica<T> {

	public void enfileirar(T elemento) {
		Comparable<T> chave = ((Comparable<T>) elemento);
		int i;
		No aux = this.inicio;
		for(i = 0; i < this.tamanho; i++) {
			if(chave.compareTo((T) aux.getElemento()) < 0) {
				break;
			}
			aux = aux.getProximo();
		}
		this.adiciona(elemento, i);
	}
}
