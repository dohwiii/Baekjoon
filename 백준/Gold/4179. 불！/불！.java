
import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Pos> fQueue = new ArrayDeque<>();
    static Queue<Pos> jQueue = new ArrayDeque<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());   //행
        C = Integer.parseInt(st.nextToken());   //열
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'J') { //시작위치
                    jQueue.offer(new Pos(i, j));
                    visited[i][j] = true;
                }
                else if (map[i][j] == 'F') {    //불 위치
                    fQueue.offer(new Pos(i, j));
                }
            }
        }
        fire();
        if (answer == 0) {
            System.out.println("IMPOSSIBLE ");
        }
        else {
            System.out.println(answer);
        }

    }

    public static void fire() {

        while (jQueue.size() > 0 || fQueue.size() > 0) {
            int jSize = jQueue.size();
            int fSize = fQueue.size();

            //불
            while (fSize-- > 0) {
                Pos now = fQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = 'F';  //확산
                            fQueue.offer(new Pos(nx, ny));
                        }
                    }
                }
            }

            //지훈
            while (jSize-- > 0) {
                Pos now = jQueue.poll();
                //가장자리
                if (now.x == 0 || now.x == R - 1 || now.y == 0 || now.y == C - 1) {
                    answer = now.cnt + 1;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (!visited[nx][ny] && map[nx][ny] == '.') {
                            jQueue.offer(new Pos(nx, ny, now.cnt + 1));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }



        }
    }

}

class Pos {
    int x, y, cnt;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pos(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}