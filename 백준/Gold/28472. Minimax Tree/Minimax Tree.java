
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, R, L, Q;
    static List<Integer>[] list;
    static int[] weight;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //트리 정점 개수
        R = Integer.parseInt(st.nextToken());   //루트 번호

        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        weight = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }
        Arrays.fill(weight, -1);

        L = Integer.parseInt(br.readLine());   //리프 노드의 개수
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            weight[n] = v;
        }
        dfs(R, true, -1);

        Q = Integer.parseInt(br.readLine());   //구해야 할 노드의 개수
        for (int i = 0; i < Q; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(weight[n] + "\n");
        }

        bw.flush();

    }

    public static int dfs(int now, boolean isMax, int parent) {
        if (weight[now] != -1) {
            return weight[now];
        }

        int tempMax = -1;
        int tempMin = Integer.MAX_VALUE;

        for (int next : list[now]) {
            if (next != parent) {
                if (isMax) {    //최댓값
                    tempMax = Math.max(tempMax, dfs(next, !isMax, now));
                } else {  //최솟값
                    tempMin = Math.min(tempMin, dfs(next, !isMax, now));
                }
            }
        }
        if (isMax) {
            weight[now] = tempMax;
        }
        else {
            weight[now] = tempMin;
        }
        return weight[now];
    }

}