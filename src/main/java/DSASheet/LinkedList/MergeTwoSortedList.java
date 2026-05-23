package DSASheet.LinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode mergeList = mergeLists(list1, list2);

        ListNode curr = mergeList;

        while(curr != null) {
            System.out.print(curr.val + "->");
            curr =curr.next;
        }
        System.out.println("null");
    }
    private static ListNode mergeLists(ListNode list1, ListNode list2) {
        //brute
        // Take all values -> sort -> build new LinkedList
        // store values from list1
        // store values from list2
        // sort the values
        // build the new linked list
        // ArrayList<Integer> values -= new ArrayList<>();
        // while(list1 != null) :
        // values.add(list1.val)
        // list1 = list1.next
        // while(list2 != null) :
        // value.add(list2.val)
        // list2 = list2.next
        // Collections.sort(values)
        // dummy = new ListNode(0)
        // tail = dummy
        // for value in values
        // tail.next = new ListNode(value)
        // return dummy.next
        // T.C: o((n+m)\log(n+m))
        // S.C : o(n+m)
//        ArrayList<Integer> values = new ArrayList<>();
//
//        while(list1 != null) {
//            values.add(list1.val);
//            list1 = list1.next;
//        }
//        while(list2 != null) {
//            values.add(list2.val);
//            list2 = list2.next;
//        }
//
//        Collections.sort(values);
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
        // Both list are sorted
        // compare the list nodes and attach smaller one
        // create dummy and tail
        // traverse
        // compare list node
        // compare again
        // move tail
        // continue
        // continue
        // Attach remaining list
        // dummy = new ListNode(0)
        // tail = dummy
        // while list1 != null and list2 != null:
        // if list1.val <= list2.val:
        // tail.next = list1
        // list1 = list.next
        // else :
        // tail.next = list2
        // list2 = list2.next
        // tail = tail.next
        // if(list1!=null)
        // tail.next = list1
        // if(list2!=null)
        // tail.next = list2
        // return dummy.next
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if(list1 != null) {
            tail.next = list1;
        }
        if(list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
}
