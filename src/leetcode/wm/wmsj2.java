package leetcode.wm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class wmsj2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[9][9];
        for (int i = 0; i < 9; i++) {
            String s = new String();
            s=sc.nextLine();
            String s1=s.replace(" ", "");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = s1.charAt(j);
            }
        }

        func(arr);
                for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private static boolean[][] l = new boolean[9][9];
    private static boolean[][] c = new boolean[9][9];
    private static boolean[][][] block = new boolean[3][3][9];

    private static boolean valid = false;
    private static List<int[]> sp = new ArrayList<>();

    public static void func(char[][] arr) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == '0') {
                    sp.add(new int[]{i, j});
                } else {
                    int d = arr[i][j] - '0' - 1;
                    l[i][d] = c[j][d] = block[i / 3][j / 3][d] = true;
                }
            }
        }
        dfs(arr, 0);
    }

    public static void dfs(char[][] arr, int p) {
        if (p == sp.size()) {
            valid = true;
            return;
        }
        int[] space = sp.get(p);
        int i = space[0];
        int j = space[1];
        for (int d = 0; d < 9 && !valid; ++d) {
            if (!l[i][d] && !c[j][d] && !block[i / 3][j / 3][d]) {
                l[i][d] = c[j][d] = block[i / 3][j / 3][d] = true;
                arr[i][j] = (char) (d + '0' + 1);
                dfs(arr, p + 1);
                l[i][d] = c[j][d] = block[i / 3][j / 3][d] = false;
            }
        }
    }

}
