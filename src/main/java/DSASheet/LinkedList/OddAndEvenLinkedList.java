package DSASheet.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class OddAndEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode oddEven = oddEvenList(head);

        ListNode curr = oddEven;

        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

        System.out.println("null");
    }

    private static ListNode oddEvenList(ListNode head) {
        //brute
        //create Lists
        // oddValues = new ArrayList<>();
        // evenValues = new ArrayList<>();
        // Traverse list
        // position = 1
        // curr = head
        // while(curr!=null):
        // if(position%2==1):
        // add oddValues oddValues.add(curr.val)
        // else:
        // add evenValues evenValues.add(curr.val)
        // curr = curr.next
        // position++
        // combine both
        // oddValues.addAll(evenValues);
        // Creeate new LinkedList
        // dummy = new ListNode(0)
        // tail = dummy
        // for(value: oddValues):
        // tail.next = new ListNode(value)
        // tail = tail.next
        // dummy.next
        // T.C : o(n)
        // S.C : o(n)
//        List<Integer> oddValues = new ArrayList<>();
//        List<Integer> evenValues = new ArrayList<>();
//
//        int position = 1;
//
//        ListNode curr = head;
//
//        while(curr != null) {
//            if(position%2 == 1) {
//                oddValues.add(curr.val);
//            } else {
//                evenValues.add(curr.val);
//            }
//
//            curr = curr.next;
//            position++;
//        }
//
//
//        oddValues.addAll(evenValues);
//
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//
//        for(int value : oddValues) {
//            tail.next = new ListNode(value);
//            tail = tail.next;
//        }
//
//        return dummy.next;

        //optimized
        // instead of creating and storing in lists rearrange by moving poitner directly
        // dont use extra lists
        // seperate odd node position and even node position by changing links
        // check head == null
        // return head
        // odd = head
        // even = head.next
        // evenHead = even
        // while(even != null && even.next != null) :
        // odd.next = even.next
        // odd = odd.next
        // even.next = odd.next
        // even = even.next
        // odd.next = evenHead
        // return head
        // T.C : o(n)
        // S.C : o(1)
        if(head == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;

            odd.next = evenHead;
        }

        return head;

    }
}
