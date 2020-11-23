package leetcode.qianx;

public class p2 {
    public static void main(String[] args) {

//    int x1=0;
//    int y1=0;
//    int x2=1;
//    int y2=1;
//    int x3=9;
//    int y3=9;
//    int x4=10;
//    int y4=10;
    int x1=4;
    int y1=1;
    int x2=6;
    int y2=9;
    int x3=1;
    int y3=4;
    int x4=9;
    int y4=6;
    System.out.println(getMaxArea(x1,y1,x2,y2,x3,y3,x4,y4));

}

    private static int getMaxArea (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // write code here
        int a1=(x2-x1)*(y2-y1);
        int a2=(x4-x3)*(y4-y3);
        int re=100-a1-a2;
        return re;
    }
}
