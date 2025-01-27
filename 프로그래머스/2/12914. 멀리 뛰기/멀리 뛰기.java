class Solution {
    public long solution(int n) {
        if (n == 1) return 1; // n이 1일 때는 1가지 경우
        if (n == 2) return 2; // n이 2일 때는 2가지 경우 (1+1, 2)

        long mod = 1234567;
        long[] dp = new long[n + 1];

        dp[0] = 1; // 합이 0일 때 경우의 수는 1
        dp[1] = 1; // 합이 1일 때 경우의 수는 1
        dp[2] = 2; // 합이 2일 때 경우의 수는 2 (1+1, 2)

        // 점화식 적용
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        return dp[n];
    }
}
