package leetcode.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class mt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Integer> assign=new HashMap<>();
        HashSet<Integer> assigned=new HashSet<>();
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                int tempN=sc.nextInt();
                if(!assigned.contains(tempN)){
                    assign.put(i+1,tempN);
                    assigned.add(tempN);
                    sc.nextLine();
                    break;
                }
            }
        }
        assign.keySet().stream().forEachOrdered(num-> System.out.print(assign.get(num)+" "));

    }

}
