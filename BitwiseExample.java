public class BitwiseExample {
    public static int findUniqueNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            System.out.println();
            System.out.println("xor "+xor);
            System.out.println("num "+num);

            xor ^= num;
            System.out.println("xor "+xor);
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 3, 7, 5};
        int uniqueNumber = findUniqueNumber(nums);
        System.out.println("Unique number: " + uniqueNumber); // Output: 7
    }
}
