package swordoffer;

import java.util.HashMap;
import java.util.Map;

public class jz35 {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    Map<RandomListNode, RandomListNode> createNode = new HashMap<RandomListNode, RandomListNode>();
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        if (!createNode.containsKey(pHead)){
            RandomListNode headNew= new RandomListNode(pHead.label);
            createNode.put(pHead,headNew);
            headNew.next=Clone(pHead.next);
            headNew.random=Clone(pHead.random);
        }
        return createNode.get(pHead);
    }
    public static void main(String[] args) {
    }

}
