import javax.swing.text.Position;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //수빈 위치
        int K = Integer.parseInt(st.nextToken());   //동생 위치
        int[] dp = new int[100001];
        int[] arr = new int[100001];
        Queue<Hide> queue = new ArrayDeque<>();
        queue.offer(new Hide(N, 0));
        int[] dx = {2, -1, 1};
        for (int i = 0; i < 100001; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[N] = 0;

        while (!queue.isEmpty()) {
            Hide now = queue.poll();

            if (dp[now.x] < now.cnt) {
                continue;
            }
            if (now.x == K) {
                break;
            }
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = now.x * dx[i];
                }
                else {
                    nx = now.x + dx[i];
                }

                if (nx < 0 || nx > 100000) {
                    continue;
                }
                if (dp[nx] > now.cnt + 1) {
                    dp[nx] = now.cnt + 1;
                    arr[nx] = now.x;
                    queue.offer(new Hide(nx, now.cnt + 1));
                }
            }

        }
        Stack<Integer> reverse = new Stack<>();
        System.out.println(dp[K]);
        int index = K;
        reverse.push(K);

        while (index != N) {
            int num = arr[index];
            reverse.push(num);
            index = num;
        }
        while (!reverse.isEmpty()) {
            bw.write(reverse.pop() + " ");
        }
        bw.flush();

    }

}

class Hide {
    int x;
    int cnt;

    public Hide(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}