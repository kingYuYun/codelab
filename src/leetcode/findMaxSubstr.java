package leetcode;

import java.util.HashMap;
import java.util.Map;

public class findMaxSubstr {
    public static void main(String[] args) {
        String str="The Linux kernel is an open source software project of fairly large scope.";
//        String str="abcdbcdcbabcdefggcwa";
        String s=findMaxSubstr(str);
        System.out.println(s);
        
    }

    public static String findMaxSubstr (String str) {
        // write code here
        Map<Character,Integer> map=new HashMap<>();
        int i=-1;
        int res=0;
        for (int j = 0; j < str.length(); j++) {
                if (map.containsKey(str.charAt(j))){
//                    if (str.charAt(j)==' '){
//                        continue;
//                    }
                    i=Math.max(i,map.get(str.charAt(j)));
                }
            map.put(str.charAt(j),j);
            res=Math.max(res,j-i);
        }
        String s=str.substring(i-res+1,i+1);
//        System.out.println(s);
        return s;
    }
}
