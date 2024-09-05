
import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] bridge;
    static int[] dx = {1, -1};
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        bridge = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        S = Integer.parseInt(br.readLine());    //출발점

        move(S);  // 출발점에서 이동 시작
        System.out.println(cnt);  // 방문 가능한 돌 개수 출력
    }

    public static void move(int x) {
        if (x <= 0 || x > N || visited[x]) {
            return;
        }
        cnt++;
        visited[x] = true;
        int jump = bridge[x];

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * jump;
            move(nx);
        }
    }

}
