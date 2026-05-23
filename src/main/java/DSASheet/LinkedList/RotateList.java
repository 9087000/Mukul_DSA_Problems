package DSASheet.LinkedList;

public class RotateList {
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode rotate = rotateList(head, k);
        ListNode curr = rotate;

        while(curr != null) {
            System.out.print(curr.val + "->");
            curr=curr.next;
        }
        System.out.println("null");
    }

    private static ListNode rotateList(ListNode head, int k) {
        //brute
        //Take last nodes to front
        // Two pointers:
        // We use two pointer
        // Last node:
        // because it beacomes new head
        // lastNode = head
        // secondLastNode:
        //  after last node removed
        // 4.next = null
        // the cycle forms
        // initially pointers
        // secondLast = head
        // last = head.next
        // move last
        // while(last.next != null)
        // secondLast = last
        // last = last.next
        // until
        // last.next = null
        // Cut the old connection
        // second.next = null
        // Attach or move the last node to front
        // last.next = head
        // head = last
        // return head
        // T.C : o(n * k)
        // S.C : o(1)
//        if(head == null || head.next == null) {
//            return head;
//        }
//        ListNode secondLast = head;
//        ListNode last = head.next;
//
//        while (last.next != null) {
//            secondLast = last;
//            last = last.next;
//        }
//
//        secondLast.next = null;
//        last.next = head;
//        head = last;
//        return head;
        //optimized
        //instead of rotating one by one
        // we can track directly where the head is
        // Find length and tail
        // int length = 1
        // tail = head
        // Traverse the list once because
        //  tail.next = head
        // while(tail.next != null) :
        // tail = tail.next
        // length++
        // Reduce the rotations
        // k = k % length
        // if(k == 0):
        // return head
        // Make circular list and find tail
        // newTail = head
        // length - k - 1
        // newTail = tail.next
        //  break cycle
        // newTail.next = null
        // return newHead
        // T.C : o(n)
        // S.C : o(1)
        if(head==null|| head.next==null || k==0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        while(tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if(k==0) {
            return head;
        }
        tail.next = head;
        ListNode newTail = head;
        for(int i=0; i<length-k-1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;

    }
}
