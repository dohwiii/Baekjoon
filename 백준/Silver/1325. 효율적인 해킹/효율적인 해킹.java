import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] count;
    static List<Integer>[] list;
    static boolean[][] visited; // 방문 여부 배열
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1][N + 1];
        count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 간선 입력 (B를 해킹하면 A도 해킹 가능)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[B].add(A);
        }

        int maxHacked = 0;

        // 모든 노드에 대해 BFS 실행
        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        // 최대 해킹 가능한 개수를 가진 노드 찾기
        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                sb.append(i + " ");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (visited[node][now]) {
                continue;
            }
            visited[node][now] = true;
            count[node]++;

            for (int next : list[now]) {
                if (visited[node][next]) {
                    continue;
                }
                if (next > node) {
                    queue.offer(next);
                }
                else {  //이미 탐색이 끝난 노드라면
                    for (int i = 1; i <= N; i++) {
                        if (visited[node][i]) {
                            continue;
                        }
                        if (visited[next][i]) {
                            visited[node][i] = true;
                            count[node]++;
                        }
                    }
                }
            }
        }
        max = Math.max(max, count[node]);
    }
}