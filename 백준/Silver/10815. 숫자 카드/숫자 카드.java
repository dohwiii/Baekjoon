import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 4500;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[mod][mod];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken()) + 10_000_000;
            arr[k / mod][k % mod]++;
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(st.nextToken()) + 10_000_000;
            sb.append(arr[k / mod][k % mod]).append(" ");
        }
        System.out.println(sb);
    }
}