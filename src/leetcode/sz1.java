package leetcode;

public class sz1 {

        /**
         * 问题：数组的向左k平移，k小于数组长度
         * @param args
         */
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            boolean result=false?false:true==false?true:false;
            System.out.println(result);
        }

        private static final int i = 10000;
        private static final int testNum = 1000;
        private int a[];
        private long startTime = 0, timeSpan = 0;

        public sz1() {
            a = new int[i];
            for (int j = 0; j < i; j++) {
                a[j] = j;
            }
        }
    public static long climbStairs(int n) {

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }
        public void printArray() {
            for (int j = 0; j < i; j++) {
                System.out.println(a[j]);
            }
        }

        public void methodOne() {
            this.startTime = System.currentTimeMillis();
            for (int k = 1; k <= testNum; k++) {
                for (int j = 0; j < k; j++) {
                    int m = a[0];
                    for (int l = 1; l < i; l++) {
                        a[l - 1] = a[l];
                    }
                    a[i - 1] = m;
                }
            }
            this.timeSpan = System.currentTimeMillis() - this.startTime;
            System.out.println("第一种方法消耗时间：" + timeSpan + "毫秒");
        }

        public static void moveArrayFirstToLast() {
            int i=0;
            i=i++ +i;
            System.out.println(i);
        }

        public void methodTwo() {
            this.startTime = System.currentTimeMillis();
            for (int j = 1; j <= testNum; j++) {
                this.swapArray(1, j);
                this.swapArray(j + 1, i);
                this.swapArray(1, i);
            }
            this.timeSpan = System.currentTimeMillis() - this.startTime;
            System.out.println("第二种方法消耗时间：" + timeSpan + "毫秒");
        }

        public void swapArray(int start, int end) {
            for (int s = start - 1, e = end - 1; s < e; s++, e--) {
                int temp = a[s];
                a[s] = a[e];
                a[e] = temp;
            }
        }

        public int gcdTwoInt(int m, int n) {
            if (m <= 0 && n <= 0)
                return 0;
            if (m <= 0 || n <= 0)
                return m <= 0 ? n : m;
            int g;
            while (n > 0) {
                g = m % n;
                m = n;
                n = g;
            }
            return m;
        }

        public void moveByGCD(int k) {
            if (k <= 0)
                return;
            int m = this.gcdTwoInt(k, i);
            for (int j = 0; j < m; j++) {
                int c = a[j];
                int p;
                for (p = (j + k) % i; p != j; p = (p + k) % i) {
                    a[(p - k + i) % i] = a[p];
                }
                a[(p - k + i) % i] = c;
            }
        }

        public void methodThree() {
            this.startTime = System.currentTimeMillis();
            for (int j = 1; j <= testNum; j++) {
                this.moveByGCD(j);
            }
            this.timeSpan = System.currentTimeMillis() - this.startTime;
            System.out.println("第三种方法消耗时间：" + this.timeSpan + "毫秒");
        }

}
