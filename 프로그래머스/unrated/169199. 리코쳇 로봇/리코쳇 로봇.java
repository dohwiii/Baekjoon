import java.util.*;
class Solution {
    static char[][] map;
    static int N, M, result;
    static Coordinate start;
    static boolean isPossible = false;;
    public int solution(String[] board) {
        int answer = 0;
        map = new char[board.length][board[0].length()];
        N = board.length; //행
        M = board[0].length(); //열

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new Coordinate(i, j, 0);
                }
                map[i][j] = board[i].charAt(j);
            }
        }
        bfs();
        if (isPossible) {
            answer=result;
        }
        else {
            answer=-1;
        }
        return answer;
    }
    public static void bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] visited = new boolean[N][M];


        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();
            if (map[now.x][now.y] == 'G') {
                isPossible = true;
                result = now.cnt;
                return;
            }

            for (int i = 0; i < 4; i++)
            {
                int nx = now.x;
                int ny = now.y;
                visited[nx][ny] = true;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    //벽을 넘거나, 장애물에 부딪히면 스탑
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    if (map[nx][ny] == 'D') {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                if (map[nx][ny] != 'D' && !visited[nx][ny]) {
                    queue.offer(new Coordinate(nx, ny, now.cnt + 1));
                }
            }
        }
    }

}

class Coordinate {
    int x, y, cnt;
    public Coordinate(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
