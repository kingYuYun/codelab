package leetcode.nonam;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class yidong1 {

        public static String getMD5(String str) {
            try {
                // ����һ��MD5���ܼ���ժҪ
                MessageDigest md = MessageDigest.getInstance("MD5");
                // ����md5����
                md.update(str.getBytes());
                // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
                // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
                return new BigInteger(1, md.digest()).toString(16);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("MD5���ܳ��ִ���");
            }
        }
        public static void main(String[] args) {
            int i=2;
            System.out.println(yidong1.getMD5(Integer.toString(i)));
        }

}
