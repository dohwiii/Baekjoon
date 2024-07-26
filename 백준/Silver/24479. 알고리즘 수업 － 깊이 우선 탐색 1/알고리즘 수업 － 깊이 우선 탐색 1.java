import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<Integer>[] list;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());   //정점 개수
        M = Integer.parseInt(st.nextToken());   //간선 개수
        R = Integer.parseInt(st.nextToken());   //시작 정점

        arr = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
            list[B].add(A);
        }
        for (int i = 1; i <= N; i++) {
            list[i].sort(Comparator.naturalOrder());
        }
        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int now) {
        arr[now] = cnt++;

        for (int next : list[now]) {
            if (arr[next] == 0) {
                dfs(next);
            }
        }

    }
}
