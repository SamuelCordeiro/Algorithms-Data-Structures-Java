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
	public void adiciona(T elemento) {
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

	//protected 
	public void adiciona(T elemento, int posicao) {
		if(posicao < 0 || posicao > tamanho) {
			throw new IllegalArgumentException("Posição invalida");
		}
		NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado(elemento);
		if(posicao == this.tamanho-1) {
			adiciona(elemento);
		}else if(posicao == 0) {
			novoNo.setAnterior(this.inicio.getAnterior());
			novoNo.setProximo(this.inicio);
			this.inicio.setAnterior(novoNo);
			this.inicio = novoNo;
			this.tamanho++;			
		}else {
			NoDuplamenteEncadeado aux = buscarNo(posicao+1);
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
			throw new IllegalArgumentException("Posição invalida");
		}		
		if(posicao == 0) {
			if(tamanho == 1) {
				this.inicio = this.ultimo = null;
				this.tamanho--;
			}else {
				this.inicio = this.inicio.getProximo();
				this.inicio.setAnterior(this.ultimo);
				this.ultimo.setProximo(this.inicio);
				this.tamanho--;
			}
		}
		if(posicao == this.tamanho-1) {
			if(tamanho == 1) {
				this.inicio = this.ultimo = null;
				this.tamanho--;
			}else {
				this.ultimo = this.ultimo.getAnterior();
				this.ultimo.setProximo(this.inicio);
				this.inicio.setAnterior(this.ultimo);
				this.tamanho--;
			}
		}
}
public NoDuplamenteEncadeado buscarNo(int posicao) {
	if(posicao < 0 || posicao > tamanho) {
		throw new IllegalArgumentException("Posição invalida");
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
