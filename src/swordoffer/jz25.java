package swordoffer;

public class jz25 {

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node3;
        node3.next = node5;

        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        node11.next = node12;
        node12.next = node13;

        System.out.println(listNodeToString(node1));
        System.out.println(listNodeToString(node11));

        ListNode listNode = Merge(node1, node11);
        System.out.println(listNodeToString(listNode));
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

    public static ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        // 创建一个虚拟头节点，方便处理
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                temp.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                temp.next = pHead2;
                pHead2 = pHead2.next;
            }
            temp = temp.next;
        }
        temp.next = pHead1 == null ? pHead2 : pHead1;
        return dummy.next;
    }

}
