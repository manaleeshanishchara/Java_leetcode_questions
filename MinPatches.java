public class MinPatches {

    public static void main(String[] args) {
        int[] nums = { 1, 5, 10 };
        int answer = minPatches(nums, 20);
        System.out.println("answer: " + answer);
    }

    public static int minPatches(int[] nums, int n) {
        int patches = 0;
        long miss = 1; // The smallest number that cannot be formed yet
        int i = 0;

        while (miss <= n) {
            System.out.println();
            System.out.println("i: " + i);
            System.out.println("nums[i]: " + nums[i]);
            System.out.println("miss: " + miss);
            System.out.println("patches: " + patches);
            if (i < nums.length && nums[i] <= miss) {
                // If the current number in the array can be used to form "miss"
                miss += nums[i];
                i++;
                System.out.println("IF");

            } else {
                // Patch the array by adding "miss"
                miss += miss;
                patches++;
                System.out.println("ELSE");

            }

            System.out.println();
            System.out.println("AFTER");
            System.out.println("i: " + i);
            System.out.println("nums[i]: " + nums[i]);
            System.out.println("miss: " + miss);
            System.out.println("patches: " + patches);

        }

        return patches;
    }
}
