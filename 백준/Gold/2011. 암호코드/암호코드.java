import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        // 0으로 시작하면 해석할 수 없음
        if (str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = str.charAt(i - 1) - '0';  // 현재 한 자리 숫자
            int twoDigit = (str.charAt(i - 2) - '0') * 10 + oneDigit; // 두 자리 숫자

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] = dp[i - 1] % 1000000;  // 한 자리 해석 가능
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;  // 두 자리 해석 가능
            }
        }

        System.out.println(dp[n]);
    }
}