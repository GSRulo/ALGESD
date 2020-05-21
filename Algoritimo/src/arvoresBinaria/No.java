package arvoresBinaria;

public class No {
	int chave;
	No pai, esquerda, direita;

	public No antecessor() {
		No n, ant;
		ant = n = esquerda;

		while (n != null) {
			ant = n;
			n = n.direita;
		}

		return ant;
	}

	public No sucessor() {
		No n, suc;
		suc = n = direita;

		while (n != null) {
			suc = n;
			n = n.esquerda;
		}

		return suc;
	}

	public int numeroFilhos() {
		if (esquerda == null && direita == null)
			return 0;
		else if (esquerda != null && direita != null)
			return 2;
		else
			return 1;
	}

	public String toString() {
		return "<" + chave + ">";
	}
}

class ArvoreBinaria {
	private No raiz;

	public ArvoreBinaria() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void insere(int chave) {
		No novo = new No();
		novo.chave = chave;
		novo.esquerda = novo.direita = null;

		if (raiz == null) {
			novo.pai = null;
			raiz = novo;
		} else {
			No aux = raiz, pai = null;

			while (aux != null) {
				if (aux.chave == chave)
					return; // o "chave" ja existe
				else if (aux.chave < chave) {
					pai = aux;
					aux = aux.direita; // passo a procurar aa direita
				} else {
					pai = aux;
					aux = aux.esquerda; // passo a procurar aa esquerda
				}
			}

			if (pai.chave > chave)
				pai.esquerda = novo;
			else
				pai.direita = novo;

			novo.pai = pai;
		}
	}

	public void remove(No n) {
		if (raiz == null)
			throw new RuntimeException("Lista vazia.");
		else {
			int numFilhos = n.numeroFilhos();

			if (numFilhos == 0) // folha
			{
				if (n == raiz)
					raiz = null;
				else {
					if (n.pai.chave > n.chave)
						n.pai.esquerda = null;
					else
						n.pai.direita = null;
				}
			} else if (numFilhos == 1) // tem 1 filho
			{
				No filho;
				if (n.esquerda != null)
					filho = n.esquerda;
				else
					filho = n.direita;

				if (n == raiz)
					raiz = filho;
				else {
					if (n.pai.chave > n.chave)
						n.pai.esquerda = filho;
					else
						n.pai.direita = filho;
				}
			} else // tem 2 filhos
			{
				No substituto = n.antecessor();
				remove(substituto);
				n.chave = substituto.chave;
			}
		}
	}

	public boolean contem(int chave) {
		No aux = raiz;

		while (aux != null) {
			if (aux.chave == chave)
				return true; // se encontrei, retorno true
			else if (aux.chave < chave)
				aux = aux.direita; // passo a procurar aa direita
			else
				aux = aux.esquerda; // passo a procurar aa esquerda
		}
		return false; // se chegou aqui eh porque nao existe
	}

	public No procurar(int chave) {
		No aux = raiz;

		while (aux != null) {
			if (aux.chave == chave)
				return aux; // se encontrei, retorno a referencia
			else if (aux.chave < chave)
				aux = aux.direita; // passo a procurar aa direita
			else
				aux = aux.esquerda; // passo a procurar aa esquerda
		}
		return null; // se chegou aqui eh porque nao existe
	}

	private String espacos(int n) {
		String s = "";
		for (int i = 0; i < n; i++)
			s = s + "      ";
		return s;
	}

	public String toString() {
		return mostra(raiz, 1);
	}

	private String mostra(No n, int nivel) {
		if (n == null)
			return "";
		else
			return mostra(n.direita, nivel + 1) + "\n" + espacos(nivel) + n.chave + "\n"
					+ mostra(n.esquerda, nivel + 1);
	}

	public String emOrdem(No raiz) {
		if (raiz == null)
			return "";
		else
			return emOrdem(raiz.esquerda) + " " + raiz.chave + " " + emOrdem(raiz.direita);
	}

	public String emOrdem() {
		return emOrdem(raiz);
	}

	// Exercicio 2:
	public int numerosDeNos(No raiz) {
		if (raiz == null) {
			return 0;
		} else {
			return numerosDeNos(raiz.esquerda) + numerosDeNos(raiz.direita) + 1;
		}
	}

	// Exercicio 3
	public int somaDeNos(No raiz) {
		if (raiz == null) {
			return 0;
		} else {
			return somaDeNos(raiz.esquerda) + somaDeNos(raiz.direita) + raiz.chave;
		}
	}

	// Exercicio 4
	public void folhas(No raiz) {
		if (raiz == null) {
			return;
		}

		if (raiz.numeroFilhos() == 0)
			System.out.println(raiz.chave);
		folhas(raiz.esquerda);
		folhas(raiz.direita);

	}

	// Exercicio 5
	public int altura(No raiz) {
		if (raiz == null) {
			return 0;
		}

		int d = altura(raiz.direita);
		int e = altura(raiz.esquerda);

		if (d > e) {
			return d + 1;
		} else {
			return e + 1;
		}
	}

	// Exercicio 6
	public int menor(No raiz) {
		if (raiz == null)
			return 0;
		int a = menor(raiz.direita);
		int b = menor(raiz.esquerda);
		if (raiz.direita == null && raiz.esquerda == null)
			return raiz.chave;
		if (raiz.esquerda == null && raiz.direita != null)
			return menor(raiz.direita);
		if (raiz.direita == null && raiz.esquerda != null)
			return menor(raiz.esquerda);
		return a < b ? a : b;
	}

	public int maior(No raiz) {
		if (raiz == null)
			return 0;
		int a = maior(raiz.direita);
		int b = maior(raiz.esquerda);
		if (raiz.direita == null && raiz.esquerda == null)
			return raiz.chave;
		if (raiz.esquerda == null && raiz.direita != null)
			return maior(raiz.direita);
		if (raiz.direita == null && raiz.esquerda != null)
			return maior(raiz.esquerda);
		return a > b ? a : b;
	}
}

class TesteArvoreBinaria {
	static int indice = 0;

	public static void emOrdemModificado(int vet[], No raiz) {
		if (raiz != null) {
			emOrdemModificado(vet, raiz.esquerda);
			vet[indice] = raiz.chave;
			indice++;
			emOrdemModificado(vet, raiz.direita);
		}
	}

	public static void ordenarVetor(int vet[]) {
		ArvoreBinaria ab = new ArvoreBinaria();

		for (int i = 0; i < vet.length; i++) {
			ab.insere(vet[i]);
		}

		emOrdemModificado(vet, ab.getRaiz());
	}

	public static void main(String[] args) {
		System.out.println("Arvore Binaria (de numeros inteiros)");
		ArvoreBinaria ab = new ArvoreBinaria();

		ab.insere(5);
		ab.insere(7);
		ab.insere(3);
		ab.insere(2);
		ab.insere(1);
		ab.insere(9);
		ab.insere(8);
		ab.insere(4);
		ab.insere(6);

		System.out.println("Inserindo 5, 7, 3, 2, 1, 9, 8, 4, 6\n\n" + "A arvore em ordem sera assim: " + ab.emOrdem());
		System.out.println(ab);

		System.out.println("Está árvore tem " + ab.numerosDeNos(ab.getRaiz()) + " nós");
		System.out.println("A soma de nós nessa árvore é: " + ab.somaDeNos(ab.getRaiz()));
		System.out.println("Quantidades de folhas é: ");
		ab.folhas(ab.getRaiz());
		System.out.println("Altura: " + ab.altura(ab.getRaiz()));
		System.out.println("Maior: " + ab.maior(ab.getRaiz()));
		System.out.println("Maior: " + ab.menor(ab.getRaiz()));
		

		System.out.println("\nRemovendo o 5 ......");
		ab.remove(ab.procurar(5));
		System.out.println(ab);
		System.out.println("\nRemovendo o 8 ......");
		ab.remove(ab.procurar(8));
		System.out.println(ab);
		System.out.println("\nRemovendo o 3 ......");
		ab.remove(ab.procurar(3));
		System.out.println(ab);
		System.out.println("O antecessor de " + ab.getRaiz().chave + " eh " + ab.getRaiz().antecessor()
				+ " e o sucessor eh " + ab.getRaiz().sucessor());
		System.out.println("\nTestando o metodo ordenarVetor:\nAntes: ");
		int vet[] = { 6, 3, 8, -1, 10, 13, 7 };
		for (int i = 0; i < vet.length; i++)
			System.out.print(vet[i] + " ");
		ordenarVetor(vet);
		System.out.println("\nDepois: ");
		for (int i = 0; i < vet.length; i++)
			System.out.print(vet[i] + " ");
	}
}