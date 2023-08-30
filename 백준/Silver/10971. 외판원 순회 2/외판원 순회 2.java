import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N;
    static int[][] money;
    static int min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        money = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                money[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            travel(i, i, 0, 0);
        }
        System.out.println(min);

    }

    public static void travel(int start, int now, int sum, int depth) {

        if (depth == N - 1) {
            if (money[now][start] > 0) {
                sum += money[now][start];
                min = Math.min(min, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && money[now][i] > 0) {
                visited[i] = true;
                travel(start, i, sum + money[now][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}