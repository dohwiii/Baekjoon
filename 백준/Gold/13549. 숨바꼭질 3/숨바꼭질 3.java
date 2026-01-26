import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dir = {1, -1};
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.offer(new Pos(N, 0));
        int[] dp = new int[100_001];
        Arrays.fill(dp, 100_001);
        dp[N] = 0;

        while (!pq.isEmpty()) {
            Pos now = pq.poll();
            if (dp[now.pos] < now.cnt) {
                continue;
            }
            if (now.pos == K) {
                break;
            }

            for (int i = 0; i < 2; i++) {
                int nx = now.pos + dir[i];
                if (nx < 0 || nx > 100_000) {
                    continue;
                }
                if (dp[nx] > dp[now.pos] + 1) {
                    dp[nx] = dp[now.pos] + 1;
                    pq.offer(new Pos(nx, dp[nx]));
                }
            }
            int nx = now.pos * 2;
            if (nx < 0 || nx > 100_000) {
                continue;
            }
            if (dp[nx] > dp[now.pos]) {
                dp[nx] = dp[now.pos];
                pq.offer(new Pos(nx, now.cnt));
            }

        }
        System.out.println(dp[K]);


    }
    static class Pos implements Comparable<Pos> {
        int pos, cnt;

        public Pos(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cnt - o.cnt;
        }
    }

}