package estruturadados.algoritimosordenacao;

public class InsertionSort {
	public static <T extends Comparable<T>> void sort(T vetor[]){
		T aux;
		int j;
		for (int i = 1; i < vetor.length; i++) {
			aux = vetor[i];
			j = i-1;
			while((j >= 0) && (vetor[j].compareTo(aux) > 0)) {
				vetor[j + 1] = vetor[j];
				j--;
			}
			vetor[j+1] = aux;
		}
		
	}
}
