
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] weight;
    static int[] dp;
    static int min = Integer.MAX_VALUE;
    static Answer ans;
    static int totalWeight;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());    //대나무 개수
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        weight = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }
        for (int i = 1; i <= N; i++) {  //중요도
            weight[i] = Integer.parseInt(br.readLine());
            totalWeight += weight[i];
        }
        Arrays.fill(dp, -123456789);
        dfs(1, -1);

        bw.write(min + "\n");
        bw.write(ans.x + " " + ans.y);
        bw.flush();

    }

    public static int dfs(int now, int parent) {
        if (dp[now] != -123456789) {
            return dp[now];
        }

        dp[now] = weight[now];

        for (int next : list[now]) {
            if (next != parent) {
                dp[now] += dfs(next, now);
            }
        }
        if (parent != -1) {
            int diff = Math.abs(totalWeight - 2 * dp[now]);
            if (min > diff) {
                min = diff;
                ans = new Answer(parent, now);
            }
        }
        return dp[now];
    }

}

class Answer {
    int x, y;

    public Answer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}