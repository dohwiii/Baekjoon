import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 부원 수
        int M = Integer.parseInt(st.nextToken()); // 관계 수

        // 원래 그래프와 역방향 그래프 생성 (1번부터 N번까지)
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        ArrayList<Integer>[] rev = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        // 각 정점의 outdegree 배열
        int[] outdeg = new int[N + 1];

        // 간선 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            rev[v].add(u);
            outdeg[u]++;  // u에서 나가는 간선 수 증가
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (outdeg[i] == 0) {
                queue.offer(i);
                answer++;
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int prev : rev[now]) {
                outdeg[prev]--;
                if (outdeg[prev] == 0) {
                    queue.offer(prev);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}