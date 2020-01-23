package estruturadados.estruturadinamica;

public class EstruturaDinamica<T> {

	protected NoEncadeado inicio;
	protected NoEncadeado ultimo;
	protected int tamanho;

	public EstruturaDinamica() {
		this.inicio = null;
		this.ultimo = null;
		this.tamanho = 0;
	}

	protected void adiciona(T elemento) {
		NoEncadeado novoNo = new NoEncadeado(elemento, null);
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
		NoEncadeado novoNo = new NoEncadeado(elemento, null);
		if(posicao == 0) {
			novoNo.setProximo(inicio);
			inicio = novoNo;
		}else {
			NoEncadeado aux = buscarNo(posicao - 1);
			novoNo.setProximo(aux.getProximo());
			aux.setProximo(novoNo);
		}
		this.tamanho++;		
	}
	
	protected void remove(int posicao) {
		if(posicao < 0 || posicao > tamanho || estaVazia()) {
			throw new IllegalArgumentException("Posição invalida");
		}
		if(posicao == 0) {
			this.inicio = inicio.getProximo();
		}else {
			NoEncadeado aux = buscarNo(posicao - 1);
			aux.setProximo(aux.getProximo(aux.getProximo()));
		}
		this.tamanho--;
	}

	public String toString() {
		if(estaVazia()) {
			return "[]";
		}
		NoEncadeado aux = this.inicio;
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
	
	protected NoEncadeado buscarNo(int posicao) {
		if(posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posição invalida");
		}
		if(posicao == 0) {
			return inicio;
		}
		if(posicao == tamanho) {
			return ultimo;
		}
		NoEncadeado aux = this.inicio;
		for(int i = 0; i < posicao; i++) {
			aux = aux.getProximo();
		}
		return aux;
	}
	
	public Object buscarElemento(int posicao) {
		if(posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posição invalida");
		}
		if(posicao == 0) {
			return inicio.getElemento();
		}
		if(posicao == tamanho) {
			return ultimo.getElemento();
		}
		NoEncadeado aux = this.inicio;
		for(int i = 0; i < posicao; i++) {
			aux = aux.getProximo();
		}
		return aux.getElemento();
	}
	
	public int buscarElemento(T elemento) {
		if(estaVazia()) {
			return -1;
		}
		NoEncadeado aux = this.inicio;
		for (int i = 0; i < this.tamanho; i++) {
			if(aux.getElemento().equals(elemento)) {
				return i;
			}
			aux = aux.getProximo();
		}
		return -1;		
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
