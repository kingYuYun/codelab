package leetcode.Linked;


public class deletelinked {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode listNode = removeNthFromEnd(a, 1);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // ��������ָ��ͷ���Ľڵ�
        ListNode node1 = dummy, node2 = dummy;

        // node1 �ڵ����ܣ�node1�ڵ� �ܵ��� n ���ڵ��ʱ��,node2 �ڵ㿪ʼ��
        // ��node1 �ڵ��ܵ����һ���ڵ�ʱ��node2 �ڵ����ڵ�λ�þ��ǵ� ��L-n �� ���ڵ㣬Ҳ���ǵ����� n+1��L�����������ȣ�
        while (node1 != null) {
            node1 = node1.next;
            if (n < 1 && node1 != null) {
                node2 = node2.next;
            }
            n--;
        }
        node2.next = node2.next.next;

        return dummy.next;
    }

}

