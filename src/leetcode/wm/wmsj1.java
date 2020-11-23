package leetcode.wm;

import java.util.Scanner;

public class wmsj1 {
    static int replaceBits(int src, int dst, int bitIndex, int bitCount) {
        String sq=Integer.toBinaryString(src);

        String r=sq.substring(sq.length()-bitCount,bitCount+bitIndex+1);
        System.out.println(r);
        StringBuilder sb=new StringBuilder();
        sb.append(Integer.toBinaryString(dst));
        sb.replace(bitCount-1,bitCount+bitIndex+1,r);

        String  out=sb.toString();
        int total=0;
        for (int i = 0; i < out.length(); i++) {
            total=total+out.charAt(i)-48;
            if (i!=out.length()-1)
                total=total<<1;
        }
        return total;
    }
    /******************************½áÊøÐ´´úÂë******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _src=45;


        int _dst=83;


        int _bitIndex=1;


        int _bitCount=3;


        res = replaceBits(_src, _dst, _bitIndex, _bitCount);
        System.out.println(String.valueOf(res));

    }
}
