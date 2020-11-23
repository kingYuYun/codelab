package yu.datastructures.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "songjiang", "jishuyu");
        HeroNode hero2 = new HeroNode(2, "lujunyi", "yuqiling");
        HeroNode hero3 = new HeroNode(3, "wuyong", "zhiduoxing");
        HeroNode newHeroNode = new HeroNode(3, "wuyong", "zhiduoxing1111111");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);

        singleLinkedList.list();

//        singleLinkedList.update(newHeroNode);
//        singleLinkedList.list();

//        singleLinkedList.delete(3);
//        singleLinkedList.list();

        System.out.println(getLength(singleLinkedList.getHead()));
        HeroNode res = findLastNode(singleLinkedList.getHead(), 3);
        System.out.println("res=   " + res);

//        reverseHeroNode(singleLinkedList.getHead());
//        singleLinkedList.list();

//        reversePrint(singleLinkedList.getHead());
//        singleLinkedList.list();
    }

    //reverse print
    public static void  reversePrint(HeroNode head){
        if (head.next==null){
            return;
        }
        Stack<HeroNode> stack=new Stack<HeroNode>();
        HeroNode cur=head.next;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    public static HeroNode findLastNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //reverse node
    public static void reverseHeroNode(HeroNode head) {
        if (head.next == null || head.next.next == null){
            return;
        }
        HeroNode cur=head.next;
        HeroNode next=null;
        HeroNode reverseHead=new HeroNode(0,"","");
        while (cur!=null){
            next=cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        head.next=reverseHead.next;
    }
}

//define Herohead
class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode hearNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = hearNode;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("list is null");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println("list:" + temp);
            temp = temp.next;
        }
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("exist");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("list is null");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.no == newHeroNode.no) {
                flag = true;
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
                System.out.println("finded");
            }
            temp = temp.next;
        }
        if (flag == false) {
            System.out.println("unfinded");
        }
    }

    //delete
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
            System.out.println("delete ");
        } else {
            System.out.println("no delete ");
        }
    }


}


//define HeroNode
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}