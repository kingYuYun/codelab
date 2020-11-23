package leetcode.sougou;

public class sg1 {
    static int count1 = 0;

    public static void main(String[] args) {
        String s = "12345";
        char[] arr = s.toCharArray();
        int[] number=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            number[i]=Integer.parseInt(String.valueOf(arr[i]));
        }

        for (int i = 0; i < 10; i++) {
            count(1,i,number);
//            System.out.println(arr[i]);
        }
        System.out.println(count1);
    }

    private static int count(int index, int pre, int[] arr) {
        if (index<arr.length) {

            if ((pre + arr[index]) % 2 != 0) {
                int num1 = (int) Math.floor((pre + arr[index]) / 2.0);
                int num2 = (int) Math.ceil((pre + arr[index]) / 2.0);
                count1 ++;
//                index++;
                return count(index+1, num2, arr) + count(index+1, num2, arr);
            } else {
                int num = pre + arr[index] / 2;
                count1++;
//                index++;
                return count(index+1, num, arr);
            }
        }else {
            return count1;
        }

    }
}
