package swordoffer;

public class maxcomdivisor {
    static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(18);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(10);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        System.out.println(insertGreatestCommonDivisors(node1));
    }

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode p = head;
        while (p.next != null) {
            int a = p.val;
            int b = p.next.val;
            int c = gcd(a, b);
            ListNode node = new ListNode(c);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        return head;
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
