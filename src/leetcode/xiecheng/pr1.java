package leetcode.xiecheng;

import java.util.Scanner;

public class pr1 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    public static int buyCoke(int m, int a, int b, int c, int x) {
        int count=0;
        if (m==0) return count+1;
        int acount = 0;
        int bcount = 0;
        int ccount = 0;
        int p = x;
        while (p > 0) {
            if (x > 10 && x < 50) {
                acount -= x % 10;
            }
            if (x > 50 && x < 100) {
                bcount = x % 50 + 1;
                acount += x / 50 % 10;
                p -= 50 * ccount;
            }
            if (x > 100) {
                ccount -= x % 100;
                acount += x / 100 % 10;
                p -= 100 * ccount;
            }
        }
        return buyCoke(m--, a + acount, b-bcount,c-ccount,x);
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _c;
        _c = Integer.parseInt(in.nextLine().trim());

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(_m, _a, _b, _c, _x);
        System.out.println(String.valueOf(res));

    }

}
