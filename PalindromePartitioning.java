import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    
    // Function to partition a string into all possible palindrome substrings
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    // Backtracking function to generate palindrome partitions
    private static void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        // If we have reached the end of the string, add the current partition to the result
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try all possible substrings starting from 'start'
        for (int end = start; end < s.length(); end++) {
            // Check if the substring from 'start' to 'end' is a palindrome
            if (isPalindrome(s, start, end)) {
                // If it's a palindrome, add it to the current partition
                current.add(s.substring(start, end + 1));
                // Recursively generate partitions for the remaining substring
                backtrack(s, end + 1, current, result);
                // Backtrack: remove the last added substring to explore other possibilities
                current.remove(current.size() - 1);
            }
        }
    }
    
    // Function to check if a substring is a palindrome
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    // Main method to test the program
    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> partitions = partition(s);
        
        // Print all palindrome partitions
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }
    }
}
