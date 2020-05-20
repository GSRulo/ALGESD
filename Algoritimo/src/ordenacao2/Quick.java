package ordenacao2;

public class Quick {

	public static void quickSort(int vet[]) {
		quickSort(vet, 0, vet.length - 1);
	}

	private static void quickSort(int vet[], int esquerda, int direita) {
		int indice = particao(vet, esquerda, direita);
		if (esquerda < indice - 1)
			quickSort(vet, esquerda, indice - 1);
		if (indice < direita - 1)
			quickSort(vet, indice + 1, direita);
	}

	private static int particao(int vet[], int esquerda, int direita) {
		int i = esquerda, j = direita, aux;
		int pivo = vet[esquerda];
		while (i < j) {
			while (vet[j] < pivo) {
				j--;
			}
			if (i >= j) {
				return i;
			}
			aux = vet[i];
			vet[i] = vet[j];
			vet[j] = aux;
			i++;
			while (vet[i] > pivo) {
				i++;
			}
			aux = vet[i];
			vet[i] = vet[j];
			vet[j] = aux;
			j--;
		}
		return i;
	}

	public static void main(String[] args) {

		String saida = "\nMetodo da Quick\n";

		for (int tam = 100000; tam <= 1000000; tam = tam + 100000) {
			int vet[] = new int[tam];

			// Preenchendo o vetor com elementos aleatorios de 0 a 999
			for (int i = 0; i < tam; i++)
				vet[i] = (int) (Math.random() * 1000);

			long tempoAntes = System.currentTimeMillis();
			quickSort(vet);
			long tempoDepois = System.currentTimeMillis();

			saida += "Quick," + tam + "," + (tempoDepois - tempoAntes) + "\n";
		}

		System.out.println("\nTamanho,Tempo(ms)\n" + saida);

	}

}
