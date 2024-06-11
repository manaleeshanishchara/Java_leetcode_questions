import java.util.Arrays;
import java.io.*;
import java.util.*;

public class Example {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        // ListNode(int val) {
        // this.val = val;
        // }

        ListNode(int val, ListNode prev) {
            this.val = val;
            this.prev = prev;
        }

        // constructor and getter/setter omitted
        // overridding toString() to print name
        public String toString() {
            // String.format("Node(%d, prev = %s)", val, prev);
            return String.format("Node(%d, prev = %s)", val, prev);
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1, null);
        ListNode two = new ListNode(2, one);
        // ListNode three = new ListNode(3, two);
        // ListNode four = new ListNode(4, three);
        one.next = two;
        // two.next = three;
        // three.next = four;
        // ListNode head = one;

        System.out.println(one.toString());
        // System.out.println(head.val);
        // System.out.println(head.next.val);
        // System.out.println(head.next.next.val);
        // System.out.println(head.next.next.next.val);

    }
}