package leetcode;

public class p2 {
    public static void main(String[] args) {
        String s = "mihoyp";
        String p = "mih.*p";

        System.out.println(isMatch(s,p));

    }
//
//    public static boolean isMatch(String s, String p) {
//        //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
//        if (p.isEmpty())return s.isEmpty();
//        //判断s和p的首字符是否匹配，注意要先判断s不为空
//        boolean headMatched=!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
//        if (p.length()>=2&&p.charAt(1)=='*'){//如果p的第一个元素的下一个元素是*
//            //则分别对两种情况进行判断
//            return isMatch(s,p.substring(2))||
//                    (headMatched&&isMatch(s.substring(1),p));
//        }else if (p.length()>=2&&p.charAt(1)=='+'){
//            return headMatched&&isMatch(s.substring(1),p);
//        } else if (headMatched){//否则，如果s和p的首字符相等
//            return isMatch(s.substring(1),p.substring(1));
//        }else {
//            return false;
//        }
//    }

    public static boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}



