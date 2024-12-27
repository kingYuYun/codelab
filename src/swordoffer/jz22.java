package swordoffer;

public class jz22 {
    static class ListNode {
        int val;
        jz22.ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        //快慢指针解法
        if(pHead==null){return null;}
        ListNode p1=pHead;
        ListNode p2=pHead;
        for(int i=0;i<k;i++){
            if(p1==null){return null;}
            p1=p1.next;
        }
        while(p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
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
        jz22 jz22 = new jz22();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // 将链表转换为字符串并输出
        String result = listNodeToString(head);
        System.out.println(result); // 输出: 1 -> 2 -> 3
        String result2 = listNodeToString(jz22.FindKthToTail(head, 3));
        System.out.println(result2);
    }
}
