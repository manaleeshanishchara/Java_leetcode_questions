import java.util.*;

class AllPathsSourceTarget {
    private static int target;
    private static int[][] graph;
    private static HashMap<Integer, List<List<Integer>>> memo;

    public static void main(String[] args) {
        int[][] graph = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
        List<List<Integer>> answer = allPathsSourceTarget(graph);
        System.out.println("answer: " + answer);
    }

    protected static List<List<Integer>> allPathsToTarget(int currNode) {
        // memoization. check the result in the cache first
        if (memo.containsKey(currNode))
            return memo.get(currNode);

        System.out.println();
        System.out.println("memo: " + memo);

        List<List<Integer>> results = new ArrayList<>();
        // base case
        if (currNode == target) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(target);
            results.add(path);
            System.out.println("results: " + results);
            return results;
        }

        // iterate through the paths starting from each neighbor.
        for (int nextNode : graph[currNode]) {
            for (List<Integer> path : allPathsToTarget(nextNode)) {
                System.out.println("LOOP");
                System.out.println("for loop before results: " + results);

                ArrayList<Integer> newPath = new ArrayList<>();
                newPath.add(currNode);
                newPath.addAll(path);
                results.add(newPath);
                System.out.println("for loop newPath: " + newPath);
                System.out.println("for loop results: " + results);

            }
        }
        memo.put(currNode, results);
        return results;
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph2) {

        target = graph2.length - 1;
        graph = graph2;
        memo = new HashMap<>();

        return allPathsToTarget(0);
    }
}