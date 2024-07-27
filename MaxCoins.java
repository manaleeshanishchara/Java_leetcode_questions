import java.util.List;
import java.util.ArrayList;

public class MaxCoins {
    public int maxCoins(List<List<Integer>> piles, int k) {
        // Number of piles
        int n = piles.size();

        // dp[i][j] represents the maximum coins we can collect from the first i piles
        // using j coins
        int[][] dp = new int[n + 1][k + 1];

        // Iterate through each pile
        for (int i = 1; i <= n; i++) {
            // Current pile
            List<Integer> pile = piles.get(i - 1);
            int pileSize = pile.size();

            // Calculate cumulative sums of the pile
            List<Integer> cumulativeSum = new ArrayList<>(pileSize + 1);
            cumulativeSum.add(0); // Initial sum is 0
            for (int j = 0; j < pileSize; j++) {
                cumulativeSum.add(cumulativeSum.get(j) + pile.get(j));
            }

            // Update dp table
            for (int j = 0; j <= k; j++) {
                // Not taking any coin from the current pile
                dp[i][j] = dp[i - 1][j];

                // Try taking coins from the current pile
                for (int x = 1; x <= Math.min(pileSize, j); x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - x] + cumulativeSum.get(x));
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
        List<List<Integer>> piles = new ArrayList<>();
        piles.add(List.of(100));
        piles.add(List.of(100));
        piles.add(List.of(100));
        piles.add(List.of(100));
        piles.add(List.of(100));
        piles.add(List.of(100));
        piles.add(List.of(1, 1, 1, 1, 1, 1, 700));
        int k = 7;
        System.out.println(maxCoins.maxCoins(piles, k)); // Output: 706
    }
}
