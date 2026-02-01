import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0,};
    static int[][] map;
    static Map<Integer, Character> dirMap;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 보드 크기
        int K = Integer.parseInt(br.readLine());    // 사과의 개수
        map = new int[N][N];
        visited = new boolean[N][N];
        dirMap = new HashMap<>();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = 1;  // 사과
        }
        int L = Integer.parseInt(br.readLine());    // 방향 변환 횟수
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            dirMap.put(X, C);
        }
        System.out.println(game());

    }

    private static int game() {
        int sec = 0;
        int x = 0, y = 0;
        int dir = 0;
        int[] head = new int[2];
        int[] tail = new int[2];
        int preX = 0, preY = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});

        while (true) {
            x += dx[dir];
            y += dy[dir];
            sec++;  // 초 증가

            // 벽 부딪힘
            if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y]) {
                return sec;
            }
            visited[x][y] = true;
            queue.offer(new int[]{x, y});
            // 머리
            head[0] = x;
            head[1] = y;

            if (map[x][y] == 1) {   // 사과가 있다면
                map[x][y] = 0;  // 사과 먹음
            }
            else {  // 사과가 없다면 -> 꼬리있는 칸 한칸 앞으로
                visited[tail[0]][tail[1]] = false;
                queue.poll();
                int[] arr = queue.peek();
                tail[0] = arr[0];
                tail[1] = arr[1];
            }
            if (dirMap.containsKey(sec)) {
                char changeDir = dirMap.get(sec);
                if (changeDir == 'L') { // 왼쪽
                    dir = (dir + 3) % 4;
                } else if (changeDir == 'D') {  // 오른쪽
                    dir = (dir + 1) % 4;
                }
            }
        }
    }


}