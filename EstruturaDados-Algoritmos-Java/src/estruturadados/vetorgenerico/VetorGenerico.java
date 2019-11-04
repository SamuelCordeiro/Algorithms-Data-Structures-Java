package estruturadados.vetorgenerico;

public class VetorGenerico<T> {
	private T[] elementos;
	private int tamanho;

	public VetorGenerico(int capacidade) {
		this.elementos = (T[])new Object[capacidade];
		this.tamanho = 0;
	}
	
	public int getTamanho() {
		return this.tamanho;
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
	public void adiciona(T elemento) {
		this.aumentaCapacidade();
		this.elementos[this.tamanho] = elemento;
		this.tamanho++;
	}
	
	public void adiciona(T elemento, int posicao) {
		this.aumentaCapacidade();
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição invalida");
		}
		for(int i = this.tamanho - 1; i >= posicao; i--) {
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;
	}
	
	public void removeElemento(T elemento) {
		int pos = this.buscaElemento(elemento);
		if(pos > -1) {
			this.removePosicao(pos);
		}
	}
	
	public void removePosicao(int posicao) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição invalida");
		}
		for(int i = posicao; i < this.tamanho - 1; i++) {
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
	}
	
	@Override
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
	
	public Object buscaElemento(int posicao) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição invalida");
		}
		return this.elementos[posicao];
	}
	
	public int buscaElemento(T elemento) {
		for(int i = 0; i < this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean comtem(T elemento) {
		
		return buscaElemento(elemento) > -1;
	}
	
	public int ultimoIndice(T elemento) {
		for(int i = this.tamanho - 1; i >= 0; i--) {
			if(this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}
	
	public void limpar() {
		this.elementos = (T[]) new Object[this.elementos.length];
	}
	
}
