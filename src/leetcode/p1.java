package leetcode;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        //接收输入的row和column
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        printMatrix(row, col);

    }

    /**
     *
     * @param row
     * @param col
     * @return StringBuffer
     * 1.首先我们要有一个字母表
     * 2.然后我们要知道这次顺时针打印需要用到多少张字母表
     */
    private static StringBuffer getUseAlphabets(int row, int col){
        StringBuffer singleAlphabet = new StringBuffer(); //一个字母表
        StringBuffer UseAlphabets = new StringBuffer();    //实际情况所需要用到的字母表

        int totalENum = row * col;  //所需字母总个数

        //字符转换成数字，变成打印字母表的起始和终止条件
        int firstE = 'A';
        int lastE = 'Z';
        //循环获得一个字母表，用alphabet接受
        for (int i = firstE; i <= lastE; i++) {
            char e = (char) i;
            singleAlphabet.append(e);
        }
        //按照所需字母数量，得出需要多少张字母表。需要的字母表都首尾按顺序拼接在一起。
        int totalEl = (totalENum / 26) + 1;
        for (int i = 0; i < totalEl; i++) {
            UseAlphabets.append(singleAlphabet);
        }

        return UseAlphabets;
    }

    /**
     *
     * @param row
     * @param col
     * 1.设定矩形边界坐标，判断打印一个完整四边的大矩形所需要的前提条件
     * 2.打印一个大矩形的过程分为四步：从左往右、从上往下、从右往左、从下网上，需要判断好每一步打印的条件
     */
    private static void printMatrix(int row, int col){
        char[][] charsAll = new char[row][col]; //接受打印出来的字符表

        int countAlpha = 0; //统计打到哪个字了
        StringBuffer UseAlphabets = getUseAlphabets(row, col);

        //判断输入是否合法，不合法则表示错误
        if (row <= 0 || col <= 0){
            System.out.println("Error");
        }else {
            //矩形边界坐标，用于计算长宽限制条件
            int left = 0;
            int top = 0;
            int right = col - 1;
            int bottom = row - 1;

            /**
             * 1.打印一个完整的大矩形所需要的条件
             * 2.打印一个矩形需要处理的四种情况
             * 3.控制循环变量
             */
            //1.完整的打印一个矩形，中间会包含四种情况。分别判断并输出
            //打印一个完整的大矩形所需要的条件
            while ((left <= right) && (top <= bottom)){
                //从左往右跑，绝对能输出。所以不需要判断是否有足够空间。
                for (int i = left; i <= right; i++) {
                    charsAll[top][i] = UseAlphabets.charAt(countAlpha);
                    countAlpha++;
                }

                //从上往下跑，有条件输出，有条件结束
                for (int i = top + 1; i <= bottom; i++) {
                    charsAll[i][right] = UseAlphabets.charAt(countAlpha);
                    countAlpha++;
                }

                //从右往左跑，有条件输出，有条件结束
                if ((top + 1) <= bottom){
                    for (int i = right - 1; i >= left; i--) {
                        charsAll[bottom][i] = UseAlphabets.charAt(countAlpha);
                        countAlpha++;
                    }
                }

                //从下往上跑，有条件输出，有条件结束
                if ((left + 1) <= right){
                    for (int i = bottom - 1; i > top; i--) {
                        charsAll[i][left] = UseAlphabets.charAt(countAlpha);
                        countAlpha++;
                    }
                }

                //3.控制循环变量
                left++;
                top++;
                right--;
                bottom--;
            }

            for (char[] chars : charsAll) {
                System.out.println(chars);
            }
        }
    }
}


