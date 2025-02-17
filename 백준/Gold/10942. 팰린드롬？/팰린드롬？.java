class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int[] seq = new int[N + 1];
        boolean[][] dp = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            seq[i] = read();
            dp[i][i] = true;
            if (seq[i - 1] == seq[i]) dp[i - 1][i] = true;
        }

        for (int i = N - 2; i >= 1; i--) {
            for (int j = i + 2; j <= N; j++) {
                if (seq[i] == seq[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        int M = read();
        while (M-- > 0) write(dp[read()][read()]);

        flush();

    }

    static int index, SIZE = 1 << 13;
    static byte[] buffer = new byte[SIZE];

    static void write(boolean isPpalindrome) {
        if (index + 2 == SIZE) flush();
        buffer[index++] = (byte) (isPpalindrome ? 49 : 48);
        buffer[index++] = 10;
    }

    static void flush() {
        System.out.write(buffer, 0, index);
        index = 0;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}