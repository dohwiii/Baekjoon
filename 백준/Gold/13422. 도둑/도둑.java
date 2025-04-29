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
            int[] money = new int[N];
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                money[i] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            for (int i = 0; i < M; i++) {
                sum += money[i];
            }
            if (sum < K) {
                ans++;
            }
            if (N != M) {
                for (int j = 1; j < N; j++) {
                    int end = (j + M - 1) % N;
                    sum -= money[j - 1];
                    sum += money[end];
                    if (sum < K) {
                        ans++;
                    }
                }
            }

            sb.append(ans + "\n");
        }
        System.out.println(sb);


    }
}