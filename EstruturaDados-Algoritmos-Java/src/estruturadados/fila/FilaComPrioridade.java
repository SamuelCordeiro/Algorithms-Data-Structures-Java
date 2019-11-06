package estruturadados.fila;

public class FilaComPrioridade<T> extends Fila<T> {
	
	/*public FilaComPrioridade() {
		super();
	}
	
	public FilaComPrioridade(int capacidade) {
		super(capacidade);
	}*/
	
	public void enfileirar(T elemento) {
		
		Comparable<T> chave = ((Comparable<T>) elemento);
		int i;
		for(i = 0; i < this.tamanho; i++) {
			if(chave.compareTo(this.elementos[i]) < 0) {
				break;
			}
		}
		this.adiciona(elemento, i);
	}
}
