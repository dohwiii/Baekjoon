import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        solve(0, 0, N);
        System.out.println(sb);

    }

    public static void solve(int x, int y, int size) {
        if (isSame(x, y, size)) {
            sb.append(map[x][y]);
            return;
        }
        int newSize = size / 2;
        sb.append('(');
        solve(x, y, newSize);
        solve(x, y + newSize, newSize);
        solve(x + newSize, y, newSize);
        solve(x + newSize, y + newSize, newSize);

        sb.append(')');
    }

    public static boolean isSame(int x, int y, int size) {
        int fix = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (fix != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}