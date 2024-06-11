import java.util.*;

public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all numbers to get the XOR of the two unique numbers

        System.out.println("nums " + Arrays.toString(nums));

        // int[] nums = {1, 2, 1, 3, 2, 5};

        int xor = 0;
        for (int num : nums) {
            System.out.println();
            System.out.println("xor " + xor);
            System.out.println("num " + num);
            xor ^= num;
            System.out.println("xor " + xor);
        }

        System.out.println("unique xor " + xor);
        System.out.println("xor nums " + Arrays.toString(nums));

        // Step 2: Find a set bit (rightmost set bit in this case)
        int rightmostSetBit = xor & -xor;

        System.out.println("-xor " + (-xor));
        System.out.println("rightmostSetBit " + rightmostSetBit);

        // Step 3: Partition numbers into two groups and XOR each group
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        System.out.println("xor num " + Arrays.toString(nums));

        return new int[] { num1, num2 };
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        int[] result = solution.singleNumber(nums);
        System.out.println(result[0] + " " + result[1]); // Output: 3 5 or 5 3
    }
}
