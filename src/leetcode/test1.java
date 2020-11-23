package leetcode;

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

    //递归
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
                System.out.println("动物可以移动");
            }
            public void move()         {
                System.out.println("动物可以移动b");
            }
        }

        public static class Dog extends Animal {
            public void move() {
                System.out.println("狗可以跑和走");
            }

            public void bark() {
                System.out.println("狗可以吠叫");
            }
        }

        public static void main(String args[]) {
    //        Animal a = new Animal(); // Animal 对象
            Animal b = new Dog(); // Dog 对象
            Dog c = new Dog();
    //        a.move();// 执行 Animal 类的方法
            b.move(new Dog());// 执行 Dog 类的方法
            b.move();// 执行 Dog 类的方法
    //        b.bark();
    //        c.bark();

        }

    }
}
