package DSASheet.TwoPointersAndSlidingwindow;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RotateList {
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5};
        int k = 2;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for(int i=1; i<arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        ListNode updated = rotateList(head, k);
        ListNode temp = updated;

        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.val);
            if(temp.next != null) {
                System.out.print(",");
            }
            temp = temp.next;
        }
        System.out.println("]");
    }

    private static ListNode rotateList(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return  head;
        }

        ListNode temp = head;
        int n = 1;
        while(temp.next != null) {
            temp = temp.next;
            n++;
        }

        k = k % n;
//        if(k ==0) {
//            return head;
//        }
//
//        temp.next = head;
//
//        ListNode newTail = head;
//
//        for(int i=0; i<n-k-1; i++) {
//            newTail = newTail.next;
//        }
//
//        ListNode newHead = newTail.next;
//        newTail.next = null;
//
//        return newHead;
        for(int i=0; i<k; i++) {
            ListNode prev = null;
            ListNode curr = head;

            while(curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            curr.next = head;
            prev.next = null;
            head = curr;
        }
        return head;
    }
}
