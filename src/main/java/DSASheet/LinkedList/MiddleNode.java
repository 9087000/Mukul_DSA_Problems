package DSASheet.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class MiddleNode {
    public static void main(String[] args) {
        ListNode  node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode middle = middleNode(node);

        ListNode curr = middle;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }
    private static ListNode middleNode(ListNode head) {
        //brute
        //Count total nodes first
        // Move the count/2 steps
        // count nodes
        // count  = 0
        // curr ! = null
        // count++
        // curr = curr.next
        // find the middle index
        // int middleIndex = count / 2
        // move the middleIndex steps
        // curr = curr.next
        // return curr middle index
        // return curr
        // T.C : o(n)
        // S.C : o(n)
          int count = 0;
          ListNode curr = head;
          while (curr != null) {
              count++;
              curr = curr.next;
          }

          int middleIndex = count / 2;
          curr = head;
          for(int i=0; i<middleIndex; i++) {
              curr = curr.next;
          }

          return curr;
          //optimized
          // Initialize
          // slow pointer
          // Fast Pointer
          // slow = head
          // fast = head
          // slow = slow.next
          // fast = fast.next.next
          // While fast != null and fast.next != null
          // fast can move twice as possible
          // then
          // slow reach middle
          // return slow
          // T.C : o(n)
          // S.C : o(1)
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while(fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return slow;
    }
}
