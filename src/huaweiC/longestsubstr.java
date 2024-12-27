package huaweiC;

import java.util.Scanner;

public class longestsubstr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(findMaxSubstring(str));
    }

    private static int findMaxSubstring(String str) {
        char ch = 'o';

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        // 如果字符出现次数为偶数，返回字符串长度
        if (count == 0 || count % 2 == 0) {
            return str.length();
        } else {
            // 如果字符出现次数为奇数，返回字符串长度减 1
            return str.length() - 1;
        }
    }
}
