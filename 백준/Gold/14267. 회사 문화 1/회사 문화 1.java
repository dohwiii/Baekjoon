
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M;
    static long[] dp;
    static List<Integer>[] list;
    static boolean[] visited;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //회사의 직원 수
        M = Integer.parseInt(st.nextToken());   //최초의 칭찬 횟수
        int[] boss = new int[N + 1];
        dp = new long[N + 1];
        visited = new boolean[N + 1];
        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {   //직속 상사의 번호
            boss[i] = Integer.parseInt(st.nextToken());
            if (boss[i] == -1) {
                continue;
            }
            list[i].add(boss[i]);    //<상사, 직원>
        }
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp, -1);
        }
        dp[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int compliment = Integer.parseInt(st.nextToken());

            if (map.containsKey(employee)) {
                int value = map.get(employee);
                map.put(employee, value + compliment);
            }
            else {
                map.put(employee, compliment);
            }
        }
        for (int i = 2; i <= N; i++) {
            dfs(i);
        }


        for (int i = 1; i <= N; i++) {
            bw.write(dp[i] + " ");
        }
        bw.flush();


    }

    public static long dfs(int x) {
        if (dp[x] != -1) {
            return dp[x];
        }
        dp[x] = 0;
        if (map.get(x) != null) {
            dp[x] += map.get(x);
        }

        for (int boss : list[x]) {
            dp[x] += dfs(boss);
        }

        return dp[x];
    }
}
