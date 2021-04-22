package javacode.String;

public class stringMethod {
    public static void main(String[] args) {

        String s = "Love You";
        String s2 = "Love"+" You";
        String s3 = s2 + "";
        String s4 = new String("Love You");

        System.out.println("s == s2 "+(s==s2));
        System.out.println("s == s3 "+(s==s3));
        System.out.println("s == s4 "+(s==s4));


        String ss1="abc";
        String ss2=new String("abc");
        String ss3=new String("b");


        System.out.println("ss1 == ss2 "+(ss1==ss2));
        System.out.println("ss1 == ss3 "+(ss1==ss3));
    }
}
