package leetcode.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String str = sc.nextLine();

//        Pattern pattern = Pattern.compile("([^M]*M[^T]*T)(.+?)(M[^M]*T[^M]*)");
        Pattern pattern = Pattern.compile("([^M]*M[^T]*T)(.+?)(M[^M]*T[^M]*)");

        Matcher matcher = pattern.matcher(str);
        matcher.find();
        System.out.println(matcher.group(2));


    }

}
