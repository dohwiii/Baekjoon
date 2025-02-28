import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = 1;
        int[] dp = new int[N];
        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            if (dp[len - 1] > arr[i]) { //바로 뒤에 배치 가능
                dp[len++] = arr[i];
            } else {  //더 큰 값으로 교체
                int index = getLIS(arr[i], len, dp);
                dp[index] = arr[i];
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(arr.length - len);
        
    }

    public static int getLIS(int num, int len, int[] dp) {
        int left = 0, right = len - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] >= num) {
                left = mid + 1;
            }
            else if (dp[mid] < num) {
                right = mid;
            }
        }
        return right;
    }
}
