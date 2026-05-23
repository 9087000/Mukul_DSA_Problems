package DSASheet.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        reoderList(head);

        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

        System.out.println("null");

    }

    private static void reoderList(ListNode head) {
        //brute
        // Store all nodes into arrayList
        // Use two pointer:
        // left = start
        // right = end
        // Connect alternatively
        // left node
        // right node
        // return the last node next = null
        //Intialize list
        // Traverse list
        // Add the nodes to list
        // ListNode curr = head
        // while(curr != null) :
        // list.add(curr)
        // curr = curr.next
        // intialize two pointer
        // left = 0
        // right = list.size() - 1
        // save next node
        // nodeLeft = list.get(left).next
        // connect left -> right
        // list.get(left).next = list.get(right)
        // Move left
        // left++
        // if it is same node again
        // if(left == right)
        // break
        // connect right->nodeLeft
        // list.get(right).next = list.get(right)
        // move right
        // right--
        // list.get(left).next = null
        // T.C : o(n)
        // S.C : o(n)
//        List<ListNode> list = new ArrayList<>();
//
//        ListNode Curr = head;
//        while(Curr != null) {
//            list.add(Curr);
//            Curr = Curr.next;
//        }
//        int left = 0;
//        int right = list.size() - 1;
//
//        while(left < right) {
//            ListNode nextLeft = list.get(left).next;
//            list.get(left).next = list.get(right);
//            left++;
//            if(left == right) {
//                break;
//            }
//
//            list.get(right).next = list.get(left);
//            right--;
//        }
//
//        list.get(left).next = null;
        //optimized
        // Find middle
        // reverse the second part
        // merge the both havles alternatively
        // store the next nodes first
        // connect
        // move pointers
        // middle = mid (head)
        // use slow and fast pointer
        // second = middle.next
        // middle.next = null
        // reverse the second half
        // second = reverse(head)
        // classic reverse list
        // first = head
        // while(second != null) :
        // temp1 = first.next
        // temp2 = second.next
        // first.next = second
        // second.next = temp1
        // first = temp1
        // second = temp2
        // T.C : o(n)
        // S.C : o(1)
        ListNode middle = middle(head);

        ListNode second = middle.next;
        middle.next = null;
        second = reverse(second);

        ListNode first = head;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

    }

    private static ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
