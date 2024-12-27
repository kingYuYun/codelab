package leetcode;

public class sevenbinary {
    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
    }
    public static String convertToBase7(int num) {
        int flag = num;
       char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
                .toCharArray();
        StringBuilder ress = new StringBuilder();
        num=Math.abs(num);
        if (num == 0){
            return "0";
        }

        while(num > 0){
            ress.insert(0,array[num % 7]);
            num /=7;
        }
        if (flag < 0){
            ress.insert(0,'-');
        }
        return ress.toString();
    }
}
