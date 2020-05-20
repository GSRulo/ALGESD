package pilhaEfila;

import java.util.Scanner;

public class Pilha {
	
	private char vet[];
	private int topo;

	public Pilha(int tamanho) {
			vet = new char[tamanho];
			topo = -1;
		}

	public void empilhar(char x) {
		topo++;
		vet[topo] = x;
	}

	public char desempilhar() {
		char aux = vet[topo];
		topo--;
		return aux;
	}

	public boolean vazia() {
		if (topo == -1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		Pilha p1 = new Pilha(50);
		System.out.println("Informe a palavra: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String e = sc.nextLine();

		for (int i = 0; i < e.length(); i++)
			p1.empilhar(e.charAt(i));

		String inver = "";

		while (!p1.vazia()) {
			inver = inver + p1.desempilhar();
		}

		if (inver.equals(e)) {
			System.out.println("É Palindrome");
		} else {
			System.out.println("Não é Palindrome");
		}
	}
}
