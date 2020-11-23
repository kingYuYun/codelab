package leetcode.test;

import java.util.Scanner;
public class tx2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node head1=null;
        Node tmp1=null;

        for (int i = 0; i < n; i++) {
            if (i==0){
                head1=new Node(sc.nextInt());
                tmp1=head1;
                continue;
            }

            Node newnode=new Node(sc.nextInt());
            tmp1.setNext(newnode);
            tmp1=tmp1.next;
        }
        Node head2=null;
        Node tmp2=null;
        int m=sc.nextInt();
        for (int i = 0; i < m; i++) {
            if (i==0){
                head2=new Node(sc.nextInt());
                tmp2=head2;
                continue;
            }
            Node newnode=new Node(sc.nextInt());
            tmp2.setNext(newnode);
            tmp2=tmp2.next;
        }
        while (head1!=null && head2!=null){
            if (head1.value>head2.value){
                head1= head1.next;
            }else if (head1.value<head2.value){
                head2=head2.next;
            }else {
                System.out.print(head1.value+" ");
                head1=head1.next;
                head2=head2.next;
            }
        }

    }
}

class Node {
    public int value;
    Node next;
    public Node(int value){
        this.value=value;
    }
    public  void setNext(Node next){
        this.next=next;
    }
}
