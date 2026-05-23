package DSASheet.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class PalindromeList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        boolean palin = palindrome(head);
        System.out.println(palin);
    }
    private static boolean palindrome(ListNode head){
//        brute
        //Store all node values into list/ArrayList
        // Use left and right pointer to compare
        // Traverse list
        // Add node values to the list
        // left = 0, right = values.size() - 1
        // compare values[left] != values[right]
        // if it is mismatch false
        // else move
        // left++
        // right--
        // all match return true
        // T.C : o(n)
        // S.C : o(n)
        List<Integer> values = new ArrayList<>();

        ListNode curr = head;

        while(curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        int left = 0;
        int right = values.size() - 1;

        while(left < right) {
            if(!values.get(left).equals(values.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
        //optimized
        // Compute middle
        // reverse the second
        // compare first half and second half reversed
        // initialize two pointers
        // slow pointer
        // fast pointer
        // Traverse list
        // slow = slow.next
        // fast = fast.next.next
        // Reverse the second half
        // curr = head
        // prev = null
        // while curr != null :
        // next = curr.next
        // curr.next = prev
        // prev = curr
        // curr = next
        // while second != null:
        // if first.val != second.val
        // return false
        // first = first.next
        // second = second.next
        // return true
        // T.C: o(n)
        // S.C: o(1)
        // first = head
        // second = prev
//        if(head == null && head.next == null) {
//            return true;
//        }
//
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while(fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        ListNode prev = null;
//        ListNode curr = slow;
//        while(curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//
//        ListNode first = head;
//        ListNode second = prev;
//        while(second != null) {
//            if(first.val != second.val) {
//                return false;
//            }
//            first = first.next;
//            second = second.next;
//        }
//
//        return true;
    }
}
