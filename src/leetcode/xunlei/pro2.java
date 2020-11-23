package leetcode.xunlei;

import java.util.*;

public class pro2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[][] str=new String[n][2];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < 2; j++) {
                str[i][j]=sc.nextLine();
            }
        }
        List<String> l=new ArrayList<>();
        Map<String,String> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(str[i][0],str[i][1]);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsValue(str[i][0]))
                l.add(str[i][0]);
        }
        int k=0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(l.get(0)))
                l.add(map.get(l.get(0)));
        }

        System.out.println(l);
    }
}
