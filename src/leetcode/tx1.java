package leetcode;

import java.util.*;

public class tx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int s=list.size();
        for (int i = 0; i < n; i++) {
            List<Integer> l1 = new ArrayList<>(list);
//            l1=list.;
            l1.remove(i);
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int value = o2 - o1;
                    return value;
                }
            });

//            for (int j = 0;j < n-1; j++) {
            System.out.println(list.get((n-1) / 2));
//            }
            l1.clear();
        }
    }
}


