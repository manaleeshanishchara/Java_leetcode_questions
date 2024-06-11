public class Linkedlist {
    public static class ListNode {
        int val;
        ListNode next;
        // ListNode prev;
        
        ListNode(int val) {
            this.val = val;
        }

        // public String toString() {
        //     return String.format("Node(%d, prev = %s)", val, prev);
        // }

        public String toString() {
            // String prevVal = (prev == null) ? "null" : String.valueOf(prev.val);
            String nextVal = (next == null) ? "null" : String.valueOf(next.val);
            return String.format("Node(%d, next = %s)", val, nextVal);
        }
    }

    
    
    public static void main(String[] args) {


        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode head = node1;
        ListNode test = null;

        // head.next.next.next = null;

        while(head!=null){           
            System.out.println("head: "+(head == null ? "null" : head.toString()));
            head = head.next;
        }
        
        head = node1;

        ListNode newhead = removeNthFromEnd(head,2);

        // System.out.println("newhead: "+(newhead == null ? "null" : newhead.toString()));
            

        while(newhead!=null){           
            System.out.println("newhead: "+(newhead == null ? "null" : newhead.toString()));
            newhead = newhead.next;
        }


        System.exit(0);


        // System.out.println("test: "+(test == null ? "null" : test.toString()));

        // ListNode dummy = new ListNode(0);
        // dummy.next = head;

        // System.out.println(node1.toString());
        // System.out.println(node2.toString());
        // System.out.println(node3.toString());
        // System.out.println(node4.toString());
        // System.out.println(head.toString());
        // System.out.println(dummy.toString());

        // ListNode newhead = swapPairs(head);

        // System.out.println("node1: "+node1.toString());
        // System.out.println("head: "+head.toString());
        
        // ListNode newhead = head;
        // head.next = node3;
        // head.val = 7;
        // newhead.val = 9;

        // System.out.println();
        // System.out.println("node1: "+node1.toString());
        // System.out.println("head: "+head.toString());
        // System.out.println("newhead: "+newhead.toString());

        // System.out.println("-------------------------------------------------");


        // while(newhead!=null){           
            // System.out.println("newhead: "+(newhead == null ? "null" : newhead.toString()));
            // newhead = newhead.next;
        // }

        // System.out.println(node1.toString());
        // System.out.println(node2.toString());
        // System.out.println(node3.toString());
        // System.out.println(node4.toString());

        

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        
        ListNode fast = dummy;
        ListNode slow = dummy;

        System.out.println("fast: "+(fast == null ? "null" : fast.toString()));
        System.out.println("slow: "+(slow == null ? "null" : slow.toString()));

        
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return head; 
            }
            fast = fast.next;
        }

        System.out.println("fast: "+(fast == null ? "null" : fast.toString()));
        System.out.println("slow: "+(slow == null ? "null" : slow.toString()));


        
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println("fast: "+(fast == null ? "null" : fast.toString()));
        System.out.println("slow: "+(slow == null ? "null" : slow.toString()));

        
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static ListNode swapPairs(ListNode head) {
        // Create a dummy node to serve as the new head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize pointers for swapping
        ListNode prev = dummy;
        
        ListNode current = head;
        
        System.out.println("dummy: "+dummy.toString());
        System.out.println("prev: "+prev.toString());
        System.out.println("current: "+current.toString());
        System.out.println("HEAD: "+head.toString());

        // Traverse the list and swap pairs
        while (current != null && current.next != null) {
            // Nodes to be swapped
            ListNode firstNode = current;
            ListNode secondNode = current.next;
            
            System.out.println("\nwhile start\n");

            System.out.println("prev: "+prev.toString());
            System.out.println("firstNode: "+firstNode.toString());
            System.out.println("secondNode: "+secondNode.toString());
            System.out.println("current: "+(current == null ? "null" : current.toString()));


            System.out.println();
            
            // Swap the nodes
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            System.out.println("prev: "+prev.toString());
            System.out.println("firstNode: "+firstNode.toString());
            System.out.println("secondNode: "+secondNode.toString());
            
            // Move pointers to the next pair
            prev = firstNode;
            current = firstNode.next;

            System.out.println();
            System.out.println("prev: "+prev.toString());
            System.out.println("current: "+(current == null ? "null" : current.toString()));
            
            System.out.println("HEAD: "+head.toString());
            // System.exit(0);

            // ListNode testhead = head;
            // System.out.println("head: "+head.toString());            

            // while(testhead!=null){    
            //     System.out.println("testhead: "+(testhead == null ? "null" : testhead.toString()));    
            //     testhead = testhead.next;
            // }
            // System.out.println();


        }
        
        // Return the new head
        return dummy.next;
    }
}


/*
 
ListNode[] A = new ListNode[100];
        ListNode head = A[0];
        System.out.println(head);
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }

        System.out.println(t);
        
        System.out.println(A.toString());


        // Create nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        
        // Connect nodes
        node1.prev = null;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = null;
        
        // Print values using iteration
        ListNode current = node1;
        while (current != null) {
            System.out.println(current.val);
            // System.out.println(current.next);
            // System.out.println("current.prev"+current.prev);
            // System.out.println("current.next"+current.next);
            
            System.out.println(current.toString());
            current = current.next;
        }



        try{
          } catch (Exception ex) {

          }
 */