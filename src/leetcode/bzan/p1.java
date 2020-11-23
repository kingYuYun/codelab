package leetcode.bzan;

public class p1 {
    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        int[] bb = SpiralMatrix(arr);
        for (int i :
                bb) {
            System.out.print(i + " ");
        }
    }

    private static int[] SpiralMatrix(int[][] matrix) {
        // write code here
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, down = m - 1, left = 0, right = n - 1;
        int[] b = new int[m * n];
        int index = 0;
        while (true) {
            for (int i = left; up <= down && i <= right; i++) {
                b[index++] = matrix[up][i];
            }
            up++;
            for (int i = up; left <= right && i <= down; i++) {
                b[index++] = matrix[i][right];
            }
            right--;
            for (int i = right; up <= down && i >= left; i--) {
                b[index++] = matrix[down][i];
            }
            down--;
            for (int i = down; left <= right && i >= up; i--) {
                b[index++] = matrix[i][left];
            }
            left++;
            if (index == m * n)
                break;
        }
        return b;
    }
}
