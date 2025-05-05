import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        int s = 0, e = N - 1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum == S) {
                s++;
                e--;
                ans++;
            } else if (sum > S) {
                e--;
            }
            else {
                s++;
            }
        }
        System.out.println(ans);

    }
}