package DSASheet.LinkedList;

public class Removenthnodefromendoflist {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        ListNode current = removenthnode(head, n);

        ListNode curr = current;

        while(curr !=null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

        System.out.println("null");
    }

    private static ListNode removenthnode(ListNode head, int n) {
        //brute
        // Count total nodes = length
        // if length == n , delete head, return head.next
        // else move to the node before target:
        // length - n - 1
        // skip target
        // curr.next = curr.next.next
        // return head
        // T.C : o(n)
        // S.C : o(1)
//        int length = 0;
//
//        ListNode curr = head;
//        while(curr != null) {
//            length++;
//            curr = curr.next;
//        }
//
//        if(length == n) {
//            return head.next;
//        }
//
//        curr = head;
//        for(int i=0; i<length - n - 1; i++) {
//            curr = curr.next;
//        }
//
//        curr.next = curr.next.next;
//
//        return head;
        //optimized
        // dummy + fast/slow pointer gaps
        // intitliazie new dummy list node
        // dummy.next  = head
        // intitlaze two pointer
        // slow
        // fast
        // move fast to n + 1 step
        // then move both
        // while fast != null :
        // slow = slow.next
        // fast = fast.next
        // when fast becaomes null slow is node before to delete
        // delete
        // slow.next = slow.next.next
        // return dummy.next
        // T.C : o(n)
        // S.C : o(1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i=0; i<n+1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
