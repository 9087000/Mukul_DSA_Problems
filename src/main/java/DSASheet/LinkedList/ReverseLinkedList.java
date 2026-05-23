package DSASheet.LinkedList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode node = reverseLinked(head);
        ListNode curr = node;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

        System.out.println("null");
    }

    private static ListNode  reverseLinked(ListNode head) {
        //brute
        // Create a list
        // store the list values
        // Reverse the list values
        // Traverse the list values again
        // replace the list values
        // T.C : o(n)
        // S.C : o(n)
        List<Integer> values = new ArrayList<>();

        ListNode curr = head;
        while(curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        Collections.reverse(values);
        curr = head;
        int index = 0;
        while(curr != null) {
            curr.val = values.get(index);
            index++;
            curr = curr.next;
        }

        return head;
        //Optimized
        // Prev = null
        // curr = head
        // Loop untill curr beacome end
        // while ( curr != null)
        // save the next node
        // next = curr.next
        // we change the curr.next, but we should not lose the remaining list
        // Reverse all the links
        // curr.next = prev
        // This reverse one node
        // Move prev node
        // prev = curr
        //  Now this becomes part of reversed link
        // Move curr node
        // curr = next
        // continue with reamining list
        // T.C : o(n)
        // S.C: o(1)
//       ListNode prev = null;
//       ListNode curr = head;
//
//       while (curr != null) {
//           ListNode next = curr.next;
//           curr.next = prev;
//           prev = curr;
//           curr = next;
//       }
//
//       return prev;
    }
}
