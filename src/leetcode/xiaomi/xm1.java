package leetcode.xiaomi;

import java.util.*;

public class xm1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str=new String();
        List<String> list = new ArrayList<String>();
        String s;
        while(true){
            if((s = sc.nextLine()).equals("")){
                break;
            }
            list.add(s);
        }
        for (int j = 0; j < list.size(); j++) {
            System.out.println(strout1(list.get(j)));
        }
//        while (sc.hasNext()) {
//            str = sc.nextLine();
//            System.out.println(strout(str));
//        }

    }
    public static boolean strout1(String s) {
        LinkedList<Character> stack=new LinkedList<>();
        for (char c :
                s.toCharArray()) {
            if (c=='[') stack.push(']');
            else if (c=='(') stack.push(')');
            else if (c=='{') stack.push('}');
            else if (stack.isEmpty()||c!=stack.pop()) return false;
        }
        return stack.isEmpty();
    }
    public static boolean strout(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else
                stack.push(c);

        }
        return stack.isEmpty();
    }
}
