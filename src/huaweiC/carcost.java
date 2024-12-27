package huaweiC;

import java.util.Scanner;

public class carcost {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Solution solution = new Solution();
        System.out.println(solution.solve(s));

    }

    static class Solution {
        public int solve(String s) {
            char[] str = s.toCharArray();
            int[] cost = new int[str.length];
            int count = 0;
            int index = 0;
            for (char ch : str) {
                cost[index] = ch - '0';
                index++;
            }
            for (int i = 0; i < index; i++) {
                if (cost[i] < 4) {
                    count += cost[i] * Math.pow(9, index - i - 1);
                } else {
                    count += (cost[i] - 1) * Math.pow(9, index - i - 1);
                }
            }
            return count;
        }
    }

}
