import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int N, M, R, C, L;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); //테스트 개수

        for (int t = 0; t < T; t++) {
            sb.append("#").append((t + 1)).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //세로
            M = Integer.parseInt(st.nextToken()); //가로
            R = Integer.parseInt(st.nextToken()); //맨홀 세로
            C = Integer.parseInt(st.nextToken()); //맨홀 가로
            L = Integer.parseInt(st.nextToken()); //탈출 소요시간
            map = new int[N][M];
            visited = new boolean[N][M];
            ans = 1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            manhole(R, C);
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());

    }

    public static void manhole(int x, int y) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(x, y));
        visited[x][y] = true;
        int time = 1;

        while (!queue.isEmpty()) {
            int size = queue.size(); //한시간에 이동하는 좌표를 알기 위해 시간마다 갈 수 있는 좌표들을 같이 체킹해야함 모두 다 도는 단위로 시간추가
            if (time == L) {
                return;
            }
            while (size-- > 0) {
                Pos now = queue.poll();
                int nowType = map[now.x][now.y]; //현재 터널 모양

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    //범위를 벗어났다면 X
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }
                    //터널이 없거나, 방문을 이미 했으면 X
                    if (visited[nx][ny] || map[nx][ny] == 0) {
                        continue;
                    }
                    int nextType = map[nx][ny]; //갈 수 있는 터널이라면

                    switch (i) {
                        case 0: //위
                            if (nowType == 1 || nowType == 2 || nowType == 4 || nowType == 7) { //위 방향
                                if (nextType == 1 || nextType == 2 || nextType == 5 || nextType == 6) { //아래 방향
                                    visited[nx][ny] = true;
                                    queue.offer(new Pos(nx, ny));
                                    ans++;
                                }
                            }
                            break;
                        case 1: //오른쪽
                            if (nowType == 1 || nowType == 3 || nowType == 4 || nowType == 5) { //오른쪽 방향
                                if (nextType == 1 || nextType == 3 || nextType == 6 || nextType == 7) { //왼쪽 방향
                                    visited[nx][ny] = true;
                                    queue.offer(new Pos(nx, ny));
                                    ans++;
                                }
                            }
                            break;
                        case 2: //아래
                            if (nowType == 1 || nowType == 2 || nowType == 5 || nowType == 6) { //아래
                                if (nextType == 1 || nextType == 2 || nextType == 4 || nextType == 7) { //위
                                    visited[nx][ny] = true;
                                    queue.offer(new Pos(nx, ny));
                                    ans++;
                                }
                            }
                            break;
                        case 3: //왼쪽
                            if (nowType == 1 || nowType == 3 || nowType == 6 || nowType == 7) { //왼쪽 방향
                                if (nextType == 1 || nextType == 3 || nextType == 4 || nextType == 5) { //오른쪽 방향
                                    visited[nx][ny] = true;
                                    queue.offer(new Pos(nx, ny));
                                    ans++;
                                }
                            }
                            break;
                    }
                }
            }
            time++;
        }
    }
}
class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}