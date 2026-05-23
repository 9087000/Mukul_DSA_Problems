package DSASheet.LinkedList;

import java.util.HashSet;

public class IntersectionOfTwoLinkedList {
    public static void main(String[] args) {
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);
        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = common;

        ListNode listB = new ListNode(5);
        listB.next = new ListNode(6);
        listB.next.next = new ListNode(1);
        listB.next.next.next = common;

        ListNode inter = intersection(listA, listB);

        ListNode curr = inter;
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr= curr.next;
        }
        System.out.println("null");
    }

    private static ListNode intersection(ListNode listA, ListNode listB) {
        //brute
        //Store all node values of first list
        // check whether the second list values already exists
        // create a hashset
        // Store all node values from listA
        // Now set contains all node references from A
        // Traverse list B
        // check whether listB values already exisits
        // return node values
        // return null
        // T.C : o(n + m)
        // S.c : o(n)
        // HashSet<ListNode> set = new HashSet<>();
        // curr = listA
        // while(curr!=null)
        // set.add(curr)
        // curr = curr.next
        // curr = listB
        // while(curr!=null)
        //  if(set.contains(curr))
        // return curr
        // curr = curr.next
        // return null
//        HashSet<ListNode> set = new HashSet<>();
//
//        ListNode curr = listA;
//        while(curr!=null) {
//            set.add(curr);
//            curr = curr.next;
//        }
//
//        curr = listB;
//        while (curr != null) {
//            if(set.contains(curr)) {
//                return curr;
//            }
//
//            curr = curr.next;
//        }
//
//        return null;
        //optimized
        // Create two pointer
        // intialize p1 = listA
        // p2 = listB
        // Move both one step at a time
        // while (p1 != p2)
        // if p1=null send it to B
        // if p2 == null send it to A
        // return meeting point
        // if p1 and p2 intersect the node each then they meet here
        // if p1 and p2 does have intersection point then return null
        // p1 = listA
        // p2 = listB
        // while(p1 != p2) :
        // if(p1 == null)
        // p1 = listB
        // else
        // p1 = p1.next
        // if(p2 == null)
        // p2 = listA
        // else
        // p2 = p2.next
        // return p1
        // T.C : o(n + m)
        // S.C
        ListNode p1 = listA;
        ListNode p2 = listB;

        while (p1 != p2) {
            if(p1 == null) {
                p1 = listB;
            } else {
                p1 = p1.next;
            }

            if(p2==null) {
                p2= listA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;

    }

}
