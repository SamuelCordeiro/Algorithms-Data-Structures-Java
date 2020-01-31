package estruturadados.algoritimosordenacao;

public class SelectionSort {
	public static < T extends Comparable<T>> void sort(T vetor[]) {
		int menor;
		T aux;
		for (int i = 0; i < vetor.length; i++) {
			menor = i;
			for (int j = i+1; j < vetor.length; j++) {
				if(vetor[j].compareTo(vetor[menor]) < 0) {
					menor = j;
				}
			}
			aux = vetor[i];
			vetor[i] = vetor[menor];
			vetor[menor] = aux;
		}
	}
}
