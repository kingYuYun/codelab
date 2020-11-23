package leetcode.nonam;


import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class Dijkstra {

    public static void main(String[] args) {

    }
        private class Vertex implements Comparable<Vertex>
        {
            private String vertexLabel;//�����ʶ
            private List<Edge> adjEdges;//����������ڽӱ�(��)
            private int dist;//���㵽Դ�����̾���
            private Vertex preNode;//ǰ������

            public Vertex(String vertexLabel){
                this.vertexLabel = vertexLabel;
                adjEdges = new LinkedList<Edge>();
                dist = Integer.MAX_VALUE;
                preNode = null;
            }

            @Override
            public int compareTo(Vertex v) {
                if(this.dist >  v.dist)
                    return 1;
                else if(this.dist < v.dist)
                    return -1;
                return 0;
            }
        }

        private class Edge{
            private int weight;//�ߵ�Ȩֵ(��Ȩͼ)
            private Vertex endVertex;
            public Edge(int weight, Vertex endVertex) {
                this.weight = weight;
                this.endVertex = endVertex;
            }
        }

        private Map<String, Vertex> weightedGraph;//�洢ͼ(��������)
        private Vertex startVertex;//��Դ���·������ʼ����


        //ͼ����Ϣ�������ļ���,���ļ��ж�ȡ���ַ���graphContent
        public Dijkstra(String graphContent) {
            weightedGraph = new LinkedHashMap<String, Dijkstra.Vertex>();
            buildGraph(graphContent);//�����ַ�������ͼ
        }
        private void buildGraph(String graphContent){
            String[] lines = graphContent.split("\n");

            String startNodeLabel, endNodeLabel;
            Vertex startNode, endNode;
            int weight;
            for(int i = 0; i < lines.length; i++){
                String[] nodesInfo = lines[i].split(",");
                startNodeLabel = nodesInfo[1];
                endNodeLabel = nodesInfo[2];
                weight = Integer.valueOf(nodesInfo[3]);

                endNode = weightedGraph.get(endNodeLabel);
                if(endNode == null){
                    endNode = new Vertex(endNodeLabel);
                    weightedGraph.put(endNodeLabel, endNode);
                }

                startNode = weightedGraph.get(startNodeLabel);
                if(startNode == null){
                    startNode = new Vertex(startNodeLabel);
                    weightedGraph.put(startNodeLabel, startNode);
                }
                Edge e = new Edge(weight, endNode);
                //��������ͼ����,�����յ㶼Ҫ��ӱ�
//            endNode.adjEdges.add(e);
                startNode.adjEdges.add(e);
            }
            startVertex = weightedGraph.get(lines[0].split(",")[1]);//�������ļ��е�һ�еڶ��е��Ǹ���ʶ������ΪԴ��
        }


        public void dijkstra(){
            BinaryHeap<Vertex> heap = new BinaryHeap<Dijkstra.Vertex>();
            init(heap);//inital heap

            while(!heap.isEmpty())
            {
                Vertex v = heap.deleteMin();
                List<Edge> adjEdges = v.adjEdges;//��ȡv�������ڽӵ�
                for (Edge e : adjEdges) {
                    Vertex adjNode = e.endVertex;
                    //update
                    if(adjNode.dist > e.weight + v.dist){
                        adjNode.dist = e.weight + v.dist;
                        adjNode.preNode = v;
                    }
                }//end for

                //����֮���ƻ��˶�������,��Ҫ���жѵ���,����ֱ�����¹����(�൱��decreaseKey)
                heap=new BinaryHeap<>();
            }

        }
        private void init(BinaryHeap<Vertex> heap){
            startVertex.dist = 0;//Դ�㵽������ľ���Ϊ0
            for (Vertex v : weightedGraph.values()) {
                heap.insert(v);
            }
        }

        public void showDistance(){
            for (Vertex v : weightedGraph.values()) {
                printPath(v);
                System.out.println();
                System.out.println("���� " + v.vertexLabel + "��Դ��"  + startVertex.vertexLabel + " �ľ���: " + v.dist);
            }
        }

        //��ӡԴ�㵽 end ����� ���·��
        private void printPath(Vertex end)
        {
            if(end.preNode != null)
                printPath(end.preNode);
            System.out.print(end.vertexLabel + "--> ");
        }

}
