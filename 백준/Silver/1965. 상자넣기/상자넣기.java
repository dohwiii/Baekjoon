import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = 1;
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            if (dp[len - 1] < arr[i]) { //가장 마지막에 넣은 값보다 크다면 맨 마지막에 추가
                dp[len++] = arr[i];
            }
            else {
                int index = getLIS(arr[i], len, dp);
                dp[index] = arr[i];
            }
        }
        System.out.println(len);

    }

    public static int getLIS(int num, int len, int[] dp) {
        int left = 0, right = len - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] >= num) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }
}