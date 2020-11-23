package leetcode.countSubway;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * �������ͼ�ĵ�Դ���·��
 */
class NonDirectedGraph {
    private class Vertex{
        private String vertexLabel;//�����ʶ
        private List<Edge> adjEdges;//��ö����ڽӵı�(��)
        private int dist;//�������(�ö��㵽��ʼ����ľ���)
        private Vertex preNode;

        public Vertex(String vertexLabel) {
            this.vertexLabel = vertexLabel;
            adjEdges = new LinkedList<>();
            dist = Integer.MAX_VALUE;
            preNode = null;
        }
    }
    private class Edge{
        private Vertex endVertex;
        public Edge(Vertex endVertex) {
            this.endVertex = endVertex;
        }
    }

    private Map<String, Vertex> nonDirectedGraph;//������ͼ�����еĶ��㣬�ߵĹ�ϵ��List��ʽ������Vertex����
    private Vertex startVertex;//ͼ����ʼ����

    public NonDirectedGraph(String graphContent) {
        nonDirectedGraph = new LinkedHashMap<>();
        buildGraph(graphContent);
    }

    private void buildGraph(String graphContent){
        String[] lines = graphContent.split("\n");

        String startNodeLabel, endNodeLabel;
        Vertex startNode, endNode;
        for(int i = 0; i < lines.length; i++){
            String[] nodesInfo = lines[i].split(",");
            startNodeLabel = nodesInfo[1];
            endNodeLabel = nodesInfo[2];

            endNode = nonDirectedGraph.get(endNodeLabel);
            if(endNode == null){
                endNode = new Vertex(endNodeLabel);
                nonDirectedGraph.put(endNodeLabel, endNode);
            }

            startNode = nonDirectedGraph.get(startNodeLabel);
            if(startNode == null){
                startNode = new Vertex(startNodeLabel);
                nonDirectedGraph.put(startNodeLabel, startNode);
            }
            Edge e = new Edge(endNode);
            //��������ͼ����,�����յ㶼Ҫ��ӱ�
            endNode.adjEdges.add(e);
            startNode.adjEdges.add(e);
        }
        startVertex = nonDirectedGraph.get(lines[0].split(",")[1]);//�������ļ��е�һ�еڶ��е��Ǹ���ʶ������ΪԴ��
    }

    public void unweightedShortestPath(){
        unweightedShortestPath(startVertex);
    }


    /*
     * ����Դ��s������ͼ�и�����������·��
     * ��Ҫһ������������ͼ�еĶ���,��ʼʱ,Դ�������,Ȼ���Թ�ȵ���ʽ������ɢ���������������·��
     */
    private void unweightedShortestPath(Vertex s){
        //��ʼ��
        Queue<Vertex> queue = new LinkedList<>();
        s.dist = 0;
        queue.offer(s);//��Դ��dist����Ϊ0�������

        while(!queue.isEmpty()){
            Vertex v = queue.poll();
            for (Edge e : v.adjEdges) {//ɨ��v���ڽӱ�(��)
                if(e.endVertex.dist == Integer.MAX_VALUE){//����������(e.endVertex)δ������(ÿ������ֻ�������һ��)
                    e.endVertex.dist = v.dist + 1;//���¸ö��㵽Դ��ľ���
                    queue.offer(e.endVertex);
                    e.endVertex.preNode = v;//���øö����ǰ������
                }//end if
            }//end for
        }//end while
    }

    //��ӡͼ�����ж��㵽Դ��ľ��뼰·��
    public void showDistance(){
        Collection<Vertex> vertexs = nonDirectedGraph.values();
        for (Vertex vertex : vertexs) {
            System.out.print(vertex.vertexLabel + "<--");
            Vertex tmpPreNode = vertex.preNode;
            while(tmpPreNode != null){
                System.out.print(tmpPreNode.vertexLabel + "<--");
                tmpPreNode = tmpPreNode.preNode;
            }
            System.out.println("distance=" + vertex.dist);
        }
    }
}

public class TestShortestPath {
    public static void main(String[] args) {
        String graphFilePath;
        if(args.length == 0)
            graphFilePath = "D:\\IDEAPreoject\\�ʼǡ����롢�μ�������\\mycode\\src\\leetcode\\countSubway\\pathfile.txt";
        else
            graphFilePath = args[0];

        String graphContent = FileUtil.read(graphFilePath, null);
        NonDirectedGraph graph = new NonDirectedGraph(graphContent);
        graph.unweightedShortestPath();
        graph.showDistance();
    }
}
