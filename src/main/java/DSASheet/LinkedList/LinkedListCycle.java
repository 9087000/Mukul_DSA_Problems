package DSASheet.LinkedList;

import java.util.HashSet;
import java.util.List;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNodeCycle head = new ListNodeCycle(3);
        head.next = new ListNodeCycle(2);
        head.next.next = new ListNodeCycle(0);
        head.next.next.next = new ListNodeCycle(-4);
        head.next.next.next.next = head.next;

        boolean nextCycle = linkedlistCycle(head);

        System.out.println(nextCycle);
    }

    private static boolean linkedlistCycle(ListNodeCycle head) {
        //optimized
        // Initialize two pointer
        // slow pointer i.e slow
        // fast pointer i.e fast
        // Traverse
        // while(fast != null and fast.next != null)
        // Move the nodes
        // slow = slow.next
        // fast = fast.next.next
        // fast can safely move next 2 steps
        // fast can move quickly than slow
        // inside cycle
        // fast can catch quickly the slow
        // meeting point
        // slow == fast
        // no cycle
        // slow = head
        // fast = head
        // while fast != null and fast.next != null
        // slow = slow.next
        // fast = fast.next.next
        // if(slow == fast)
        // return true
        // return false
        // T.C : o(n)
        // S.C : o(1)
        ListNodeCycle slow = head;
        ListNodeCycle fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        if(slow==fast) {
            return true;
        }
        }

        return false;
        //brute
        //If the node appears again
        // cycle exists
        // Store the visited nodes in the
        // hash set
        // create hashset
        // start traversal
        // Traverse the list
        //  check if node is visited again
        // add the curr node
        // move forward
        // no cycle
        // HashSet<ListNode> set = new HashSet<>();
        // curr = head
        // while curr ! = null :
        // if(set.contains(curr))
        // return true
        // set.add(curr);
        // curr = curr.next
        // return false;
        // T.C : o(n)
        // S.C : o(n)
//        HashSet<ListNodeCycle> set = new HashSet<>();
//
//        ListNodeCycle curr = head;
//
//        while (curr != null) {
//            if(set.contains(curr)) {
//                return true;
//            }
//            set.add(curr);
//            curr = curr.next;
//        }
//
//        return false;
    }
}
