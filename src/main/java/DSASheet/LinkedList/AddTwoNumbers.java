package DSASheet.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode add = addNumbers(l1, l2);

        ListNode curr = add;

        while (curr!=null) {
            System.out.print(curr.val + "->");
            curr =curr.next;
        }

        System.out.println("null");
    }

    private static ListNode addNumbers(ListNode l1, ListNode l2) {
        //brute
        // Convert l1 to number
        // convert l2 to number
        // Add the both
        // convert the number sum into  list
        // num1 = 0;
        // place = 1
        // while(l1 != null) :
        // num1+=l1.val * place
        // place*=10
        // l1=l1.next
        // place = 1
        // num2 = 0
        // while(l2 != null) :
        // num2+=l2.val * place
        // place*=10
        // l2=l2.next
        // sum = num1 + num2
        // dummy = new ListNode(0)
        // dummy = tail
        // if(sum == 0):
        // return new ListNode(0)
        // while(sum > 0) :
        // int digit = (int) sum % 10
        // sum = sum / 10
        // tail.next = new ListNode(digit)
        // tail = tail.next
        // dummy.next
        // T.C : o(n + m)
        // S.c: o(max(n,m)) for the list
//        long num1 = 0;
//        long num2 = 0;
//        long place = 1;
//
//        while(l1 != null) {
//            num1+=l1.val * place;
//            place*=10;
//            l1 = l1.next;
//        }
//
//        place = 1;
//
//        while(l2 != null) {
//            num2+=l2.val * place;
//            place*=10;
//            l2 = l2.next;
//        }
//
//        long sum = num1 + num2;
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        if(sum == 0) {
//            return new ListNode(0);
//        }
//
//        while(sum > 0) {
//            int digit = (int) sum % 10;
//            sum = sum / 10;
//
//            tail.next = new ListNode(digit);
//            tail = tail.next;
//        }
//
//        return dummy.next;
        //optimized
        // do the digit-by-digit addtion directly
        // Do not convert the list into number
        // sum = l1.digit + l2.digit + carry
        // digit = sum % 10
        // carry = sum / 10
        // dummy = listnode(0)
        // tail = dummy
        // carry = 0
        // while l1!= null || l2!=null || carry!=0:
        // sum = carry
        // if l1!=null
        // sum+=l1.val
        // l1= l1.next
        // if l2!=null
        // sum+=l2.val
        // l2=l2.next
        // digit = sum % 10
        // carry = sum / 10
        // tail.next = listNode(digit)
        // tail = tail.next
        // return dummy.next
        // T.C : o(max(n,m))
        // S.C : o(max(n,m)) for the list
        // in interview asks without space means
        // S.C : o(1)

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if(l1!=null) {
                sum+=l1.val;
                l1=l1.next;
            }

            if(l2!=null) {
                sum+=l2.val;
                l2 = l2.next;
            }

            int digit = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode(digit);
            tail = tail.next;
        }

        return dummy.next;
    }
}
