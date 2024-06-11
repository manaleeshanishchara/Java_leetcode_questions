import java.util.*;

// "static void main" must be defined in a public class.
public class MinSetSize {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] array = { 3,3 };

        int answer = minSetSize(array);

        System.out.println("answer " + answer);

    }

    public static int minSetSize(int[] arr) {

        // Sort the input numbers.
        Arrays.sort(arr);
        System.out.println("sorted answer " + Arrays.toString(arr));

        // Make the List of Counts
        List<Integer> counts = new ArrayList<>();
        int currentRun = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                System.out.println("if i " + i);
                // System.out.println("if i " + i);
                currentRun += 1;
                continue;
            }else{ 
                System.out.println("else i " +i);
            }
            counts.add(currentRun); 
            currentRun = 1;
            System.out.println("counts " +counts);
        }
        counts.add(currentRun);

        Collections.sort(counts);
        Collections.reverse(counts);

        // Remove numbers until at least half are removed.
        int numbersRemovedFromArr = 0;
        int setSize = 0;
        for (int count : counts) {
            numbersRemovedFromArr += count;
            setSize += 1;
            if (numbersRemovedFromArr >= arr.length / 2) {
                break;
            }
        }

        return setSize;
    }

}