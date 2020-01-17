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
	
	public void adiciona(T elemento) {
		No novoNo = new No();
		novoNo.setElemento(elemento);
		novoNo.setProximo(null);
		
		if(estaVazia()) {
			this.inicio = novoNo;
			this.ultimo = novoNo;
		}else {
			this.ultimo.setProximo(novoNo);
			this.ultimo = novoNo;
		}
		this.tamanho++;
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


}
