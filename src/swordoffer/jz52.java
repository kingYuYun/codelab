package swordoffer;

public class jz52 {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static String listNodeToString(ListNode head) {
        if (head == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;


        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(5);
        ListNode node13 = new ListNode(6);
        ListNode node14 = new ListNode(7);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        node3.next = node13;


        System.out.println(listNodeToString(FindFirstCommonNode(node1, node11)));
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null) ? pHead2 : p1.next;
            p2 = (p2 == null) ? pHead1 : p2.next;
        }
        return p1;
    }

}
