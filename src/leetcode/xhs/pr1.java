package leetcode.xhs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pr1 {
    public static void main(String[] args) {
        String s = "1 0 3 5 2 7";
        String str = new String();
        for (String en :
                s.split(" ")) {
            if (en != " ") str += en;
        }

        //�������鲢��ʼ��
        int[] arr = new int[s.split(" ").length];
        for (int i = 0; i < s.split(" ").length; i++) {
            arr[i] = Integer.parseInt(s.split(" ")[i]);
        }

        perm(str);
//        System.out.println();

    }
    // ���ַ����������ַ������abc>a,b,c,ab,ac,bc,abc
    public static void perm(String s)
    {
        List<String> result = new ArrayList<String>();
        // ��һ����ʼ
        for (int i = 1; i <= s.length(); i++)
        {
            combination(s, i, result);
        }
    }

    // ���ַ���s��ѡ��m���ַ�
    public static void combination(String s, int m, List<String> result)
    {
        // ���m==0����ݹ�����������ǰ���
        if (m == 0)
        {
            for (int i = 0; i < result.size(); i++)
            {
                System.out.print(result.get(i));
            }
            System.out.print("��");
            return;
        }

        if (s.length() != 0)
        {
            // ѡ��ǰԪ��
            result.add(s.charAt(0) + "");
            // substring�÷�����ȡ����1��ʼ��n�������ַ���
            combination(s.substring(1, s.length()), m - 1, result);
            result.remove(result.size() - 1);
            // ��ѡ��ǰԪ��
            combination(s.substring(1, s.length()), m, result);
        }
    }
}
