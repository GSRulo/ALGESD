package ordenacao2;

import java.util.Arrays;

public class ArraysSort {
	
	public static void main(String[] args) {

		String saida = "\nMetodo da ArraysSort:\n";

		for (int tam = 100000; tam <= 1000000; tam = tam + 100000) {
			int vet[] = new int[tam];

			// Preenchendo o vetor com elementos aleatorios de 0 a 999
			for (int i = 0; i < tam; i++)
				vet[i] = (int) (Math.random() * 1000);

			long tempoAntes = System.currentTimeMillis();
			Arrays.sort(vet);
			long tempoDepois = System.currentTimeMillis();
			saida += "ArraysSort," + tam + "," + (tempoDepois - tempoAntes) + "\n";
		}

		System.out.println("\nTamanho,Tempo(ms)\n" + saida);

	}

}
