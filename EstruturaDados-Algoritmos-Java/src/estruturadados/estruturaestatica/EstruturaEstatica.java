package estruturadados.estruturaestatica;

public class EstruturaEstatica<T> {

	protected T[] elementos;
	protected int tamanho;

	public EstruturaEstatica(int capacidade) {
		this.elementos = (T[])new Object[capacidade];
		this.tamanho = 0;
	}

	public EstruturaEstatica() {
		this(10);
	}


	private void aumentaCapacidade() {
		if(this.tamanho == this.elementos.length) {
			T[] elementosNovos = (T[]) new Object [this.elementos.length * 2];
			for(int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	protected boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}


	protected boolean adiciona(T elemento, int posicao) {
		
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição invalida");
		}
		this.aumentaCapacidade();
		for(int i = this.tamanho - 1; i >= posicao; i--) {
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;
		return true;
	}
	
	public void removeUtilmaPosicao() {
		this.elementos[this.tamanho-1] = this.elementos[tamanho];
	}
	
	public void removePorPosicao(int posicao) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição invalida");
		}
		for(int i = posicao; i < this.tamanho - 1; i++) {
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < this.tamanho -1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}
		if(this.tamanho > 0) {
			s.append(this.elementos[this.tamanho -1]);	
		}
		s.append("]");
		return s.toString();
	}

	public int getTamanho() {
		return this.tamanho;
	}
	
	public boolean estaVazia() {
		return this.tamanho == 0;
	}
}
