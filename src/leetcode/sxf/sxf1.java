package leetcode.sxf;

public class sxf1 {
    public static void main(String[] args) {

    }

    public int getSqrt (int num) {
        // write code here
        if(num==0){return 0;}
        int res=(int) Math.exp(0.5*Math.log(num));
        return (long)(res+1)*(res+1)<=num?res+1:res;
    }
}
