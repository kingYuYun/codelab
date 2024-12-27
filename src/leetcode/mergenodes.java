package leetcode;

public class mergenodes {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        System.out.println(listNodeToString(mergeNodes(node1)));
    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode dummy = head;
        ListNode p = head;
        while (p.next != null) {
            int sum = 0;
            while (p.next != null && p.next.val != 0) {
                sum += p.next.val;
                p = p.next;
            }
            if (p.next != null) {
                p.next.val = sum;
                p = p.next;
                dummy.next = p;
                dummy= dummy.next;
            }
        }
        return head.next ;
    }
}
