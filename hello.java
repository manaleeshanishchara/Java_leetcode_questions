public class hello {

    public static void main(String[] args) {
        String x = "Manalee Shanishchara";
        System.out.println(x);

        // int[] nums = new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int[] nums = new int[] { 0, 1, 1, 0, 0, 1, 1, 0 };
        int k = 1;
        int res = 0;
        res = longestOnes(nums, k);

        System.out.println(res);


        // Example 2

        // int[] nums2 = new int[] { 1, 6, 3, 2, 7, 2 };
        // int[][] queries = new int[][] { { 0, 3 }, { 2, 5 }, { 2, 4 } };
        // int limit = 13;

        // boolean[] res2;

        // res2 = answerQueries(nums2, queries, limit);
        // System.out.println(res2);

    }

    public static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        // int[] prefix = new int[nums.length];
        // prefix[0] = nums[0];

        // for (int i = 1; i < nums.length; i++) {
        //     prefix[i] = prefix[i - 1] + nums[i];
        // }

        boolean[] ans = new boolean[queries.length];
        // for (int i = 0; i < queries.length; i++) {
        //     int x = queries[i][0], y = queries[i][1];
        //     int curr = prefix[y] - prefix[x] + nums[x];
        //     ans[i] = curr < limit;
        // }

        return ans;
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window
            // size same.

            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.

                k += 1 - nums[left];
                left++;
            }

        }

        System.out.println("K: " + k);
        System.out.println("LEFT: " + left);
        System.out.println("RIGHT: " + right);
        System.out.println("VALUE: " + nums[left]);
        return right - left;
    }
}