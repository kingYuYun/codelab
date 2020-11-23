package leetcode.youzan;

public class p1 {
    public static void main(String[] args) {
        int num=3;
        int itemnum=5;
        System.out.println(sum(3,5));
    }

    private static long sum(int num, int itemNum) {
        // write code here
        int out = 0;
        int tem = num;
        for (int i = 0; i < itemNum; i++) {
            out += num;
            tem *= 10;
            num += tem;
        }
        return out;
    }
}
