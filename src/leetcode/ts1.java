package leetcode;

public class ts1 {
    private static void recursive(){
        recursive();
    }

    public static void main(String[] args) {

        try {
            recursive();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
