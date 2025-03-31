import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        long result = 0;

        for (int i = 1; i <= N; i++) {
            sum += i;
        }
        if (sum % 2 != 0) { //그룹을 나눌 수 없음
            result = 0;
        }
        else {
            sum = sum / 2;
            long[] dp = new long[sum + 1];
            dp[0] = 1;
            for (int i = 1; i <= N; i++) {
                for (int j = sum; j >= i; j--) {
                    dp[j] += dp[j - i];
                }
            }
            result = dp[sum] / 2;
//            System.out.println(Arrays.toString(dp));
        }
        System.out.println(result);
    }
}