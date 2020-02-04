package estruturadados.algoritimosordenacao;

public class QuickSort<T> {
	public static <T extends Comparable<T>> void sort(T vetor[]) {
		quickSort(vetor, 0, vetor.length -1);
	}
	
	private static<T extends Comparable<T>> void quickSort(T vetor[], int inicio, int fim){
        if (inicio < fim)
        {
            int pivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, pivo);
            quickSort(vetor, pivo + 1, fim);
        }
    }

    private static <T extends Comparable<T>> int separar(T vetor[], int inicio, int fim){
        int pivo = (inicio + fim) / 2;
        T aux = vetor[pivo];
        inicio--;
        fim++;
        
        while (true){
            do {
            	inicio++; 
            }while (vetor[inicio].compareTo(aux) < 0) ;
            do { 
            	fim--; 
            }while (vetor[fim].compareTo(aux) > 0) ;
            
            if (inicio >= fim) { 
            	return fim;
            }
            T temp = vetor[inicio];
            vetor[inicio] = vetor[fim];
            vetor[fim] = temp;
        }
    }
}
