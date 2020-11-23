package leetcode.nonam;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        //���������row��column
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
     * 1.��������Ҫ��һ����ĸ��
     * 2.Ȼ������Ҫ֪�����˳ʱ���ӡ��Ҫ�õ���������ĸ��
     */
    private static StringBuffer getUseAlphabets(int row, int col){
        StringBuffer singleAlphabet = new StringBuffer(); //һ����ĸ��
        StringBuffer UseAlphabets = new StringBuffer();    //ʵ���������Ҫ�õ�����ĸ��

        int totalENum = row * col;  //������ĸ�ܸ���

        //�ַ�ת�������֣���ɴ�ӡ��ĸ�����ʼ����ֹ����
        int firstE = 'A';
        int lastE = 'Z';
        //ѭ�����һ����ĸ����alphabet����
        for (int i = firstE; i <= lastE; i++) {
            char e = (char) i;
            singleAlphabet.append(e);
        }
        //����������ĸ�������ó���Ҫ��������ĸ����Ҫ����ĸ����β��˳��ƴ����һ��
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
     * 1.�趨���α߽����꣬�жϴ�ӡһ�������ıߵĴ��������Ҫ��ǰ������
     * 2.��ӡһ������εĹ��̷�Ϊ�Ĳ����������ҡ��������¡��������󡢴������ϣ���Ҫ�жϺ�ÿһ����ӡ������
     */
    private static void printMatrix(int row, int col){
        char[][] charsAll = new char[row][col]; //���ܴ�ӡ�������ַ���

        int countAlpha = 0; //ͳ�ƴ��ĸ�����
        StringBuffer UseAlphabets = getUseAlphabets(row, col);

        //�ж������Ƿ�Ϸ������Ϸ����ʾ����
        if (row <= 0 || col <= 0){
            System.out.println("Error");
        }else {
            //���α߽����꣬���ڼ��㳤����������
            int left = 0;
            int top = 0;
            int right = col - 1;
            int bottom = row - 1;

            /**
             * 1.��ӡһ�������Ĵ��������Ҫ������
             * 2.��ӡһ��������Ҫ������������
             * 3.����ѭ������
             */
            //1.�����Ĵ�ӡһ�����Σ��м���������������ֱ��жϲ����
            //��ӡһ�������Ĵ��������Ҫ������
            while ((left <= right) && (top <= bottom)){
                //���������ܣ���������������Բ���Ҫ�ж��Ƿ����㹻�ռ䡣
                for (int i = left; i <= right; i++) {
                    charsAll[top][i] = UseAlphabets.charAt(countAlpha);
                    countAlpha++;
                }

                //���������ܣ����������������������
                for (int i = top + 1; i <= bottom; i++) {
                    charsAll[i][right] = UseAlphabets.charAt(countAlpha);
                    countAlpha++;
                }

                //���������ܣ����������������������
                if ((top + 1) <= bottom){
                    for (int i = right - 1; i >= left; i--) {
                        charsAll[bottom][i] = UseAlphabets.charAt(countAlpha);
                        countAlpha++;
                    }
                }

                //���������ܣ����������������������
                if ((left + 1) <= right){
                    for (int i = bottom - 1; i > top; i--) {
                        charsAll[i][left] = UseAlphabets.charAt(countAlpha);
                        countAlpha++;
                    }
                }

                //3.����ѭ������
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


