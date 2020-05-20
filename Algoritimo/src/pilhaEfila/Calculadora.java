package pilhaEfila;

import java.util.Scanner;

public class Calculadora {

	private int vet[];
	private int topo;

	public Calculadora(int tamanho) {
		vet = new int[tamanho];
		topo = -1;
	}

	public void empilhar(int x) {
		topo++;
		vet[topo] = x;
	}

	public int desempilhar() {
		int aux = vet[topo];
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

		Calculadora p1 = new Calculadora(50);
		System.out.println("Informe um número: ");
		Scanner sc = new Scanner(System.in);
		String e = sc.next();
				
		int numero = 0;
		int display = 10; 
		String operador = null;
		String parada = "quit";
		
		numero = Integer.parseInt(e);
		System.out.println("Foi o número: " + numero);
		p1.empilhar(numero);
				
		while (e != parada) {
			
			System.out.println("Informe o operador: ");
			e = sc.next();
			operador = e;
			
			System.out.println("Display Atual: " + display);
			
			if(operador.equals("+")) {
				display = display + numero;
				
			} else if (operador.equals("-")) {
				display = display - numero;
				
			} else if (operador.equals("*")) {
				display = display * numero;
				
			} else if (operador.equals("/")) {
				display = display / numero;
			}
				
			
			System.out.println("Display Atualizado: " + display);
			
		
		}
		sc.close();
	}

}
