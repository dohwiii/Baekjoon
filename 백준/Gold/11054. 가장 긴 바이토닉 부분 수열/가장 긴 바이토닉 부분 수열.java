import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp_inc = new int[N];
        int[] dp_dec = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp_inc, 1);
        Arrays.fill(dp_dec, 1);

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] < arr[j]) {
                    dp_inc[j] = Math.max(dp_inc[j], dp_inc[i] + 1);
                }
            }
        }
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    dp_dec[j] = Math.max(dp_dec[j], dp_dec[i] + 1);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int result = dp_inc[i] + dp_dec[i] - 1;
            answer = Math.max(answer, result);
        }
        System.out.println(answer);
    }
}
