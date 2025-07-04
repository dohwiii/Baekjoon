import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        long lo = 0, hi = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            hi = Math.max(hi, trees[i]);
        }
        long ans = 0;
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            long diff = 0;
            for (int i = 0; i < N; i++) {
                if (trees[i] <= mid) {   //이 높이보다 작은 나무들은 베지 못함
                    continue;
                }
                diff += (trees[i] - mid);
            }
            if (diff >= M) {
                ans = Math.max(ans, mid);
                lo = mid + 1;
            }
            else if (diff < M) {
                hi = mid;
            }
        }
        System.out.println(ans);
    }
}