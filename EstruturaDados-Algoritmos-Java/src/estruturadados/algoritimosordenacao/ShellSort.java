package estruturadados.algoritimosordenacao;

public class ShellSort {
	public static <T extends Comparable<T>> void sort(T[] vetor) {
		
		for (int gap = vetor.length / 2; gap > 0; gap /= 2)
        {
            for (int indice = gap; indice < vetor.length; indice++)
            {
                int indiceAux = indice;
                T aux = vetor[indice];
                while (indiceAux >= gap && vetor[indiceAux - gap].compareTo(aux) > 0)
                {
                    vetor[indiceAux] = vetor[indiceAux - gap];
                    indiceAux -= gap;
                }
                vetor[indiceAux] = aux;
            }
        }
    }
}
