package leetcode.nonam;

public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] s= {"falowier","flowie","fligieht"};
        System.out.println(longestComonPrefix(s));
    }

    public static String longestComonPrefix(String[] strs){
        if (strs==null||strs.length==0){
            return "";
        }
        int length=strs.length;
        String prefix=strs[0];
        for (int i = 1; i < length; i++) {
            prefix=getPrefix(prefix,strs[i]);
            if (prefix.length()==0)
                break;
        }
        return prefix;
    }

    public static String getPrefix(String prefix,String data){
        int index=0;
        int min=Math.min(prefix.length(),data.length());
        while (index<min&&prefix.charAt(index)==data.charAt(index)){
            index++;
        }
        return prefix.substring(0,index);
    }
}
