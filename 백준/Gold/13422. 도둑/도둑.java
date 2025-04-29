import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //집의 개수
            int M = Integer.parseInt(st.nextToken());   //M개의 집 털음
            int K = Integer.parseInt(st.nextToken());   //최소 돈 K
            int len = N + M;    //8 + 3 = 11
            int[] money = new int[len];
            int ans = 0;
            int total = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                money[i] = Integer.parseInt(st.nextToken());
                total += money[i];
            }
            for (int i = N; i < len; i++) {
                money[i] = money[i - N];
            }
            for (int i = 1; i < len; i++) {
                money[i] += money[i - 1];   //누적합
            }

            if (N == M) {
                if (total >= K) {
                    ans = 0;
                } else {
                    ans = 1;
                }
            } else {
                int r = M;
                while (r < len) {
                    if (money[r] - money[r - M] < K) {
                        ans++;
                    }
                    r++;
                }
            }
            
            sb.append(ans + "\n");
        }
        System.out.println(sb);


    }
}