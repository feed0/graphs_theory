import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GraphMatrix {

	private static final Random rnd = new Random();

	private int[][] matrix;
	private int 	numVertices;
	private int 	matrixType;
	private boolean isDirected;
	private boolean isWeighted;
	
	/**Random matrix
	 * Receives boolean atributes to set the matrix type
	 * Sets the matrix type automaticall, then randomizes the edges
	 * 
	 * @param numVertices int
	 * @param isDirected boolean
	 * @param isWeighted boolean
	 */
	public GraphMatrix(int numVertices, boolean isDirected, boolean isWeighted) {
		this.numVertices = numVertices;
		matrix = new int[numVertices][numVertices];
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
		setMatrixType();
		randomize();
	}

	/**Matrix from input
	 * Client inputs an array as a matrix
	 * Atributes are set automatically 
	 * @param numVertices int
	 * @param newMatrix int[][]
	 */
	public GraphMatrix(int numVertices, int[][] newMatrix) {
		this.numVertices = numVertices;
		matrix = newMatrix;
		setIsDirected();
		setIsWeighted();
		setMatrixType();
	}
	
	/**Sets the edges according to the matrixType
	 * Always iterating through the LOWER TRIANGLE. 
	 * Instead of O(n^2), it's O(n(n-1)/2) (i.e. polynomial instead of quadratic)
	 */
	public void randomize() {
		
		switch (matrixType) {
			case 0: // !dir !wei 	0s and 1s 	mirror
				
			// iterates through the LOWER TRIANGLE,
				for (int i = 1; i < numVertices; i++) {
					for (int j = 0; j != i; j++) {

						// randomizes the edges (0 or 1)
						int value = rnd.nextInt(0, 2);

						// mirrors the edges
						matrix[i][j] = value;
						matrix[j][i] = value;
					}
				}
			break;

			case 1: // !dir  wei 	any num   	mirror
			
			// iterates through the LOWER TRIANGLE,
				for (int i = 1; i < numVertices; i++) {
					for (int j = 0; j < i; j++) {

						// randomizes the edges (any num)
						int value = rnd.nextInt();

						// mirrors the edges
						matrix[i][j] = value;
						matrix[j][i] = value;
					}
				}
			break;

			case 2: // dir !wei 	0s and 1s 	(a -> b: 1; b -> a: 0)
			
			// iterates through the LOWER TRIANGLE,
				for (int i = 1; i < numVertices; i++) {
					for (int j = 0; j != i; j++) {

						// randomizes in which triangle to fill
						int orientation = rnd.nextInt(0, 2);

						switch (orientation) {
							case 0: // conventional IJ
								matrix[i][j] = 1;
								break;
							case 1: // flipped JI
								matrix[j][i] = 1;
								break;
							default:
							break;
						}
						
					}
				}
			break;

			case 3: // dir  wei 	any num    	(a -> b: x; b -> a: 0)
			
			// iterates through the LOWER TRIANGLE,
				for (int i = 1; i < numVertices; i++) {
					for (int j = 0; j != i; j++) {

						// randomizes in which triangle to fill and the value
						int orientation = rnd.nextInt(0, 2);
						int value = rnd.nextInt();

						switch (orientation) {
							case 0: // conventional IJ
								matrix[i][j] = value;
								break;
							case 1: // flipped JI
								matrix[j][i] = value;
								break;
							default:
							break;
						}
						
					}
				}
			break;
			default:
			break;

		}
	}
	
	// Algorithms
	public boolean isComplete() {
		
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
	
	public boolean areIsomorphs(int[][] outraMatriz) {
		// TODO implement
		return true;
	}
	
	public void rangeSearch(int ponto) {
		// TODO translate to english
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

	// TODO format as table
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
	
	// Get Set
	private void setMatrixType() {

		int type;
		/* Types			Values		Triangles
		 * 0: !dir !wei 	0s and 1s 	mirror
		 * 1: !dir  wei 	any num   	mirror
		 * 2:  dir !wei 	0s and 1s 	(a -> b: 1; b -> a: 0)
		 * 3:  dir  wei 	any num    	(a -> b: x; b -> a: 0)
		 */
		if (!isDirected && !isWeighted) {
			type = 0;
		} else if (!isDirected && isWeighted) {
			type = 1;
		} else if (isDirected && !isWeighted) {
			type = 2;
		} else {
			type = 3;
		}
		
		this.matrixType = type;
}

	private void setIsDirected() {
	
		// these two loops iterate through the LOWER TRIANGLE,
		// EXCLUDING the MAIN DIAGONAL.
		for (int i = 1; i < numVertices; i++)
			for (int j = 0; j < i; j++)
			
				// if any cells are NOT MIRRORED,
				if (matrix[i][j] != matrix[j][i]) {
				
					// then isDirected = TRUE
					this.isDirected = true;
	       			return;
				}
	}

	private void setIsWeighted() {
	
	// iterates through the ENTIRE matrix
	for (int i = 0; i < numVertices; i++)
		for (int j = 0; j < numVertices; j++)
			
			// checks for cells that are neither 0 nor 1,
			// !0 and !1 == !(0 or 1)
			if ( !(matrix[i][j] == 0 || matrix[i][j] == 1) ) {
				
				// then isWeighted = TRUE
				this.isWeighted = true;
				return;
			}
	} 
	
	public int[][] getMatrix() {
		return matrix;
	}
	
	public int getNumVertices() {
		return numVertices;
	}
	
}
