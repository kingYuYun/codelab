package leetcode.test;

import java.util.PriorityQueue;
import java.util.Scanner;

public class mt3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
           int num=sc.nextInt();
            PriorityQueue<Integer> que=new PriorityQueue<Integer>();
            while (num>0){
                que.add(sc.nextInt());
                num--;
            }
            int ans=0;
            int fir=0;
            int sec=0;
            while (que.size()>1){
                fir=que.poll();
                sec=que.poll();
                ans+=(fir+sec);
                que.add(fir+sec);
            }
            System.out.println(ans);
        }

    }

}
