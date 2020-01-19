package medium;

/**
 *
 */
public class AddTwoNumbers {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return null;
        }
        int next = 0;
        ListNode listNode =new ListNode(0);

        if (l1.next != null) {
            listNode.next = addTwoNumbers(l1.next, l2.next);
            next = listNode.next.val;
            listNode.next.val=next%10;
        }
        listNode.val =l1.val + l2.val + next / 10;
        return listNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        ListNode current = l1;
        for (int i = 7; i <= 9; i++) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = node;

        }

        ListNode l2 = new ListNode(3);
        ListNode current2 = l2;
        for (int i = 4; i <=6; i++) {
            ListNode node = new ListNode(i);
            current2.next = node;
            current2 = node;

        }
        ListNode listNode=addTwoNumbers(l1,l2);
        System.out.println("sffas");

    }


}
