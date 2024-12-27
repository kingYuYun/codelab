package swordoffer;

public class jz76 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static String listNodeToString(ListNode head)
    {
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
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println(listNodeToString(deleteDuplication(node1)));
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return pHead;
        ListNode res = new ListNode(0);
        res.next = pHead;
        ListNode tail = res;
        while (tail.next!=null && tail.next.next!=null) {
            if (tail.next.val == tail.next.next.val) {
                int val = tail.next.val;
                while (tail.next!=null && tail.next.val == val) {
                    tail.next = tail.next.next;
                }
            } else {
                tail = tail.next;
            }

        }
        return res.next;
    }
}
