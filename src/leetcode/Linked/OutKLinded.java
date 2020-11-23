package leetcode.Linked;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class OutKLinded {
    public void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = FindKthToTail(a, 5);
        while (e != null) {
            System.out.println(e.val);
            e = e.next;
        }
    }
    public ListNode FindKthToTail(ListNode head, int k) {
        // �������Ϊ�ջ���kС�ڵ���0
        if (head == null || k <= 0) {
            return null;
        }
        // ��������ָ��ͷ���Ľڵ�
        ListNode node1 = head, node2 = head;
        // ��¼�ڵ�ĸ���
        int count = 0;
        // ��¼kֵ������Ҫʹ��
        int index = k;
        // pָ�����ܣ����Ҽ�¼�ڵ�������node1�ڵ�����k-1���ڵ��node2�ڵ㿪ʼ�ܣ�
        // ��node1�ڵ��ܵ����ʱ��node2�ڵ���ָ�Ľڵ���ǵ�����k���ڵ�
        while (node1 != null) {
            node1 = node1.next;
            count++;
            if (k < 1) {
                node2 = node2.next;
            }
            k--;
        }
        // ����ڵ����С������ĵ�����k���ڵ㣬�򷵻ؿ�
        if (count < index)
            return null;
        return node2;

    }
}


