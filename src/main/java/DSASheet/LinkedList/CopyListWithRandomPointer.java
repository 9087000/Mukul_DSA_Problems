package DSASheet.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public static void main(String args[]) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node copy = copyList(n1);

        Node curr = copy;

        while(curr!= null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;

            System.out.print("node" + curr.val + "random" + randomVal);

            curr=curr.next;
        }
    }

    private static Node copyList(Node head) {
        //brute
        // Each node has
        // val
        // next
        // random
        // Need to create the deep copy of the list
        // Original node -> copied node
        // Traverse list
        // initialize map
        // Map<Node, Node> map = new HashMap<>();
        // curr = head
        // while(curr != null) :
        // map.put(curr, new Node(curr.val))
        // curr = curr.next
        // Node is created and stored not connected
        // connect next and random pointer
        // curr = head
        // while(curr != null)
        // copy = map.get(curr)
        // curr.next = map.get(curr.next)
        // curr.random = map.get(curr.random)
        // curr = curr.next
        // return the copied head
        // map.get(head)
        // T.C : o(n)
        // S.C : o(n)
//        Map<Node, Node> map= new HashMap<>();
//
//        Node curr = head;
//
//        while(curr != null) {
//            map.put(curr, new Node(curr.val));
//            curr = curr.next;
//        }
//
//        curr = head;
//
//        while(curr != null) {
//            Node copy = map.get(curr);
//
//            copy.next = map.get(curr.next);
//            copy.random = map.get(curr.random);
//            curr = curr.next;
//
//        return map.get(head);

        //optimized
        // insert copied node in between originals
        //  insert copied node
        // curr = head
        // while(curr != null) :
        // copy = new Node(curr.val)
        // copy.next = curr.next
        // curr.next = copy
        // curr = copy.next
        // set random pointer
        // curr =head
        // while(curr != null):
        // if(curr.random != null):
        // curr.next.random = curr.random.next
        // curr = curr.next.next
        // seperate lists
        // curr = head
        // copyHead = head.next
        // while(curr != null) :
        // copy = curr.next
        // curr.next = copy.next
        // if(copy.next != null) :
        // copy.next = copy.next.next
        // curr = curr.next
        // return copyHead
        // T.C : o(n)
        // S.C : o(1)
        if(head == null) {
            return head;
        }
        Node curr = head;

        while(curr != null) {
            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        curr = head;

        while(curr != null) {

            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        curr = head;
        Node copyHead = head.next;
        while(curr != null) {

            Node copy = curr.next;

            curr.next = copy.next;

            if(copy.next != null) {
                copy.next = copy.next.next;
            }

            curr = curr.next;
        }

        return copyHead;
    }
}
