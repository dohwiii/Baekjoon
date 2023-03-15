import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R, C;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }
        DFS(0, 0, 0);
        System.out.println(max);

    }

    public static void DFS(int x, int y, int count)
    {
        if (visited[board[x][y]])
        {
            if (max < count) {
                max = count;
            }
            return;
        }
        visited[board[x][y]] = true;

        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if (x1 >= 0 && y1 >= 0 && x1 < R && y1 < C)
            {
                DFS(x1, y1, count + 1);

            }
        }
        visited[board[x][y]] = false;
    }

}