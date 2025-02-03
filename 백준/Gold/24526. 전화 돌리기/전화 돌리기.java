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

        // 안전한 정점을 판단하기 위한 큐 (outdegree 0인 정점)
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] safe = new boolean[N + 1];  // 해당 부원이 안전한지 여부

        // 초기 큐에 outdegree가 0인 정점 추가 (종결 상태)
        for (int i = 1; i <= N; i++) {
            if (outdeg[i] == 0) {
                queue.offer(i);
                safe[i] = true;
            }
        }

        // 역방향으로 안전 상태 전파
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // node로 전화가 넘어올 수 있는 모든 선행 정점에 대해 처리
            for (int pre : rev[node]) {
                outdeg[pre]--;  // pre에서 node로 가는 간선 제거 효과
                if (outdeg[pre] == 0 && !safe[pre]) {
                    safe[pre] = true;
                    queue.offer(pre);
                }
            }
        }

        // 안전한 부원(전화가 넘겨져도 사이클에 빠지지 않는 부원)의 수 세기
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (safe[i]) count++;
        }

        System.out.println(count);
    }
}