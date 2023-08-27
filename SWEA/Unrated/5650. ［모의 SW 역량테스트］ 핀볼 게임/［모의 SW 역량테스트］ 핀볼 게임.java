import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};//상하우좌
    static int[] dy = {0, 0, 1, -1};
    static List<Pos>[] wormHoleList;
    static int maxScore;
    static boolean[] visitedDir;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            N = sc.nextInt(); //카드 수
            board = new int[N][N];
            wormHoleList = new ArrayList[5];
            maxScore = 0;
            visitedDir = new boolean[4];

            for (int i = 0; i < 5; i++) {
                wormHoleList[i] = new ArrayList<>();
            }
            for (int i = 0; i < N; i++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();

                    if (board[i][j] == 6) {
                        wormHoleList[0].add(new Pos(i, j));
                    } else if (board[i][j] == 7) {
                        wormHoleList[1].add(new Pos(i, j));
                    } else if (board[i][j] == 8) {
                        wormHoleList[2].add(new Pos(i, j));
                    } else if (board[i][j] == 9) {
                        wormHoleList[3].add(new Pos(i, j));
                    } else if (board[i][j] == 10) {
                        wormHoleList[4].add(new Pos(i, j));
                    }
                }
            }
            maxScore = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0) //빈칸에서만 시작 가능
                    {
                        for (int k = 0; k < 4; k++) //방향
                        {
                            dfs(i, j, k);
                        }
                    }
                }
            }
            sb.append("#").append(t + 1).append(" ");
            sb.append(maxScore);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y, int dir) {
        //해당 진행방향으로 이동
        int nowDir = dir;
        int nx = x;
        int ny = y;
        int cnt = 0;

        while (true) {
            nx += dx[nowDir];
            ny += dy[nowDir];

            //범위 안
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (board[nx][ny] == -1 || (x == nx && y == ny)) //블랙홀 만나거나, 출발위치 돌아온다면 탐색 끝
                {
                    maxScore = Math.max(maxScore, cnt); //최대 점수
                    return;
                }
                else if (board[nx][ny] >= 1 && board[nx][ny] <= 5) //블록이라면 방향이 바뀜
                {
                    //벽이나 블록을 만난다면 점수+1
                    nowDir = block(nowDir, board[nx][ny]); //다음 방향
                    cnt++;
                } else if (board[nx][ny] >= 6 && board[nx][ny] <= 10) { //웜홀을 만난다면
                    for (Pos p : wormHoleList[board[nx][ny] - 6]) {
                        if (p.x != nx || p.y != ny) { //다음 좌표의 웜홀 번호 쌍의 다른 좌표
                            nx = p.x;
                            ny = p.y;
                            break;
                        }
                    }
                }

            } else { //벽을 만난다면
                //벽을 만난다면 반대방향으로 회전하고, 점수+1
                //범위를 벗어났으므로 한칸 뒤로(가장자리 좌표)
                if (nowDir == 0 || nowDir == 1) {
                    nowDir = (nowDir == 0) ? 1 : 0;
                } else if (nowDir == 2 || nowDir == 3) {
                    nowDir = (nowDir == 2) ? 3 : 2;
                }
                cnt++;
            }

        }
    }

    public static int block(int nowDir, int blockNum) {
        int nextDir = 0;
        switch (nowDir) {
            case 0: //위
                if (blockNum == 1 || blockNum == 4 || blockNum == 5) //반대방향으로 바꿔야함
                {
                    nextDir = 1;
                } else if (blockNum == 2) //오른쪽
                {
                    nextDir = 2;
                } else if (blockNum == 3) //왼쪽
                {
                    nextDir = 3;
                }
                break;
            case 1: //아래
                if (blockNum == 2 || blockNum == 3 || blockNum == 5) //반대방향으로 바꿔야함
                {
                    nextDir = 0;
                } else if (blockNum == 1) //오른쪽
                {
                    nextDir = 2;
                } else if (blockNum == 4) //왼쪽
                {
                    nextDir = 3;
                }
                break;
            case 2: //오른쪽
                if (blockNum == 1 || blockNum == 2 || blockNum == 5) //반대방향으로 바꿔야함
                {
                    nextDir = 3;
                } else if (blockNum == 3) //오른쪽
                {
                    nextDir = 1;
                } else if (blockNum == 4) //왼쪽
                {
                    nextDir = 0;
                }
                break;
            case 3: //왼쪽
                if (blockNum == 3 || blockNum == 4 || blockNum == 5) //반대방향으로 바꿔야함
                {
                    nextDir = 2;
                } else if (blockNum == 1) //위
                {
                    nextDir = 0;
                } else if (blockNum == 2) //아래
                {
                    nextDir = 1;
                }
                break;
        }
        return nextDir;
    }


}

class Pos {
    int x, y, dir, cnt;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pos(int x, int y, int dir, int cnt) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cnt = cnt;
    }
}
