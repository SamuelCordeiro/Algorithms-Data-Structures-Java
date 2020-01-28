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
			this.ultimo.setProximo(novoNo);
			novoNo.setAnterior(this.ultimo);
			this.ultimo = novoNo;
			novoNo.setProximo(inicio);
			this.tamanho++;
		}
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
