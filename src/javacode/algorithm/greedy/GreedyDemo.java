package javacode.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyDemo {
    public static void main(String[] args) {
        //�����㲥��̨,���뵽Map
        HashMap<String,HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //��������̨���뵽broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("����");
        hashSet1.add("�Ϻ�");
        hashSet1.add("���");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("����");
        hashSet2.add("����");
        hashSet2.add("����");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("�ɶ�");
        hashSet3.add("�Ϻ�");
        hashSet3.add("����");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("�Ϻ�");
        hashSet4.add("���");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("����");
        hashSet5.add("����");

        //���뵽map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas ������еĵ���
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("����");
        allAreas.add("�Ϻ�");
        allAreas.add("���");
        allAreas.add("����");
        allAreas.add("����");
        allAreas.add("�ɶ�");
        allAreas.add("����");
        allAreas.add("����");

        //����ArrayList, ���ѡ��ĵ�̨����
        ArrayList<String> selects = new ArrayList<String>();

        //����һ����ʱ�ļ��ϣ� �ڱ����Ĺ����У���ű��������еĵ�̨���ǵĵ����͵�ǰ��û�и��ǵĵ����Ľ���
        HashSet<String> tempSet = new HashSet<String>();

        //�����maxKey �� ������һ�α��������У��ܹ��������δ���ǵĵ�����Ӧ�ĵ�̨��key
        String maxKey=null;
        while (allAreas.size()!=0){
            maxKey=null;
            for (String key:broadcasts.keySet()){
                tempSet.clear();
                HashSet<String> areas=broadcasts.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);
                if (tempSet.size()>0&&(maxKey==null || tempSet.size()>broadcasts.get(maxKey).size())){
                    maxKey=key;
                }
            }
            //���maxKey ��Ϊnull , �����뵽 selects
            if (maxKey!=null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println("result:"+ selects);

    }
}
