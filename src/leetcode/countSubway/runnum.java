package leetcode.countSubway;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class edge {
    private String startNodeId;
    private String endNodeId;
    public final int weight=1;
    public String getStartNodeId() {
        return startNodeId;
    }
    public void setStartNodeId(String startNodeId) {
        this.startNodeId = startNodeId;
    }
    public String getEndNodeId() {
        return endNodeId;
    }
    public void setEndNodeId(String endNodeId) {
        this.endNodeId = endNodeId;
    }
}

class node {
    private String id;
    private List<edge> edges;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<edge> getEdges() {
        return edges;
    }
    public void setEdges(List<edge> edges) {
        this.edges = edges;
    }

}

class passedPath {
    private node     curNode ;
    private boolean     visited ;   //�Ƿ��ѱ�����
    private Integer     weight ;        //�ۻ���Ȩֵ
    private List<String> passedIDList ; //·��

    passedPath(node id){
        this.curNode = id;
        this.weight = Integer.MAX_VALUE; //��ʼ��ʱ����ÿ���ڵ㵽Դ�ڵ�ľ���Ϊ�����
        this.passedIDList = new ArrayList<String>();
        this.visited = false;
    }

    passedPath(){
        this.curNode = null;
        this.weight = Integer.MAX_VALUE;
        this.passedIDList = new ArrayList<String>();
        this.visited = false;
    }

    public node getCurNode() {
        return curNode;
    }

    public void setCurNode(node curNode) {
        this.curNode = curNode;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<String> getPassedIDList() {
        return passedIDList;
    }

    public void setPassedIDList(List<String> passedIDList) {
        this.passedIDList = passedIDList;
    }
}

public class runnum {

    /**
     * ����ͼ�ĳ�ʼ����ʽ,��idָ���������ڽ��ڵ�
     * @param id
     * @param nears
     * @return
     */
    public static node init(String id,List<String> nears){
        node tmp = new node();
        tmp.setId(id);
        edge tmp_ = null;
        List<edge> edges = new ArrayList<edge>();
        for(String near:nears){
            tmp_ = new edge();
            tmp_.setStartNodeId(id);
            tmp_.setEndNodeId(near);
            edges.add(tmp_);
        }
        tmp.setEdges(edges);
        return tmp;
    }

    /**
     * ��ʼ��·��
     * @param V
     * @param V0
     */
    public static void initPath(List<node> V,String V0){
        paths = new ArrayList<passedPath>();
        passedPath path = null;
        for(node c:V){
            if(c.getId().equals(V0)){
                path = new passedPath(c);
                path.setWeight(0);
                List<String> tmp = new ArrayList<String>();
                tmp.add(V0);
                path.setPassedIDList(tmp);
            }else{
                path = new passedPath(c);
            }
            paths.add(path);
        }
    }

    /**
     * ���õϽ�˹�����㷨�ó�V�����нڵ�����·��
     * @param V
     */
    public static void run(List<node> V){
        passedPath min = new passedPath();//ʹ���޲�����
        int flag=0;
        for(passedPath c:paths){
            if(!c.isVisited()){
                if(c.getWeight()<min.getWeight()){
                    min = c;
                }
                flag++;
            }
        }
        if(flag==0) return;
        //��minȥ���¿ɴ�ڵ��path
        for(edge c:min.getCurNode().getEdges()){
            //����Ŀ��ڵ����ҵ�Ŀ��ڵ��passedPath:to
            node tmp=null;
            for(node d:V){
                if(d.getId().equals(c.getEndNodeId())){
                    tmp = d;
                }
            }
            passedPath to=null;
            for(passedPath e:paths){
                if(e.getCurNode().equals(tmp)){
                    to = e;
                }
            }
            //�ж��Ƿ���Ҫ����
            if(to.getWeight()>c.weight+min.getWeight()){
                List<String> tmpList = new ArrayList<String>(min.getPassedIDList());
                tmpList.add(to.getCurNode().getId());
                to.setPassedIDList(tmpList);               //����·���б�
                to.setWeight(c.weight+min.getWeight());    //�����ۻ�Ȩֵ
            }
        }
        min.setVisited(true);
        run(V);
    }

    static List<passedPath> paths = null;
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<String> nears=new ArrayList<String>();
        List<node> nodes=new ArrayList<node>();
        nears.add("B");
        nears.add("F");
        nodes.add(init("A",nears));
        nears.clear();
        nears.add("A");
        nears.add("C");
        nodes.add(init("B",nears));
        nears.clear();	//Ϊ�˽�Լƪ�������ڵ�ĳ�ʼ��ʡ��....<span style="font-family: Verdana, Arial, Helvetica, sans-serif;">	</span><span style="font-family: Verdana, Arial, Helvetica, sans-serif;">	</span>
        Scanner in = new Scanner(System.in);
        String start = in.next();
        String end = in.next();
        initPath(nodes,start);
        run(nodes);
        node tmp=null;
        for(node d:nodes){
            if(d.getId().equals(end)){
                tmp = d;
            }
        }
        passedPath to=null;
        for(passedPath e:paths){
            if(e.getCurNode().equals(tmp)){
                to = e;
            }
        }
        for(String f:to.getPassedIDList()){
            System.out.print(f+" ");
        }
        System.out.print(":"+to.getWeight());
    }
}
