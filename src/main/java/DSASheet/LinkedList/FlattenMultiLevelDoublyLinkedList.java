package DSASheet.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class FlattenMultiLevelDoublyLinkedList {
    public static void main(String args[]) {
        Nodef one = new Nodef(1);
        Nodef two = new Nodef(2);
        Nodef three = new Nodef(3);
        Nodef four = new Nodef(4);
        Nodef five = new Nodef(5);
        Nodef six = new Nodef(6);
        Nodef seven = new Nodef(7);
        Nodef eight = new Nodef(8);
        Nodef nine = new Nodef(9);
        Nodef ten = new Nodef(10);
        Nodef eleven = new Nodef(11);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        three.child = seven;
        seven.next = eight;
        eight.child = eleven;


        four.child = ten;

        six.child = nine;

        Nodef nodes = flattenMultiLevel(one);

        Nodef curr = nodes;
        while(curr!=null) {
            System.out.print(curr.val + "->");
            curr=curr.next;
        }
        System.out.println("null");
    }
    private static Nodef flattenMultiLevel(Nodef head) {
        //brute
        // Use dfs and store nodes in list
        // visit current node
        // visit the child node first
        // visit after the child next
        // store this order in arrayList
        // Reconnect all nodes using prev/next
        // set curr.child = null
        // child list should come first before the original list node
        // T.C : o(n)
        // S.C : o(n)
//        if(head == null) return null;
//        List<Nodef> list = new ArrayList<>();
//        dfs(head, list);
//
//        for(int i=0; i<list.size(); i++) {
//            Nodef curr = list.get(i);
//            curr.prev = (i==0) ? null : list.get(i-1);
//            curr.next = (i==list.size()-1) ? null : list.get(i+1);
//            curr.child = null;
//        }
//
//        return list.get(0);
        //optimzied
        // do it in place
        // if curr.child exists :
        // save curr.next
        // connect curr -> child
        // find the tail of child list
        // connect tail -> saved next
        // set curr.child = null
        // T.C : o(n)
        // S.C : o(1)
        if(head == null) return null;

        Nodef curr = head;

        while (curr != null) {
            if(curr.child != null) {
                Nodef next = curr.next;
                Nodef child = curr.child;

                curr.next = child;
                child.prev = curr;
                curr.child = null;

                Nodef tail = child;
                while(tail.next != null) {
                    tail = tail.next;
                }
                tail.next = next;
                if(next != null) {
                    next.prev = tail;
                }
            }
            curr = curr.next;
        }

        return head;

    }
    private static void dfs(Nodef node, List<Nodef> list) {
        if(node == null) return;
        list.add(node);
        dfs(node.child, list);
        dfs(node.next, list);
    }
}
