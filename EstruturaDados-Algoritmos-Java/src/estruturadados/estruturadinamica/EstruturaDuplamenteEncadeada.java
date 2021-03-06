package estruturadados.estruturadinamica;

public class EstruturaDuplamenteEncadeada <T>{
	protected NoDuplamenteEncadeado inicio;
	protected NoDuplamenteEncadeado ultimo;
	protected int tamanho;

	public EstruturaDuplamenteEncadeada() {
		this.inicio = this.ultimo = null;
		this.tamanho = 0;
	}

	//protected 
	protected void adiciona(T elemento) {
		NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado(elemento);
		if(estaVazia()) {
			this.inicio = this.ultimo = novoNo;
			novoNo.setAnterior(novoNo);
			novoNo.setProximo(novoNo);
			this.tamanho++;
		}else {
			novoNo.setProximo(inicio);
			novoNo.setAnterior(this.ultimo);
			this.ultimo.setProximo(novoNo);
			this.ultimo = novoNo;

			this.tamanho++;
		}
	}

	protected void adiciona(T elemento, int posicao) {
		if(posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posi��o invalida");
		}	
		NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado(elemento);
		if(posicao == 0) {
			novoNo.setAnterior(this.inicio.getAnterior());
			novoNo.setProximo(this.inicio);
			this.inicio.setAnterior(novoNo);
			this.inicio = novoNo;
			this.tamanho++;	
		}else if(posicao == this.tamanho-1) {
			System.out.println("Q");
			NoDuplamenteEncadeado aux = buscarNo(posicao);
			novoNo.setAnterior(aux.getAnterior());
			novoNo.setProximo(aux);
			aux.setAnterior(novoNo);
			aux = buscarNo(posicao-1);
			aux.setProximo(novoNo);
			this.tamanho++;
		}else {
			NoDuplamenteEncadeado aux = buscarNo(posicao);
			aux.setAnterior(novoNo);
			novoNo.setProximo(aux);
			aux = buscarNo(posicao-1);
			aux.setProximo(novoNo);
			novoNo.setAnterior(aux);
			this.tamanho++;
		}
	}
	protected void remove(int posicao) {
		if(posicao < 0 || posicao > tamanho || estaVazia()) {
			throw new IllegalArgumentException("Posi��o invalida");
		}
		if(posicao == 0 && this.tamanho == 1) {
			this.inicio = this.ultimo = null;
			this.tamanho--;
		}else if(posicao == 0 && this.tamanho != 1){
			this.inicio = this.inicio.getProximo();
			this.inicio.setAnterior(this.ultimo);
			this.ultimo.setProximo(this.inicio);
			this.tamanho--;
		}else if(posicao == this.tamanho-1 && tamanho != 1) {
			this.ultimo = this.ultimo.getAnterior();
			this.ultimo.setProximo(this.inicio);
			this.inicio.setAnterior(this.ultimo);
			this.tamanho--;
		}else {
			NoDuplamenteEncadeado aux = buscarNo(posicao-1);
			aux.setProximo(buscarNo(posicao+1));
			aux = buscarNo(posicao+1);
			aux.setAnterior(buscarNo(posicao-1));
			this.tamanho--;
		}
	}
	
	public Object buscarElemento(int posicao) {
		if(posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posi��o invalida");
		}
		if(posicao == 0) {
			return inicio.getElemento();
		}
		if(posicao == tamanho -1) {
			return ultimo.getElemento();
		}
		NoDuplamenteEncadeado aux = this.inicio;
		for(int i = 0; i < posicao; i++) {
			aux = aux.getProximo();
		}
		return aux.getElemento();
	}
	
	public int buscarElemento(T elemento) {
		if(estaVazia()) {
			return -1;
		}
		NoDuplamenteEncadeado aux = this.inicio;
		for (int i = 0; i < this.tamanho; i++) {
			if(aux.getElemento().equals(elemento)) {
				return i;
			}
			aux = aux.getProximo();
		}
		return -1;		
	}

	private NoDuplamenteEncadeado buscarNo(int posicao) {
		if(posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posi��o invalida");
		}
		if(posicao == 0) {
			return this.inicio;
		}
		if(posicao == tamanho-1) {
			return this.ultimo;
		}
		NoDuplamenteEncadeado aux = this.inicio;
		for(int i = 0; i < posicao; i++) {
			aux = aux.getProximo();
		}
		return aux;
	}

	public String toString() {
		if(estaVazia()) {
			return "[]";
		}
		NoDuplamenteEncadeado aux = this.inicio;
		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < this.tamanho-1; i++) {
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
