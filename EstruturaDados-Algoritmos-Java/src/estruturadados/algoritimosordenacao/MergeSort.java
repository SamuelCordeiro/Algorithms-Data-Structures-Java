package estruturadados.algoritimosordenacao;

public class MergeSort {
	public static <T extends Comparable<T>> void sort(T vetor[]) {
		int inicio = 0; 
		int fim = vetor.length - 1;
		mergeSort(vetor, inicio, fim);
	}

	public static <T extends Comparable<T>> void mergeSort(T vetor[], int inicio, int fim) {
		int meio;
		if(inicio < fim) {
			meio = (inicio + fim)/2;
			mergeSort(vetor, inicio, meio);
			mergeSort(vetor, meio + 1, fim);
			intercalar(vetor, inicio, meio, fim);
		}
	}

	public static <T extends Comparable<T>> void intercalar(T vetor[], int inicio, int meio, int fim) {
		T[] vetorDireita  = (T[]) new Comparable[meio - inicio + 1];
		T[] vetorEsquerda = (T[]) new Comparable[fim - meio];

		for(int i = 0; i < vetorEsquerda.length; ++i) {
			vetorEsquerda[i] = vetor[inicio + i];
		}
		for(int i = 0; i < vetorDireita.length; ++i) {
			vetorDireita[i] = vetor[meio + 1 + i];
		}

		int indiceEsquerda = 0, indiceDireita = 0;
		int indice = inicio;

		while (indiceEsquerda < vetorEsquerda.length && indiceDireita < vetorDireita.length)
		{
			if (vetorEsquerda[indiceEsquerda].compareTo(vetorDireita[indiceDireita]) <= 0)
			{
				vetor[indice] = vetorEsquerda[indiceEsquerda];
				indiceEsquerda++;
			}
			else
			{
				vetor[indice] = vetorDireita[indiceDireita];
				indiceDireita++;
			}
			indice++;
		}
		while (indiceEsquerda < vetorEsquerda.length) {
			vetor[indice++] = vetorEsquerda[indiceEsquerda++];
		}
		while (indiceDireita < vetorDireita.length) {
			vetor[indice++] = vetorDireita[indiceDireita++];
		}
	}
}
