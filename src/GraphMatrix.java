import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GraphMatrix {

	private static final Random rnd = new Random();

	private int tipoMatriz = 0;
	private int[][] matrix;
	private int numVertices;

	// square matrix of size numVertices by numVertices
	public GraphMatrix(int numVertices) {
		this.numVertices = numVertices;
		matrix = new int[numVertices][numVertices];
	}

	public GraphMatrix(int numVertices, int[][] novaMatriz) {
		this.numVertices = numVertices;
		matrix = novaMatriz;
	}
	
	public int getTipoMatriz() {
		return tipoMatriz;
	}
	
	public void setTipoMatriz(int tipoMatriz) {
		this.tipoMatriz = tipoMatriz;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}
	
	public int getNumVertices() {
		return numVertices;
	}

	// randomly fills the matrix with 0s or 1s
	public void randomize() {
		switch (tipoMatriz) {
		case 0:
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j != i; j++) {
					int value = rnd.nextInt(0, 2);
					matrix[i][j] = value;
					matrix[j][i] = value;
				}
			}
			break;
		case 1:
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < i; j++) {
					int value = rnd.nextInt(-1, 2);
					matrix[i][j] = value;
					matrix[j][i] = -value;
				}
			}
			break;
		default:
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					if (i != j) {
						matrix[i][j] = rnd.nextInt();
					}
				}
			}
			break;
		}
	}

	public boolean isGrafoCompleto() {

		if (numVertices == 1) {
			return false;
		}

		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				if (i != j && matrix[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean possuiIsomorfismo(int[][] outraMatriz) {
//		asd
		// TODO Buscar/Criar o código deste método
		return true;
	}

	public void rangeSearch(int ponto) {
		List<Integer> lista = Arrays.asList(ponto);
		for (int i = 0; i < numVertices; i++) {
			if (lista.size() == numVertices) {
				break;
			}
			if (!lista.contains(i) && ponto != i && matrix[ponto][i] != 0) {
				lista.add(i);
				ponto = i;
				i = -1;
			}
		}

	}

	// TODO Formatar uma tabela para a exibição de fácil leitura
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int cont = 0; cont < numVertices; cont++) {
			for (int cont2 = 0; cont2 < numVertices; cont2++) {
				builder.append(matrix[cont][cont2] + " ");
			}
			builder.append("\n");
		}

		return builder.toString();
	}

}
