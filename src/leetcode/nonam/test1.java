package leetcode.nonam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test1 {
    static int price;
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        price = sc.nextInt();
        price=1024-price;
        System.out.println(sum);
        while (price>0)
            minmoey(price,sum);
        System.out.println(sum);
        }

    //�ݹ�
    static void minmoey(int price,int sum) {
        if (price==0)
            return;
        if(price<64) {
            price = price-64;
            sum++;
            return;
        }else if (price<16){
            price = price-16;
            sum++;

        }else if (price<4){
            price=price-4;
            sum++;

        }else {
            price=price-1;
            sum++;

        }

    }

    public static class wz {

        public static void main(String[] args) {
            String s = "112";
            String[] list = permutation(s);
            int count = 0;
            for (String l :
                    list) {
                if (Integer.parseInt(l) % 4 == 0) count++;
            }
            System.out.println(count);

        }

        static Set<String> result = new HashSet<>();
        public static String[] permutation(String s) {
            if(s == null) return new String[]{};
            boolean[] visited = new boolean[s.length()];
            process(s, "", visited);
            return result.toArray(new String[result.size()]);
        }

        private static void process(String s, String letter, boolean[] visted){
            if(s.length() == letter.length()){
                result.add(letter);
                return;
            }
            for(int i = 0; i < s.length(); i++){
                char temp = s.charAt(i);
                if(visted[i]) continue;
                visted[i] = true;
                process(s, letter + String.valueOf(temp), visted);
                visted[i] = false;
            }
        }

    }

    public static class fenxiaoj {
        public static class Animal {
            public void move(Dog dog) {
                System.out.println("��������ƶ�");
            }
            public void move()         {
                System.out.println("��������ƶ�b");
            }
        }

        public static class Dog extends Animal {
            public void move() {
                System.out.println("�������ܺ���");
            }

            public void bark() {
                System.out.println("�����Էͽ�");
            }
        }

        public static void main(String args[]) {
    //        Animal a = new Animal(); // Animal ����
            Animal b = new Dog(); // Dog ����
            Dog c = new Dog();
    //        a.move();// ִ�� Animal ��ķ���
            b.move(new Dog());// ִ�� Dog ��ķ���
            b.move();// ִ�� Dog ��ķ���
    //        b.bark();
    //        c.bark();

        }

    }
}
