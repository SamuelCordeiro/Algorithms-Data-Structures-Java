package estruturadados.estruturadinamica;

public class NoDuplamenteEncadeado {

	private Object elemento;
	private NoDuplamenteEncadeado anterior;
	private NoDuplamenteEncadeado proximo;
	
	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public NoDuplamenteEncadeado getAnterior() {
		return anterior;
	}
	public void setAnterior(NoDuplamenteEncadeado anterior) {
		this.anterior = anterior;
	}
	public NoDuplamenteEncadeado getProximo() {
		return proximo;
	}
	public void setProximo(NoDuplamenteEncadeado proximo) {
		this.proximo = proximo;
	}
}
