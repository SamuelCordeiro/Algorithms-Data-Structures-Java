package estruturadados.estruturadinamica;

public class NoEncadeado {

	private Object elemento;
	private NoEncadeado proximo;
	
	public NoEncadeado() {}
	
	public NoEncadeado(Object elemento, NoEncadeado proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public Object getElemento() {
		return elemento;
	}
	
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	
	public NoEncadeado getProximo(NoEncadeado x) {
		return x.getProximo();
	}
	
	public NoEncadeado getProximo() {
		return proximo;
	}
	
	public void setProximo(NoEncadeado proximo) {
		this.proximo = proximo;
	}
}
