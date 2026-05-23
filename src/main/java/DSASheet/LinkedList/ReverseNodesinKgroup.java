package DSASheet.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesinKgroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode reverseK = reverseKgroup(head, k);

        ListNode curr = reverseK;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

        System.out.println("null");
    }

    private static ListNode reverseKgroup(ListNode head, int k) {
        //brute
        // Store all node values in arrayList
        // reverse the current node in k group
        // Reconnect  all the valid k size block
        // Rebuild the linkedList
        // initialize arrayList
        // values = new ArrayList<>()
        // curr = head
        // while(curr != null) :
        //  values.add(curr.val)
        // curr= curr.next
        // Reconnect valid k size block
        // for(int i=0; i<value.size(); i+=k) :
        // left = i
        // right = i + k - 1;
        // if(right>=values.size()):
        // break
        // while(left<right) :
        // int temp = values.get(left)
        // values.set(left, values.get(right))
        // values.set(right, temp)
        // left++
        // right--
        // build the linkedList
        // dummy = new ListNode(0)
        // tail = dummy
        // for(int value: values):
        // tail.next = new ListNode(value)
        // tail = tail.next
        // dummy.next
        // T.C : o(n)
        // S.C : o(n)
//        List<Integer> values = new ArrayList<>();
//
//        ListNode  curr = head;
//
//        while(curr != null) {
//            values.add(curr.val);
//            curr = curr.next;
//        }
//
//        for(int i=0; i<values.size(); i+=k) {
//            int left = i;
//            int right = i + k - 1;
//            if(right>=values.size()) {
//                break;
//            }
//            while(left < right) {
//                int temp = values.get(left);
//                values.set(left, values.get(right));
//                values.set(right, temp);
//
//                left++;
//                right--;
//            }
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
        // find the kth node
        // Reverse the current group
        // Reconnect the current group
        // Move to next group
        // Dummy node
        // find the kth node
        // reverse the current group
        // store the next node
        // start traversing
        // Reconnect
        // oldNode
        // old prev node
        // tail beacomes it end
        // connect node with prev pointer
        // T.C : o(n)
        // S.c: o(1)
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKth(groupPrev, k);

            if(kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while(curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = oldGroupStart;

        }

        return dummy.next;

    }

    private static ListNode getKth(ListNode head, int k) {
        ListNode curr = head;

        while (curr != null && k>0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
