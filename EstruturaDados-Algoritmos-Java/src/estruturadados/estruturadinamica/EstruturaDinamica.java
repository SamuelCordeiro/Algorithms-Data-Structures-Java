package estruturadados.estruturadinamica;

public class EstruturaDinamica<T> {

	protected No inicio;
	protected No ultimo;
	protected int tamanho;


	public EstruturaDinamica() {
		this.inicio = null;
		this.ultimo = null;
		this.tamanho = 0;
	}

	protected void adiciona(T elemento) {
		No novoNo = new No(elemento, null);
		if(estaVazia()) {
			this.inicio = this.ultimo = novoNo;
		}else {
			this.ultimo.setProximo(novoNo);
			this.ultimo = novoNo;
		}
		this.tamanho++;
	}
	
	protected void adiciona(T elemento, int posicao) {
		if(posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posição invalida");
		}
		No novoNo = new No(elemento, null);
		No aux = this.inicio;
		for(int i = 0; i < posicao-1; i++) {
			aux = aux.getProximo();
		}
		novoNo.setProximo(aux.getProximo());
		aux.setProximo(novoNo);
	}
	
	protected void remove(int posicao) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição invalida");
		}
		No aux = this.inicio;
		for(int i = 0; i< posicao-1; i++) {
			aux = aux.getProximo();
		}
		aux.setProximo(aux.getProximo(aux.getProximo()));
		
	}

	public String toString() {
		No aux = this.inicio;
		StringBuilder s = new StringBuilder();
		s.append("[");
		while(aux.getProximo() != null){
			s.append(aux.getElemento());
			s.append(", ");
			aux = aux.getProximo();
		}
		s.append(aux.getElemento());
		s.append("]");
		return s.toString();
	}

	public boolean estaVazia() {
		return this.inicio == null;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public Object getInicio() {
		return inicio.getElemento();
	}

	public Object getUltimo() {
		return ultimo.getElemento();
	}
}
