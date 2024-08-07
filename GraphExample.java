import java.util.ArrayList;
import java.util.List;

public class GraphExample {
    public static void main(String[] args) {
        // Creating an adjacency list for a graph with 26 vertices (e.g., letters A-Z)
        List<int[]>[] adjacencyList = new List[26];

        // Initialize each list in the array
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Adding edges to the graph
        // Example: Adding an edge from vertex 0 to vertex 1 with weight 10
        adjacencyList[0].add(new int[]{1, 10});
        adjacencyList[0].add(new int[]{2, 5});
        adjacencyList[1].add(new int[]{2, 3});
        adjacencyList[2].add(new int[]{3, 2});
        adjacencyList[3].add(new int[]{4, 7});

        // Printing the adjacency list
        System.out.println("Adjacency List:");
        for (int i = 0; i < adjacencyList.length; i++) {
            if (adjacencyList[i].size() > 0) {
                System.out.print("Vertex " + i + ": ");
                for (int[] edge : adjacencyList[i]) {
                    System.out.print(" -> (" + edge[0] + ", " + edge[1] + ")");
                }
                System.out.println();
            }
        }
    }
}
