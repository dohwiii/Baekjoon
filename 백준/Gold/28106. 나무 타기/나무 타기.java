import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 998_244_353;
    static int N;
    static List<Integer>[] tree;
    static int[] strength;
    static int answer;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());    //정점의 수
        strength = new int[N + 1];  //강도
        dp = new int[N + 1];  //강도
        tree = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tree[Integer.parseInt(st.nextToken())].add(i);  //부모 노드 -> 자식노드
        }
        int root = tree[0].get(0);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            strength[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);
        bw.write(dfs(root) + " ");
        bw.flush();

    }

    public static int dfs(int now) {
        if (tree[now].isEmpty()) {    //목적지(리프노드)
            return 1;
        }

        if (dp[now] != -1) {
            return dp[now];
        }
        dp[now] = 0;

        if (strength[now] == 0) {
            return 0;
        }

        List<Integer> children = getChild(now);
        for (int next : children) {
            dp[now] += dfs(next);
            dp[now] %= MOD;
        }

        return dp[now] % MOD;
    }

    public static List<Integer> getChild(int parent) {
        List<Integer> children = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(parent, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.depth >= 1 && now.depth <= strength[parent]) {
                children.add(now.num);
            }
            if (now.depth > strength[parent]) {
                break;
            }
            for (int child : tree[now.num]) {
                queue.offer(new Node(child, now.depth + 1));
            }
        }
        return children;
    }

}

class Node {
    int num;
    int depth;

    public Node(int number, int depth) {
        this.num = number;
        this.depth = depth;
    }
}