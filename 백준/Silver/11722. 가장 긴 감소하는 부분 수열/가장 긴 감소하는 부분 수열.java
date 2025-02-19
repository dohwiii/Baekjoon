import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = 1;
        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            if (dp[len - 1] <= arr[i]) { //더 큰값이 발생했다면 이분탐색으로 dp 값들과 비교해서 자리 찾기
                dp[upperBound(arr[i], len)] = arr[i];
            }
            else if (dp[len - 1] > arr[i]) {    //마지막 값보다 작다면 dp 마지막 인덱스에 추가
                dp[len++] = arr[i];
            }
        }
        System.out.println(len);

    }

    public static int upperBound(int num, int len) {
        int left = 0, right = len - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] > num) {
                left = mid + 1;
            }
            else if (dp[mid] <= num) {
                right = mid;
            }
        }

        return right;
    }

}