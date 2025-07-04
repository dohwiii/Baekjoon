import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        long lo = 1, hi = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            hi = Math.max(hi, arr[i]);
        }
        long ans = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long line = 0;
            if (mid != 0) {
                for (int i = 0; i < K; i++) {
                    line += (arr[i] / mid);
                }
            }

            if (line >= N) {
                ans = Math.max(ans, mid);
                lo = mid + 1;
            }
            else {
                if (hi == mid) {
                    break;
                }
                hi = mid;
            }
        }
        System.out.println(ans);




    }
}