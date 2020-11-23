package leetcode.nonam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HUYUQ {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();
       int n1=Integer.parseInt(n);
        Map<String,String> map=new HashMap<>();
        String[] s;

        for (int i = 0; i <n1 ; i++) {
            s=sc.nextLine().split(" ");
            map.put(s[0],s[1]);
        }

        Map<String, Integer> r=new HashMap<>();
        for (Map.Entry<String,String> entry:map.entrySet()) {
            if (r.containsKey(entry.getValue())){
                r.put(entry.getValue(),r.get(entry.getValue())+1);
            }else {
                r.put(entry.getValue(),1);
            }
        }
        int count=0;
        for (Map.Entry<String, Integer> en:r.entrySet()){
            if (en.getValue()>=2)
                count++;
        }
        System.out.println(count);
    }




}
