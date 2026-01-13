import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        int cnt = 0;
        boolean[] visited = new boolean[100_001];
        visited[N] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;

            while (size-- > 0) {
                int now = queue.poll();

                if (now == K) {
                    System.out.println(cnt - 1);
                    return;
                }
                int r1 = now - 1;
                if (r1 >= 0 && r1 <= 100_000 && !visited[r1]) {
                    visited[r1] = true;
                    queue.offer(r1);
                }
                int r2 = now + 1;
                if (r2 >= 0 && r2 <= 100_000 && !visited[r2]) {
                    visited[r2] = true;
                    queue.offer(r2);
                }
                if (now != 0) {
                    int r3 = 2 * now;
                    if (r3 >= 0 && r3 <= 100_000 && !visited[r3]) {
                        visited[r3] = true;
                        queue.offer(r3);
                    }
                }

            }


        }

    }

}