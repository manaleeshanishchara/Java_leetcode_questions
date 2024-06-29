import java.util.*;


class GetAncestors {

    public static void main(String[] args) {
        int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        List<List<Integer>> answer = getAncestors(8,edges);
        // System.out.println("answer: " + answer);
    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Create adjacency list
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        System.out.println("edges: " + Arrays.deepToString(edges));
        System.out.println("adjacencyList: " + Arrays.toString(adjacencyList));


        // Fill the adjacency list and indegree array based on the edges
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[from].add(to);
            indegree[to]++;
        }

        System.out.println("adjacencyList: " + Arrays.toString(adjacencyList));
        System.out.println("indegree: " + Arrays.toString(indegree));


        // Queue for nodes with no incoming edges (starting points for topological sort)
        Queue<Integer> nodesWithZeroIndegree = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                nodesWithZeroIndegree.add(i);
            }
        }

        System.out.println("nodesWithZeroIndegree: " + nodesWithZeroIndegree);


        // List to store the topological order of nodes
        List<Integer> topologicalOrder = new ArrayList<>();
        while (!nodesWithZeroIndegree.isEmpty()) {
            int currentNode = nodesWithZeroIndegree.poll();
            topologicalOrder.add(currentNode);

            // Reduce indegree of neighboring nodes and add them to the queue
            // if they have no more incoming edges
            for (int neighbor : adjacencyList[currentNode]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    nodesWithZeroIndegree.add(neighbor);
                }
            }

        System.out.println("indegree: " + Arrays.toString(indegree));
        System.out.println("nodesWithZeroIndegree: " + nodesWithZeroIndegree );
        // System.exit(0);


        }

        System.out.println("topologicalOrder: " + topologicalOrder);


        // Initialize the result list and set list for storing ancestors
        List<List<Integer>> ancestorsList = new ArrayList<>();
        List<Set<Integer>> ancestorsSetList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestorsList.add(new ArrayList<>());
            ancestorsSetList.add(new HashSet<>());
        }

        // Fill the set list with ancestors using the topological order
        for (int node : topologicalOrder) {
            for (int neighbor : adjacencyList[node]) {
                // Add immediate parent, and other ancestors.
                ancestorsSetList.get(neighbor).add(node);
                System.out.println("ancestorsSetList: " + ancestorsSetList);
                ancestorsSetList
                    .get(neighbor)
                    .addAll(ancestorsSetList.get(node));
                System.out.println("ancestorsSetList: " + ancestorsSetList);
                // System.exit(0);
            }
        }

        System.out.println("ancestorsList: " + ancestorsList);
        System.out.println("ancestorsSetList: " + ancestorsSetList);


        // Convert sets to lists and sort them
        for (int i = 0; i < ancestorsList.size(); i++) {
            ancestorsList.get(i).addAll(ancestorsSetList.get(i));
            Collections.sort(ancestorsList.get(i));
        }

        return ancestorsList;
    }
}