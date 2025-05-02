import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        long[] sum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int s = 1, e = 1;
        long ans = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                if (sum[j] - sum[i - 1] > K) {
                    ans += (N - j + 1);
                    break;
                }
            }
        }


        System.out.println(ans);


    }
}