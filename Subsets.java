import java.util.ArrayList;
import java.util.List;

public class Subsets {
    
    // Function to generate all subsets of a given array
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        System.out.println("result before "+result);

        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
    
    // Helper function to generate subsets recursively
    private static void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));
        System.out.println();
        System.out.println("result "+result);
        System.out.println("index "+index);
        System.out.println("LOOP");
        
        // Iterate through the remaining elements to generate subsets
        for (int i = index; i < nums.length; i++) {
            // Include the current element in the subset
            current.add(nums[i]);
            System.out.println("i "+i);
            System.out.println("current "+current);
            // Recursively generate subsets with the current element included
            generateSubsets(nums, i + 1, current, result);
            // Exclude the current element from the subset (backtrack)
            current.remove(current.size() - 1);
            System.out.println("back current "+current);

            
        }
    }
    
    // Main method to test the program
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> subsets = subsets(nums);
        
        // Print all subsets
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
