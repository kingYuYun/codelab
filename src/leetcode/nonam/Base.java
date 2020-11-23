package leetcode.nonam;

public class Base {
    private String baseName="base";

    public Base(){
        callname();
    }

    public void callname(){
        System.out.println(baseName);
    }

    static class Sub extends Base {
        private String baseName="sub";

        public void callname(){
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Base j=new Sub();
    }
}

