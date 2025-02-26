import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int[] dp2 = new int[N];
        int max1 = 1, max2 = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(dp2, 1);
        //오름차순
        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            max1 = Math.max(max1, dp[i]);
        }
        //내림차순
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                dp2[i] = dp2[i + 1] + 1;
            }
            max2 = Math.max(max2, dp2[i]);
        }
        System.out.println(Math.max(max1, max2));
    }
}
