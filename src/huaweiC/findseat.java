package huaweiC;

public class findseat {
    public static void main(String[] args) {
//        String[] stringArray = {"0","1","0","1"};
//        String[] stringArray = {"1","0","0","0","1"};
        String[] stringArray = {"1","0","0","0","1","0","0","0","0","0","0","0","0","0","0","0","0","0",};
        System.out.println(findSeat(stringArray));
    }

    public static int findSeat(String[] seat) {
        int n = seat.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Check if the current seat and its neighbors are empty
            if ((i == 0 || seat[i - 1].equals("0")) && seat[i].equals("0") && (i == n - 1 || seat[i + 1].equals("0"))) {
                count++;
                // Place a person in the current seat
                seat[i] = "1";
            }
        }
        return count;
    }
}
