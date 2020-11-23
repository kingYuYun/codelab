package leetcode.nonam;

public class p2 {
    public static void main(String[] args) {
        String s = "mihoyp";
        String p = "mih.*p";

        System.out.println(isMatch(s,p));

    }
//
//    public static boolean isMatch(String s, String p) {
//        //�������pΪ���ַ���sҲΪ����ƥ��ɹ����������pΪ�յ���s���ǿ���˵��ƥ��ʧ��
//        if (p.isEmpty())return s.isEmpty();
//        //�ж�s��p�����ַ��Ƿ�ƥ�䣬ע��Ҫ���ж�s��Ϊ��
//        boolean headMatched=!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
//        if (p.length()>=2&&p.charAt(1)=='*'){//���p�ĵ�һ��Ԫ�ص���һ��Ԫ����*
//            //��ֱ��������������ж�
//            return isMatch(s,p.substring(2))||
//                    (headMatched&&isMatch(s.substring(1),p));
//        }else if (p.length()>=2&&p.charAt(1)=='+'){
//            return headMatched&&isMatch(s.substring(1),p);
//        } else if (headMatched){//�������s��p�����ַ����
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
                //�ֳɿ�����ͷǿ���������
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //�ǿ������Ϊ������� * �� ��*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //���� * �ˣ���Ϊ���Ͳ����������
                        //����
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //��
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



