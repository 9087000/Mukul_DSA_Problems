package DSASheet.Heap;


import java.util.*;

/**
* Defenition of Singly Linked List
 **  public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val;}
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next;}
 *}
 */

public class MergeKLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] nodes = {node1, node2, node3};

        ListNode node = mergeKLists(nodes);

        ListNode curr = node;

        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }

        System.out.print("null");
    }

    private static ListNode mergeKLists(ListNode[] node) {
        //brute
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for(ListNode head : node) {
//            ListNode curr = head;
//
//            while(curr != null) {
//                list.add(curr.val);
//                curr = curr.next;
//            }
//        }
//
//        Collections.sort(list);
//
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//
//        for(int val : list) {
//             tail.next = new ListNode(val);
//             tail = tail.next;
//        }
//
//        return  dummy.next;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode nodes : node) {

            if(nodes!= null) {
                pq.offer(nodes);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()) {
            ListNode node1 = pq.poll();

            tail.next = node1;
            tail = tail.next;

            if(node1.next != null) {
                pq.offer(node1.next);
            }
        }

        return dummy.next;
    }
}
