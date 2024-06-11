import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassReverseEvenGroups {

    public static class ListNode {
        int val;
        ListNode next;
        // ListNode prev;

        ListNode(int val) {
            this.val = val;
        }

        // public String toString() {
        // return String.format("Node(%d, prev = %s)", val, prev);
        // }

        public String toString() {
            // String prevVal = (prev == null) ? "null" : String.valueOf(prev.val);
            String nextVal = (next == null) ? "null" : String.valueOf(next.val);
            return String.format("Node(%d, next = %s)", val, nextVal);
        }
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        // ListNode node5 = new ListNode(5);
        // ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        // node5.next = node6;
        // node6.next = null;

        ListNode head = node1;
        ListNode test = null;

        // head.next.next.next = null;

        while (head != null) {
            System.out.println("head: " + (head == null ? "null" : head.toString()));
            head = head.next;
        }

        head = node1;

        // ListNode newhead = reverseEvenGroups(head);

        // System.out.println("head: " + (head == null ? "null" : head.toString()));

        int maxSum = pairSum(head);

        System.out.println(maxSum);

    }

    public static int pairSum(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        Collections.sort(values);

        System.out.println("values" + values);

        int left = 0, right = values.size() - 1;
        System.out.println("left" + left);
        System.out.println("right" + right);

        int maxSum = Integer.MIN_VALUE;
        while (left < right) {
            int sum = values.get(left) + values.get(right);
            System.out.println("sum" + sum);

            maxSum = Math.max(maxSum, sum);
            left++;
            right--;
        }

        return maxSum;
    }

    public static ListNode reverseEvenGroups(ListNode head) {
        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            int count = 0;
            ListNode temp = current;
            // Count the number of nodes in the current even-length group
            // while (temp != null && temp.next != null && temp.next.next != null) {
            // count += 2;
            // temp = temp.next.next;
            // }
            // If the current group is even-length, reverse it
            if (count > 0) {
                prev.next = reverseGroup(current, count);
            }
            // Move the pointers to the next group
            while (count > 0) {
                prev = prev.next;
                current = current.next;
                count -= 2;
            }
        }

        return dummy.next;
    }

    private static ListNode reverseGroup(ListNode head, int count) {
        ListNode prev = null;
        ListNode current = head;
        while (count > 0) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
            count--;
        }
        head.next = current; // Link the reversed group with the rest of the list
        return prev; // Return the new head of the reversed group
    }
}
