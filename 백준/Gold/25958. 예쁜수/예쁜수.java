import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] dp = new long[M + 1];
        dp[0] = 1;

        for (int i = 1; i <= M; i++) {
            if (isPretty(i)) {
                for (int j = i; j <= M; j++) {
                    dp[j] = (dp[j] + dp[j - i]) % K;
                }
            }
        }


        System.out.println(dp[M] % K);

    }

    public static boolean isPretty(int num) {
        int temp = num;
        int sum = 0;

        while (temp != 0) {
            int a = temp % 10;
            temp /= 10;
            sum += a;
        }
        if (num % sum == 0) {
            return true;
        }
        return false;
    }
}
