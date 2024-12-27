package huaweiC;

import java.util.Scanner;

public class balancestring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] charArray = s.toCharArray(); // 将字符串转换为字符数组

        // 打印字符数组的长度
//        System.out.println(charArray.length);

        // 如果需要打印字符数组中的每个字符，可以使用以下代码
//        for (char c : charArray) {
//            System.out.print(c);
//        }
        System.out.println(findMaxSubstring(charArray));

    }

    //findmaxsubstring
    public static int findMaxSubstring(char[] charArray) {

        int count=0;
        int balance=0;

        for(char c:charArray){
            if (c=='X'){
                balance++;
            }else{
                balance--;
            }

            if (balance==0){
                count++;
            }
            }

        return count;
    }
}
