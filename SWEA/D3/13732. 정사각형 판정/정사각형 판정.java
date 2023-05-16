import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Loop1:
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            char[][] map = new char[N][N];
            for (int j = 0; j < N; j++) {
                String str = br.readLine();
                for (int k = 0; k < N; k++) {
                    map[j][k] = str.charAt(k);
                }
            }
            int[] pos = {N + 1, N + 1, -1, -1};

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == '#') {
                        pos[0] = Math.min(pos[0], j);
                        pos[1] = Math.min(pos[1], k);
                        pos[2] = Math.max(pos[2], j);
                        pos[3] = Math.max(pos[3], k);
                    }
                }
            }
            isPossible = true;
            if (pos[2] - pos[0] != pos[3] - pos[1]) {
                isPossible = false;
            }
            for (int j = pos[0]; j <= pos[2]; j++) {
                for (int k = pos[1]; k <= pos[3]; k++) {
                    if (map[j][k] != '#') {
                        isPossible = false;
                    }
                }
            }
            if (isPossible) {
                System.out.println("#" + (i + 1) + " " + "yes");
            }
            else
                System.out.println("#" + (i + 1) + " " + "no");
        }
    }
}