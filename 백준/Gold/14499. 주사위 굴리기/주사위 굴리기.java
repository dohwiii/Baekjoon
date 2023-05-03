import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static Dice dice;
    static int[] dir;
    static int[] dx = {0, 0, -1, 1}; //동 서 북 남
    static int[] dy = {1, -1, 0, 0,};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dir = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            dir[i] = Integer.parseInt(st.nextToken());
        }
        dice(X, Y);


    }

    public static void dice(int x, int y) {
        dice = new Dice(0, 0, 0, 0, 0, 0);
        int nx = x;
        int ny = y;

        //이동한 칸이 0이 아니라면 주사위 바닥면으로 복사 && 그 칸은 0
        for (int i = 0; i < dir.length; i++)
        {
            int nowDir = dir[i]; //이동하는 명령 방향
            nx = nx + dx[nowDir - 1];
            ny = ny + dy[nowDir - 1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                nx = nx - dx[nowDir - 1];
                ny = ny - dy[nowDir - 1];
                continue;
            }

            moveDir(nowDir);

            if (map[nx][ny] == 0)  //이동한 칸이 0이 쓰여있다면, 주사위 바닥면에 쓰여 있는 수가 칸에 복사
            {
                map[nx][ny] = dice.down;
            }
            else if (map[nx][ny] != 0) //이동한 칸의 수가 0이 아니라면, 칸에 쓰여있는 수가 주사위 바닥면으로 복사, 그리고 칸은 0으로 됨
            {
                dice.down = map[nx][ny];
                map[nx][ny] = 0;
            }
            System.out.println(dice.up);
        }
    }

    public static void moveDir(int dir) {
        //현재 주사위 상태
        int up = dice.up;
        int down = dice.down;
        int right = dice.right;
        int left = dice.left;
        int front = dice.front;
        int behind = dice.behind;

        switch (dir) {
            case 1: //동
                dice.up = left;
                dice.down = right;
                dice.right = up;
                dice.left = down;
                dice.front = front;
                dice.behind = behind;
                break;
            case 2: //서
                dice.up = right;
                dice.down = left;
                dice.right = down;
                dice.left = up;
                dice.front = front;
                dice.behind = behind;
                break;
            case 3: //북
                dice.up = front;
                dice.down = behind;
                dice.right = right;
                dice.left = left;
                dice.front = down;
                dice.behind = up;
                break;
            case 4: //남
                dice.up = behind;
                dice.down = front;
                dice.right = right;
                dice.left = left;
                dice.front = up;
                dice.behind = down;
                break;
        }
    }
}

class Dice {
    int up, down, front, behind, right, left;
    public Dice(int up, int down, int front, int behind, int right, int left) {
        this.up = up;
        this.down = down;
        this.front = front;
        this.behind = behind;
        this.right = right;
        this.left = left;
    }
}
