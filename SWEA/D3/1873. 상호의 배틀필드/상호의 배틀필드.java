import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int H, W;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Pos tank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == 'v') {
                        tank = new Pos(i, j, 0);
                    } else if (map[i][j] == '^') {
                        tank = new Pos(i, j, 1);
                    } else if (map[i][j] == '>') {
                        tank = new Pos(i, j, 2);
                    } else if (map[i][j] == '<') {
                        tank = new Pos(i, j, 3);
                    }
                }
            }
            int N = Integer.parseInt(br.readLine()); //명령어 개수
            String command = br.readLine();
            game(command);
            sb.append("#" + (t + 1) + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());


    }

    public static void game(String command) {
        for (int i = 0; i < command.length(); i++) {
            commandExecute(command, i);
        }
    }

    private static void commandExecute(String command, int i) {
        if (command.charAt(i) == 'S') { //포탄
            int nowDir = tank.dir;
            int tempR = dx[nowDir];
            int tempC = dy[nowDir];
            while (tank.x + tempR >= 0 && tank.x + tempR < H && tank.y + tempC >= 0 && tank.y + tempC < W) {
                if (map[tank.x + tempR][tank.y + tempC] == '*') { //벽돌 벽
                    map[tank.x + tempR][tank.y + tempC] = '.'; //벽 뿌시기 -> 평지 만들기
                    break;
                } else if (map[tank.x + tempR][tank.y + tempC] == '#') { //강철 벽 만나면 아무일 일어나지 않음
                    break;
                } else { //평지 or 물 전진 가능
                    if (tempR > 0) {
                        tempR++;
                    } else if (tempR < 0) {
                        tempR--;
                    }
                    if (tempC > 0) {
                        tempC++;
                    } else if (tempC < 0) {
                        tempC--;
                    }
                }
            }
        } else if (command.charAt(i) == 'U') {
            int nx = tank.x + dx[1];
            int ny = tank.y + dy[1];
            int nDir = 1;
            map[tank.x][tank.y] = '^'; //방향 전환
            
            if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                if (map[nx][ny] == '.') { //평지
                    map[nx][ny] = '^'; //모양 복제
                    map[tank.x][tank.y] = '.'; //탱크 이동했으니까 빈칸
                    tank = new Pos(nx, ny, nDir);
                } else {
                    tank = new Pos(tank.x, tank.y, nDir);
                }
            }else {
                tank = new Pos(tank.x, tank.y, nDir);
            }
        } else if (command.charAt(i) == 'D') {
            int nx = tank.x + dx[0];
            int ny = tank.y + dy[0];
            int nDir = 0;
            map[tank.x][tank.y] = 'v'; //방향 전환

            if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                if (map[nx][ny] == '.') { //평지
                    map[nx][ny] = 'v'; //모양 복제
                    map[tank.x][tank.y] = '.'; //탱크 이동했으니까 빈칸
                    tank = new Pos(nx, ny, nDir);
                } else {
                    tank = new Pos(tank.x, tank.y, nDir);
                }
            } else {
                tank = new Pos(tank.x, tank.y, nDir);
            }

        } else if (command.charAt(i) == 'L') {
            int nx = tank.x + dx[3];
            int ny = tank.y + dy[3];
            int nDir = 3;
            map[tank.x][tank.y] = '<'; //방향 전환
            
            if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                if (map[nx][ny] == '.') { //평지
                    map[nx][ny] = '<'; //모양 복제
                    map[tank.x][tank.y] = '.'; //탱크 이동했으니까 빈칸
                    tank = new Pos(nx, ny, nDir);
                } else {
                    tank = new Pos(tank.x, tank.y, nDir);
                }
            } else {
                tank = new Pos(tank.x, tank.y, nDir);
            }

        } else if (command.charAt(i) == 'R') {
            int nx = tank.x + dx[2];
            int ny = tank.y + dy[2];
            int nDir = 2;
            map[tank.x][tank.y] = '>'; //방향 전환
            
            if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                if (map[nx][ny] == '.') { //평지
                    map[nx][ny] = '>'; //모양 복제
                    map[tank.x][tank.y] = '.'; //탱크 이동했으니까 빈칸
                    tank = new Pos(nx, ny, nDir);
                } else {
                    tank = new Pos(tank.x, tank.y, nDir);
                }
            } else {
                tank = new Pos(tank.x, tank.y, nDir);
            }
        }
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