package leetcode.sougou;

import java.util.Enumeration;

public class asdq {
    public static void main(String[] args) {
        int[] arr={4,4,2};
        System.out.println(numberofprize(4,4,2 ));
    }
    private static int numberofprize (int a, int b, int c) {
        // write code here
        int res = Math.min(a,Math.min(b,c));
        //�ֶ�ģ��
        while(Math.min(a,Math.min(b,c)) >= res){
            //��һ�μ�������������1
            if (a >= b && a >= c){
                a--;
            }else if(b >= a && b >= c){
                b--;
            }else if(c >= a && c >= b){
                c--;
            }
            //�ڶ��μ�
            if (a >= b && a >= c){
                if (b > c){//����������1����С������1
                    a--;
                    c++;
                }else{
                    a--;
                    b++;
                }
            }else if(b >= a && b >= c){
                if (a > c){
                    b--;
                    c++;
                }else{
                    b--;
                    a++;
                }
            }else if(c >= a && c >= b){
                if (b > a){
                    c--;
                    a++;
                }else{
                    c--;
                    b++;
                }
            }
            res = Math.max(res,Math.min(a,Math.min(b,c)));
        }
        return res;
    }
}
