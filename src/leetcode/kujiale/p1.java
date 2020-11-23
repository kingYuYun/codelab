package leetcode.kujiale;

import java.util.*;

public class p1 {
    static Map<String,Integer> categorys = new HashMap<String,Integer>();
    private static Random random = new Random();

    public static void initData() {
        Map<String,Integer> wc1 = new HashMap<String,Integer>('1', 1);
        Map<String,Integer>  wc2 = new HashMap<String,Integer>('2', 2);
        Map<String,Integer>  wc3 = new HashMap<String,Integer>('3', 3);
        Map<String,Integer>  wc4 = new HashMap<String,Integer>('4', 4);
        categorys.put("1", 1);
        categorys.put("2", 2);
        categorys.put("3", 3);
        categorys.put("4", 4);
    }

    public static void main(String[] args) {
        initData();
        Integer weightSum = 0;
        for (int wc : categorys.values()) {
            weightSum += wc;
        }

        if (weightSum <= 0) {
            System.err.println("Error: weightSum=" + weightSum.toString());
            return;
        }
        Integer n = random.nextInt(weightSum); // n in [0, weightSum)
        Integer m = 0;

        for (int i = 0; i < 10000; i++) {
            for (Map.Entry<String,Integer> wc : categorys.entrySet()) {
                if (m <= n && n < m + wc.getValue()) {
                    System.out.println(wc.getKey());
                    continue;
                }
                m += wc.getValue();
            }
        }

    }
}

