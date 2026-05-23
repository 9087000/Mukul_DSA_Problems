package DSASheet.LinkedList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortList {
    public static void  main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode sort = sortList(head);

        ListNode curr = sort;

        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

        System.out.println("null");
    }

    private static ListNode sortList(ListNode head) {
        //brute
        // create the list
        // Traverse list
        // curr = head
        // while(curr!=null):
        // store the values
        // values.add(curr.val)
        // curr = curr.next
        // sort the list
        // collections.sort(values)
        // rebuild or create new List
        // dummy = new ListNode(0)
        // tail = dummy
        // for(int value: values) :
        // tail.next = new ListNode(value)
        // tail = tail.next
        // return dummy.next
        // T.C : o(n log n)
        // S.C : o(n)
//        List<Integer> values = new ArrayList<>();
//
//        ListNode curr = head;
//
//        while(curr != null) {
//            values.add(curr.val);
//            curr = curr.next;
//        }
//
//        Collections.sort(values);
//
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//
//        for(int value: values) {
//            tail.next = new ListNode(value);
//            tail = tail.next;
//        }
//
//        return dummy.next;

        //optimized
        // split the list into halves
        // sort both the halves
        // merge the sorted halves
        // base condition
        // if(head == null || head.next == null)
        // return head
        // beacuse list is empty or one node is already sorted
        // Find middle
        // slow = head
        // fast = head.next
        // because slow pointer goes back to previous middle which help to sort the values cleanly
        // split
        // rightHead = mid.next
        // mid.next = null
        // This is where one list is seperated into two list
        // sort
        // left = sort(head)
        // right = sort(rightHead)
        // sort it recursively
        // return merge
        // merge the two sort list same logic
        // T.C : o(n log n)
        // S.c : o(log n) for recursive stack
        if(head == null || head.next == null) {
            return head;
        }

        ListNode middle = middle(head);

        ListNode rightHead = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);


        return merge(left, right);
    }

    private static ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return  slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(left != null && right != null) {
            if(left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }

            tail = tail.next;

            if(left!=null) {
                tail.next = left;
            }

            if(right != null) {
                tail.next = right;
            }
        }

        return dummy.next;
    }
}
