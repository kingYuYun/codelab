package leetcode.hello;

import java.util.*;

public class pro1 {
    public static void main(String[] args) {
//        String str="abcdbcdcbabcdefggcwa";
        String str = "The linux kernel is an open source softawre project of fairly large scope.";
        System.out.println(lengthOfLongestSubstring(str));

    }

    public static String lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            //存在重复的字符，则移动左指针，直到滑动窗口中不含有该字符
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            String s1 = s.substring(left, right);
            if (!map.containsKey(s1) || !map.containsValue(s1.length())) {
                map.put(s1, s1.length());
            }
        }
        return getDiskMax(map);
    }

    private static String getDiskMax(Map<String, Integer> map) {
        List<Integer> list = new ArrayList<Integer>();
        for (String temp : map.keySet()) {
            Integer value = map.get(temp);
            list.add(value);
        }
        double max = 0;
        for (int i = 0; i < list.size(); i++) {
            double size = list.get(i);
            max = (max > size) ? max : size;
        }
        for (String key : map.keySet()) {
            if (max == map.get(key)) {
                return key;
            }
        }
        return null;
    }

    public static String lengthOfLongestSubstring1(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);


        }
        String s1 = s.substring(j - max, j);
        System.out.println(max);
        System.out.println(s1);
        return "s1";
    }


//    public static String lengthOfLongestSubstring(String s) {
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        int left = 0, right = 0;
//        int res = 0;
//        while (right < s.length()) {
//
//            char c = s.charAt(right);
//            map.put(c, map.getOrDefault(c, 0) + 1);
//            right++;
//
//            while (map.get(c) > 1) {
//                char d = s.charAt(left);
//                left++;
//                map.put(d, map.get(d) - 1);
//            }
//            res = Math.max(res, right - left);
//        }
//        String s1=s.substring(left-1,left+res-1);
////        System.out.println(s1);
//        return s1;
//    }
}

