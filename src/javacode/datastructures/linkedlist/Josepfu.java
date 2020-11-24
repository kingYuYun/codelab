package javacode.datastructures.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);
        circleSingleLinkedList.showBoy();

        circleSingleLinkedList.countBoy(10,20,125);
    }
}

class CircleSingleLinkedList {
    private Boy first = new Boy(-1);

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums is error");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);//curboy.next->boy
                boy.setNext(first);//boy.next->first
                curBoy = boy;
            }
        }
    }

    //bianli
    public void showBoy() {
        if (first == null) {
            System.out.println("null");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.printf("curBoy.getNo: %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            } else {
                curBoy = curBoy.getNext();
            }
        }

    }

    //push data
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("null");
            return;
        }
        Boy helper=first;
        while (true){
            if (helper.getNext()==first){
                 break;
            }
            helper=helper.getNext();
        }
        for (int j = 0; j < startNo - 1; j++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        while (true){
            if (helper==first){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("boy out %d\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("last boy %d\n ",first.getNo());
    }

}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}