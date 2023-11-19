package graphs_theory.src.main.java.com.grafos;


public class Dijkstra {
    public static void main(String[] args) {
        int V = 5; // Número de vértices do grafo
        int source = 0; // Vértice de origem

        // Crie um grafo representado como uma matriz de adjacência
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {0, 0, 3, 8, 5},
            {0, 0, 0, 0, 7},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 9, 0}
        };

        dijkstra(graph, V, source);
    }

    private static void dijkstra(int[][] graph, int V, int source) {
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE/2;
            sptSet[i] = false;
        }

        dist[source] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet, V);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && (dist[u] + graph[u][v] < dist[v])) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Exibir os resultados
        for (int i = 0; i < V; i++) {
            System.out.println("Vértice " + i + ": Menor distância = " + dist[i]);
        }
    }

    private static int minDistance(int[] dist, boolean[] sptSet, int V) {
        int min = Integer.MAX_VALUE/2;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}