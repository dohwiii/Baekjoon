import java.io.*;
import java.util.*;

public class Main {
    static int[][] nation;
    static int N, L, R;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visitedNation;
    static ArrayList<ArrayList<Pos>> totalList; //모든 연합국
    static ArrayList<Pos> nationList; //하나의 연합국

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        nation = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nation[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (true) {
            visitedNation = new boolean[N][N];
            boolean isMove = false;
            totalList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visitedNation[i][j]) {
                        bfs(i, j);
                        if (nationList.size() == 1) {
                            nationList.remove(new Pos(i, j));
                        }
                        else {
                            totalList.add(nationList);
                        }
                    }
                }
            }
            if (totalList.size() > 0) {
                isMove = true;
            }
            if (isMove) {
                for (ArrayList<Pos> now : totalList) {
                    int sum = 0;
                    int count = 0;
                    for (Pos p : now) {
                        sum += nation[p.x][p.y];
                        count++;
                    }
                    int newPopulation = (int) sum / count;
                    for (Pos p : now) {
                        nation[p.x][p.y] = newPopulation;
                    }
                }
                day++;
            }
            else
                break;
        }
        System.out.println(day);
    }

    public static void bfs(int x, int y) {
        Queue<Pos> queue = new LinkedList<Pos>();
        nationList = new ArrayList<>();
        queue.add(new Pos(x, y));
        nationList.add(new Pos(x, y));
        visitedNation[x][y] = true;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visitedNation[nx][ny]) {
                        int diff = Math.abs(nation[now.x][now.y] - nation[nx][ny]);
                        if (diff <= R && diff >= L) {
                            visitedNation[nx][ny] = true;
                            nationList.add(new Pos(nx, ny));
                            queue.add(new Pos(nx, ny));
                        }
                    }
                }
            }
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