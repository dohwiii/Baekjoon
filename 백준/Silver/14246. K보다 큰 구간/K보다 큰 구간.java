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

        long sum = 0;
        int s = 1, e = 1;
        long ans = 0;

        while (s <= N && e <= N) {
            while (e <= N && sum + arr[e] <= K) {
                sum += arr[e];
                e++;
            }
            ans += (N - e + 1);
            sum -= arr[s];
            s++;
        }

        System.out.println(ans);


    }
}