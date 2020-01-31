package estruturadados.algoritimosordenacao;

public class BubbleSort {
	public static <T extends Comparable<T>> void sort(T[] vetor) {
		T aux;
		for (int i = vetor.length; i > 0; i--) {
			for(int j = 0; j < vetor.length; j++) {
				if(vetor[j].compareTo(vetor[j+1]) > 0) {
					aux = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1] = aux;
				}
			}
			
		}
	}
}
