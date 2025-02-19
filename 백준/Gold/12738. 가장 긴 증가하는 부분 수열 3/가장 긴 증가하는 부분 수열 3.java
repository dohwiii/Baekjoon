import java.io.*;
import java.util.*;

public class Main {
    static long[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new long[N];
        dp = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = 1;
        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            if (dp[len - 1] >= arr[i]) {
                dp[lowerBound(arr[i], len)] = arr[i];
            }
            else if (dp[len - 1] < arr[i]) {
                dp[len++] = arr[i];
            }
        }
        System.out.println(len);

    }

    public static int lowerBound(long num, int len) {
        int left = 0, right = len - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] >= num) {
                right = mid;
            }
            else if (dp[mid] < num) {
                left = mid + 1;
            }
        }

        return right;
    }

}