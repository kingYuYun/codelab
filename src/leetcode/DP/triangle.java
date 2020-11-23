package leetcode.DP;

public class triangle {

    public static  void main(String[] args)  throws Throwable {
        int minPathSum = traverse();
        System.out.println("sum = " + minPathSum);
    }
    private static int[][] triangle = {
            {2, 0, 0, 0},
            {3, 4, 0, 0},
            {6, 5, 7, 0},
            {4, 1, 8, 3}
    };
    public static int traverse() {
        int ROW = 4;
        int[] mini = triangle[ROW - 1];
        // �ӵ����ڶ���������Ϊ���һ�е�ֵ�����ǹ̶���
        for (int i = ROW - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                mini[j] = triangle[i][j] + Math.min(mini[j], mini[j+1]);
            }
        }
        return mini[0];
    }

}
