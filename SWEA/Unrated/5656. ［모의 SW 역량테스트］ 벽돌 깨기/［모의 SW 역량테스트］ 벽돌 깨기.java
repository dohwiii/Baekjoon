import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, W, H;
    static int[][] map, copy;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] marbles; //N개 뽑은 구슬 담은 배열
    static int result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //구슬
            W = Integer.parseInt(st.nextToken()); //가로
            H = Integer.parseInt(st.nextToken()); //세로
            map = new int[H][W]; //HxW
            copy = new int[H][W];
            marbles = new int[N];
            result = Integer.MAX_VALUE;
            visited = new boolean[W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = copy[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            permutation(0);
            sb.append("#" + (t + 1) + " ");
            sb.append(result);
            sb.append("\n");

        }
        System.out.println(sb);


    }

    public static void permutation(int depth) {
        if (depth == N) { //구슬 N개 뽑은 후 게임 시작
            start(marbles); //시작 좌표
            result = Math.min(result, countMap());
            copyMap(); //map 초기화
            return;
        }
        for (int i = 0; i < W; i++) {
            marbles[depth] = i;
            permutation(depth + 1);

        }
    }

    public static void start(int[] arr) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < N; i++) { //구슬 개수
            for (int j = 0; j < H; j++) { //행만 돔
                if (map[j][arr[i]] != 0) {
                    x = j;
                    y = arr[i];
                    break;
                }
            }
            bfs(x, y);
            downMap(); //내리기
        }

    }

    public static void bfs(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(x, y, map[x][y]));
        map[x][y] = 0;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 1; i < now.value; i++) {
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j] * i;
                    int ny = now.y + dy[j] * i;

                    if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                        continue;
                    }
                    if (map[nx][ny] == 0) {
                        continue;
                    }
                    if (map[nx][ny] != 0) {
                        queue.add(new Pos(nx, ny, map[nx][ny]));
                        map[nx][ny] = 0; //터트림
                    }

                }
            }

        }

    }

    public static void downMap() {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < W; i++) { //열
            for (int j = 0; j < H; j++) { //행
                if (map[j][i] != 0) {
                    stack.push(map[j][i]);
                }
            }
            for (int j = H - 1; j >= 0; j--) {
                if (stack.isEmpty()) {
                    map[j][i] = 0;
                } else {
                    map[j][i] = stack.pop();
                }
            }

        }

    }

    public static int countMap() {
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void copyMap() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = copy[i][j];
            }
        }
    }
}

class Pos {
    int x, y, value;

    public Pos(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

}