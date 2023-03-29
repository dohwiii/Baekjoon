import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<ArrayList<int[]>> sumList;
    static ArrayList<int[]> mList;
    static Queue<int[]> queue;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        sumList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    Numbering(i, j, count++);
                    sumList.add(mList);
                }
            }
        }
        queue = new LinkedList<>();
        visited = new boolean[N][N];

        for (int i = 0; i < sumList.size(); i++)
        {
            ArrayList<int[]> now = sumList.get(i);
            for (int j = 0; j < now.size(); j++)
            {
                int r = now.get(j)[0];
                int c = now.get(j)[1];

                makeBridge(r, c, map[r][c]);
            }
        }
        System.out.println(min);

    }
    public static void makeBridge(int a, int b, int v)
    {
        visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b, 0});
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[nx][ny] != 0 && map[nx][ny] != v) {
                        min = Math.min(min, now[2]);
                        return;
                    }
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, now[2] + 1});
                    }

                }
            }

        }

    }
    public static void Numbering(int a, int b, int v){
        queue = new LinkedList<>();
        mList = new ArrayList<>();
        queue.add(new int[]{a, b, v});
        visited[a][b] = true;
        map[a][b] = v;
        mList.add(new int[]{a, b});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r2 = pos[0];
            int c2 = pos[1];

            for (int i = 0; i < 4; i++) {
                int tempR = dx[i];
                int tempC = dy[i];

                if (r2 + tempR >= 0 && r2 + tempR < N && c2 + tempC >= 0 && c2 + tempC < N) {
                    if (!visited[r2 + tempR][c2 + tempC] && map[r2 + tempR][c2 + tempC] != 0) {
                        map[r2 + tempR][c2 + tempC] = pos[2];
                        visited[r2 + tempR][c2 + tempC] = true;
                        queue.add(new int[]{r2 + tempR, c2 + tempC, pos[2]});
                        mList.add(new int[]{r2 + tempR, c2 + tempC});
                    }
                }
            }
        }
    }
}
