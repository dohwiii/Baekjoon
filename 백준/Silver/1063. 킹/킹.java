
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] map;
    static Pos kingPos = new Pos(0, 0); //킹의 위치
    static Pos stonePos = new Pos(0, 0); //돌의 위치
    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1}; //북 동 남 서
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1}; //오른쪽위, 오른쪽아래, 왼쪽아래, 왼쪽위
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new String[8][8]; //체스판

        for (int i = 0; i < 8; i++) {
            int num = 8 - i;
            char ch = 'A';
            for (int j = 0; j < 8; j++) {
                map[i][j] = ch + String.valueOf(num);
                ch++;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j].equals(king)) {
                    kingPos = new Pos(i, j); //킹 위치
                }
                else if (map[i][j].equals(stone)) {
                    stonePos = new Pos(i, j); //돌 위치
                }
            }
        }
        int N = Integer.parseInt(st.nextToken()); //움직이는 횟수

        for (int i = 0; i < N; i++) {
            queue.add(br.readLine()); //동작
        }

        while (!queue.isEmpty()) {
            String nowCommand = queue.poll(); //현재 명령어
            int moveIndex = move(nowCommand); //현재 이동방향
            boolean isPossible = true;

            int nx = kingPos.x + dx[moveIndex];
            int ny = kingPos.y + dy[moveIndex];

            if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                kingPos = new Pos(nx, ny);
            }
            else {
                isPossible = false;
            }
            if (isPossible) {
                boolean isStonePossible = true;
                //킹과 돌이 만난다면 돌 이동
                if (kingPos.x == stonePos.x && kingPos.y == stonePos.y) {
                    int nsx = stonePos.x + dx[moveIndex];
                    int nsy = stonePos.y + dy[moveIndex];
                    if (nsx >= 0 && nsx < 8 && nsy >= 0 && nsy < 8) {
                        stonePos = new Pos(nsx, nsy);
                    }
                    else {
                        isStonePossible = false;
                    }
                }
                if (!isStonePossible) {
                    kingPos = new Pos(kingPos.x - dx[moveIndex], kingPos.y - dy[moveIndex]);
                }
            }

        }
        System.out.println(map[kingPos.x][kingPos.y]);
        System.out.println(map[stonePos.x][stonePos.y]);

    }

    public static int move(String command) {
        int nextIndex = 0;

        switch (command) {
            case "R" : { //오른쪽
                nextIndex = 1;
                break;
            }
            case "L" : { //왼쪽
                nextIndex = 3;
                break;

            }
            case "B" : { //아래
                nextIndex = 2;
                break;

            }
            case "T" : { //위
                nextIndex = 0;
                break;

            }
            case "RT" : { //오른쪽 위 대각선
                nextIndex = 4;
                break;

            }
            case "LT" : { //왼쪽 위 대각선
                nextIndex = 7;
                break;

            }
            case "RB" : { //오른쪽 아래 대각선
                nextIndex = 5;
                break;

            }
            case "LB" : { //왼쪽 아래 대각선
                nextIndex = 6;
                break;

            }
        }
        return nextIndex;
    }

}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}