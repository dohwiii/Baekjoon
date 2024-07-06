import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] fireVisited;
    static boolean[][] personVisited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Pos> fire;
    static Queue<Pos> person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            fireVisited = new boolean[N][M];
            personVisited = new boolean[N][M];
            fire = new ArrayDeque<>();
            person = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);

                    if (map[i][j] == '*') { //불
                        fire.offer(new Pos(i, j));
                    } else if (map[i][j] == '@') {  //상근
                        person.offer(new Pos(i, j, 0));
                        personVisited[i][j] = true;
                        map[i][j] = '.';    //빈공간으로 바꿔주기
                    }
                }
            }
            bw.write(bfs());
            bw.write("\n");
        }
        bw.flush();
    }

    public static String bfs() {

        while (person.size() > 0 || fire.size() > 0) {
            int fireSize = fire.size();
            int personSize = person.size();

            while (fireSize-- > 0) {
                Pos now = fire.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != '.') {
                        continue;
                    }
                    fire.offer(new Pos(nx, ny));
                    map[nx][ny] = '*';  //확산
                }
            }

            while (personSize-- > 0) {
                Pos now = person.poll();

                if (now.x == 0 || now.x == N - 1 || now.y == 0 || now.y == M - 1) {
                    return String.valueOf(now.cnt + 1);
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || personVisited[nx][ny]) {
                        continue;
                    }
                    if (map[nx][ny] == '.') {
                        person.offer(new Pos(nx, ny, now.cnt + 1));
                        personVisited[nx][ny] = true;
                    }
                }
            }

        }
        return "IMPOSSIBLE";
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