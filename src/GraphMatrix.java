public class GraphMatrix {
    private int[][] matrix;
    private int numVertices;

    // square matrix of size numVertices by numVertices
    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        matrix = new int[numVertices][numVertices];
    }

    // randomly fills the matrix with 0s or 1s
    public void randomize() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrix[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    // fills with 1s
    public void fill() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrix[i][j] = 1;
            }
        }
    }
    
}
