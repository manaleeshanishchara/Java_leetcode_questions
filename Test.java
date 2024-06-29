import java.util.*;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        int n = 5;

        int[] arr = new int[n + 1];
        // base case - the second Fibonacci number is 1
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println("ANSWER: "+Arrays.toString(arr));
        System.out.println("ANSWER: "+arr[n]);

        

    }
}
