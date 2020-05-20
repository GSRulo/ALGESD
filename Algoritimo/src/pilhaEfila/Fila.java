package pilhaEfila;

public class Fila {

	private int vet[];
	private int inicio, fim, quantidade;

	public Fila(int tamanho) {
		vet = new int[tamanho];
		inicio = fim = quantidade = 0;
	}

	public void enfileirar(int x) {
		vet[fim] = x;
		fim++;
		quantidade++;
		if (fim == vet.length)
			fim = 0;
	}

	public int desenfileirar() {
		int resp = vet[inicio];
		inicio++;
		quantidade--;
		if (inicio == vet.length)
			inicio = 0;
		return resp;
	}

	public boolean vazia() {
		if (quantidade == 0)
			return true;
		else
			return false;
	}

	public boolean cheia() {
		if (quantidade == vet.length)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		int mat[][] = { { 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		
		mostrarMatriz(mat);
		

		int x = 3, y = 7;
		System.out.println("Coordenadas iniciais: x = " + x + ", y = " + y + "\n\n");
		Fila f = new Fila(1000);
		f.enfileirar(x);
		f.enfileirar(y);

		while (!f.vazia()) {
			x = f.desenfileirar();
			y = f.desenfileirar();
			if (mat[x][y] == 0) {
				
				mat[x][y] = 2;

			} if ((x + 1) < mat.length && mat[x + 1][y] == 0) {
				f.enfileirar(x + 1);
				f.enfileirar(y);
			
			} if ((x - 1) < mat.length && mat[x - 1][y] == 0) {
				f.enfileirar(x - 1);
				f.enfileirar(y);
				
			} if ((y + 1) < mat[0].length && mat[x][y + 1] == 0) {
				f.enfileirar(x);
				f.enfileirar(y + 1);
				
			} if ((y - 1) < mat[0].length && mat[x][y - 1] == 0) {
				f.enfileirar(x);
				f.enfileirar(y - 1);
			}
			
		}
		
		mostrarMatriz(mat);
	}
	
	public static void mostrarMatriz(int mat[][]) {
		for(int l = 0; l < mat.length; l++) {
			for(int c = 0; c < mat[0].length; c++) {
				if(mat[l][c] == 0) System.out.print(" ");
				else if (mat[l][c] == 1) System.out.print("-");
				else if (mat[l][c] == 2) System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
}
