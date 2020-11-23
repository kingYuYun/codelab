package leetcode.xunlei;

import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class pro1 {
    public static final String uid="uid";
    List<Region> regions=new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String[] s=sc.nextLine().split(" ");
        int m=Integer.parseInt(s[0]);
        int n=Integer.parseInt(s[1]);

        int[][] arr=new int[m][n];
        int[] b;
        int k=0,len=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        for (int[] en:
             arr) {
            len=len+en.length;
        }
        b=new int[len];
        for (int[] en :
                arr) {
            for (int el :
                    en) {
                b[k++]=el;
            }
        }
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
    }
}
