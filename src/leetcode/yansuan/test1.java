package leetcode.yansuan;

public class test1 {
    public static void main(String[] args) {
        String s="lipliplipnonononolip";
        System.out.println(compressStr(s));
    }


    public static String compressStr(String srcStr){
        if(srcStr == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = srcStr.length();
        char c1 = srcStr.charAt(0);
        int count = 1;
        for (int i = 1; i < length;i++){
            char c2 = srcStr.charAt(i);
            if (c1 == c2){
                count++;
                continue;
            }
            if (count > 1){
                sb.append(c1).append(count);
            }else {
                sb.append(c1);
            }
            c1 = c2;
            count = 1;
        }
        if(count>1){
            sb.append(c1).append(count);
        }else{
            sb.append(c1);
        }
        return sb.toString();
    }
}
