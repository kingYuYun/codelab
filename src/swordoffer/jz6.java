package swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class jz6 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

/*    方法一：使用递归
    递归方法通过先递归到链表的末尾，然后在回溯的过程中将节点值添加到结果列表中。*/
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        List<Integer> result = new ArrayList<>();
        reversePrintHelper(listNode, result);
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        ArrayList<Integer> out = new ArrayList<>(Arrays.stream(output)
                .boxed()
                .collect(Collectors.toList()));
        return out;
    }

    private void reversePrintHelper(ListNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        reversePrintHelper(node.next, result);
        result.add(node.val);
    }

/*    方法二：使用栈
    栈是一种后进先出（LIFO）的数据结构，可以用来实现从尾到头的顺序。*/
public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
    ArrayList<Integer> result = new ArrayList<>();
    ListNode cur = listNode;
    Stack<Integer> stack = new Stack<>();
    while (cur != null) {
        stack.push(cur.val);
        cur = cur.next;
    }
    while (!stack.isEmpty()) {
        result.add(stack.pop());
    }
    return result;
}

    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp!=null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

    public static void main(String[] args) {
        jz6 solution = new jz6();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        ArrayList<Integer> result = solution.printListFromTailToHead(head);
//        ArrayList<Integer> result = solution.printListFromTailToHead2(head);
        ArrayList<Integer> result = solution.printListFromTailToHead3(head);
        System.out.println(result); // 输出: [3, 2, 1]

    }
}
