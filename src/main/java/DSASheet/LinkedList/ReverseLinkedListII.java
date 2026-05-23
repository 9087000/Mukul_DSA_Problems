package DSASheet.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedListII {
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;

        ListNode reverse = reverseList(head, left, right);

        ListNode curr = reverse;

        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

        System.out.println("null");
    }

    private static ListNode reverseList(ListNode head, int left, int right) {
        //brute
        // store all node values in arrayList
        // reverse the node values from left-1 to right-1 nodes
        // Rebuild the linkedlist or create new LinkedList
        // values = new ArrayList<>();
        // curr =head
        // while(curr != null) :
        // values.add(curr.val);
        // curr = curr.next
        // while(left < right):
        // temp = values.get(left-1)
        // values.set(left-1, values.get(right-1))
        // values.set(right-1, temp)
        // left++
        // right--
        // dummy = new ListNode(0)
        // tail = dummy
        // for(int value:values) :
        // tail.next = new ListNode(value)
        // tail = tail.next
        // return dummy.next
        // T.C : o(n)
        // S.C : o(n)
//        List<Integer> values  = new ArrayList<>();
//
//        ListNode curr = head;
//        while(curr!=null) {
//            values.add(curr.val);
//            curr= curr.next;
//        }
//
//        while(left<right) {
//            int temp = values.get(left-1);
//            values.set(left-1, values.get(right-1));
//            values.set(right-1, temp);
//
//            left++;
//            right--;
//        }
//
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//
//        for(int value:values) {
//            tail.next = new ListNode(value);
//            tail = tail.next;
//        }
//
//        return dummy.next;
        //optimized
        // Move the prev node before left
        // Reverse only right - left + 1 node
        // Reconnect before and after parts
        // prev = node before left
        // curr = first node to reverse
        // subnodeTail = original left node
        // reverse = previous pointer during reverse
        // dummy = new ListNode(0)
        // dummy.next = head
        // prev = dummy
        // for(int i=1; i<left; i++) :
        // prev = prev.next
        // curr = prev.next
        // subNodeTail = curr
        // prevreverse = prev
        // reverse = null
        // for(int i=0; i<right-left+1; i++) :
        // next = curr.next
        // curr.next = reverse
        // reverse = curr
        // curr = next
        // prevreverse.next = reverse
        // subNodeTail.next = curr
        // return dummy.next
        // T.C : o(n)
        // S.C : o(1)
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for(int i=1; i<left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode subNodeTail = curr;

        ListNode beforePrevreverse = prev;
        ListNode reverse = null;

        for(int i=0; i<right-left+1; i++) {
            ListNode next = curr.next;
            curr.next = reverse;
            reverse = curr;
            curr = next;
        }

        beforePrevreverse.next = reverse;
        subNodeTail.next = curr;

        return dummy.next;
    }
}
