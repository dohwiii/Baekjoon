
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static int[][][] dp;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        dp = new int[2][N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[0][i], Integer.MIN_VALUE);   //최댓값
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[1][i], Integer.MAX_VALUE);   //최솟값
            }
        }
        dp[0][0][0] = map[0][0] - '0';  //최대
        dp[0][0][1] = map[0][0] - '0';  //최소

        dfs(0, 0, map[0][0] - '0', 'X', 0);
        dfs(0, 0, map[0][0] - '0', 'X', 1);

        bw.write(dp[0][N - 1][N - 1] + " " + dp[1][N - 1][N - 1]);
        bw.flush();
    }

    public static void dfs(int x, int y, int value, char operator, int flag) {

        for (int i = 0; i < 2; i++) {   //오른쪽, 아래
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (map[nx][ny] == '+' || map[nx][ny] == '-' || map[nx][ny] == '*') {   //연산자라면
                dfs(nx, ny, value, map[nx][ny], flag);

            }
            else {  //숫자라면
                int calResult = cal(value, map[nx][ny] - '0', operator);
                if (flag == 0) {
                    if (dp[flag][nx][ny] != Integer.MIN_VALUE) {    //이미 방문한 곳이라면
                        dp[flag][nx][ny] = Math.max(dp[flag][nx][ny], calResult);
                    }
                    else {
                        dp[flag][nx][ny] = calResult;
                    }
                }
                else {
                    if (dp[flag][nx][ny] != Integer.MAX_VALUE) {    //이미 방문한 곳이라면  
                        dp[flag][nx][ny] = Math.min(dp[flag][nx][ny], calResult);
                    }
                    else {
                        dp[flag][nx][ny] = calResult;
                    }
                }
                dfs(nx, ny, dp[flag][nx][ny], operator, flag);
            }
        }
    }

    public static int cal(int x, int y, char operator) {
        switch (operator) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
        }
        return 0;
    }

}
