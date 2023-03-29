import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<ArrayList<int[]>> sumList;
    static ArrayList<int[]> mList;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        mList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    BFS(i, j, count++);
                    sumList.add(mList);
                }
            }
        }
        parent = new int[count];
        for (int i = 1; i < count; i++) { //5
            parent[i] = i;
        }
        PriorityQueue<Island> queue = new PriorityQueue<>();
        for (int i = 0; i < sumList.size(); i++) {
            ArrayList<int[]> now = sumList.get(i);
            for (int j = 0; j < now.size(); j++) {
                int r = now.get(j)[0];
                int c = now.get(j)[1];
                int now_S = map[r][c];

                for (int d = 0; d < 4; d++) {
                    int tempR = dx[d];
                    int tempC = dy[d];
                    int bridge = 0;

                    while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M)
                    {
                        if (map[r + tempR][c + tempC] == now_S) {
                            break;
                        } else if (map[r + tempR][c + tempC] != 0) {
                            if (bridge > 1) {
                                queue.offer(new Island(now_S, map[r + tempR][c + tempC], bridge));
                            }
                            break;
                        }
                        else
                            bridge++;

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
            }
        }
        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Island now = queue.poll();
            if (find(now.x) != find(now.y)) {
                union(now.x, now.y);
                result += now.value;
                useEdge++;
            }
        }
        if (useEdge == count - 2) {
            System.out.println(result);
        }
        else
            System.out.println(-1);
    }

    public static void BFS(int x, int y, int num) {
        Queue<Island> queue = new LinkedList<>();
        sumList = new ArrayList<>();
        queue.add(new Island(x, y, num));
        visited[x][y] = true;
        map[x][y] = num;
        mList.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            Island now = queue.poll();
            int r = now.x;
            int c = now.y;

            for (int i = 0; i < 4; i++) {
                int tempR = dx[i];
                int tempC = dy[i];

                while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
                    if (!visited[r + tempR][c + tempC] && map[r + tempR][c + tempC] != 0) {
                        map[r + tempR][c + tempC] = now.value;
                        visited[r + tempR][c + tempC] = true;
                        queue.add(new Island(r + tempR, c + tempC, now.value));
                        mList.add(new int[]{r + tempR, c + tempC});
                    }
                    else
                        break;

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
        }
    }


    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        else
            return parent[x] = find(parent[x]);
    }
}
class Island implements Comparable<Island>
{
    int x, y, value;

    public Island(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
    public Island(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Island o) {
        return this.value - o.value;
    }
}