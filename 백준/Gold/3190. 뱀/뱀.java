import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[] dx = {1, -1, 0, 0}; //남, 북, 동, 서
    static int[] dy = {0, 0, 1, -1};
    static Dir[] snake;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //보드 크기
        int K = Integer.parseInt(br.readLine()); //사과 개수
        board = new int[N + 1][N + 1];

        for (int i = 0; i < K; i++) { //사과 위치
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 1; //사과가 있는 곳은 1
        }
        int L = Integer.parseInt(br.readLine()); //방향 변환 횟수
        snake = new Dir[L];

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char y = st.nextToken().charAt(0);
            snake[i] = new Dir(x, y);
        }
        SnakeGame(0, 0);
        System.out.println(ans);
    }
    public static void SnakeGame(int x, int y) {
        Deque<Pos> deque = new ArrayDeque<>();
        deque.add(new Pos(x, y, 2));
        ans = 0;

        while (!deque.isEmpty()) {
            Pos now = deque.peekFirst();

            int nowDir = now.dir; //2
            int nx = now.x + dx[nowDir];
            int ny = now.y + dy[nowDir];
            ans++;

            //벽에 부딪히면 바로 초 return
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                return;
            }
            for (Pos elem : deque) {
                if (elem.x == nx && elem.y == ny) {
                    return;
                }
            }
            //벽에 부딪히지 않았을 때
            if (board[nx][ny] == 1) {  //사과 있다면
                for (Dir c : snake) {
                    if (c.time == ans) {
                        nowDir = changeDir(nowDir, c.dir);
                    }
                }
                board[nx][ny] = 0;
                deque.addFirst(new Pos(nx, ny, nowDir));
            }
            else if (board[nx][ny] == 0) { //사과 없음
                for (Dir c : snake) {
                    if (c.time == ans) {
                        nowDir = changeDir(nowDir, c.dir);
                    }
                }
                deque.addFirst(new Pos(nx, ny, nowDir));
                deque.pollLast();

            }
        }
    }
    public static int changeDir(int nowDir, char chDir) {
        int resultDirIndex = 0;

        if (chDir == 'D') //우회전
        {
            switch (nowDir) {
                case 0:
                    resultDirIndex = 3; break;
                case 1:
                    resultDirIndex = 2; break;
                case 2: //북쪽 우회전하면 오른쪽
                    resultDirIndex = 0; break;
                case 3: //남쪽 우회전 서쪽 왼쪽
                    resultDirIndex = 1; break;
            }
        } else if (chDir == 'L')  //좌회전
        {
            switch (nowDir) {
                case 0:
                    resultDirIndex = 2; break;
                case 1:
                    resultDirIndex = 3; break;
                case 2: //북쪽 우회전하면 오른쪽
                    resultDirIndex = 1; break;
                case 3: //남쪽 우회전 서쪽 왼쪽
                    resultDirIndex = 0; break;
            }
        }
        return resultDirIndex;
    }
}

class Pos {
    int x, y, dir;
    public Pos(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
class Dir {
    int time;
    char dir;
    public Dir(int time, char dir) {
        this.time = time;
        this.dir = dir;
    }
}