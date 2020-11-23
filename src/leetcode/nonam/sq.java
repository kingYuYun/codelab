package leetcode.nonam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sq {
    public static void main(String[] args) {
        String s = "19 5 9 255";
        System.out.println(sort(s));
    }

    

    public static int sort(String inData) {
        // write code here
        int n = inData.split(" ").length;
        int[] arr=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(inData.split(" ")[i]);
            map.put(Integer.parseInt(inData.split(" ")[i]),i);
        }
        Arrays.sort(arr);
        int index=map.size();
        int count=0;
        for (int i = 0; i < n-1; i++) {
            if (map.get(arr[i])>map.get(arr[i+1])){
                map.put(arr[i+1],index++);
                count++;
            }
        }
        return count;
    }
}
