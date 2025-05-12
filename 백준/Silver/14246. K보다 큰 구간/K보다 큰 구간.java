import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        int s = 0, e = 0;
        long sum = 0;
        long ans = 0;
        while (s < N && e < N) {
            sum += arr[e];
            while (sum > K) {
                sum -= arr[s];
                s++;
            }
            e++;
            ans += s;
        }
        System.out.println(ans);
    }
}