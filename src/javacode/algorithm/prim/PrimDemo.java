package javacode.algorithm.prim;

import java.util.Arrays;

public class PrimDemo {
    public static void main(String[] args) {
        //���Կ���ͼ�Ƿ񴴽�ok
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //�ڽӾ���Ĺ�ϵʹ�ö�ά�����ʾ,10000�����������ʾ�����㲻��ͨ
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        //����MGraph����
        MGraph graph = new MGraph(verxs);
        //
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        minTree.showGraph(graph);
        minTree.prim(graph,3);

    }
}


//������С������->��ׯ��ͼ
class MinTree {
    //����ͼ���ڽӾ���

    /**
     * @param graph  ͼ����
     * @param verxs  ͼ��Ӧ�Ķ������
     * @param data   ͼ�ĸ��������ֵ
     * @param weight ͼ���ڽӾ���
     */
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {//����
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int[] link :
                graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph graph, int v) {
        int visited[] = new int[graph.verxs];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < graph.verxs; k++) {
            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //�ҵ�һ��������С
            System.out.println("��<" + graph.data[h1] + "," + graph.data[h2] + "> Ȩֵ:" + minWeight);
            //����ǰ��������Ϊ�Ѿ�����
            visited[h2] = 1;
            //minWeight ��������Ϊ���ֵ 10000
            minWeight = 10000;
        }
    }


}

class MGraph {
    int verxs; //��ʾͼ�Ľڵ����
    char[] data;//��Ž������
    int[][] weight; //��űߣ��������ǵ��ڽӾ���

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}