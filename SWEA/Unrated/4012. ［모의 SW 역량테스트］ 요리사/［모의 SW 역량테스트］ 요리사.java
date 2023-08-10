import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, dishNum;
    static int[][] map;
    static int[] dishA, dishB;
    static boolean[] visited;
    static int min;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            min = Integer.MAX_VALUE;
            dishNum = N / 2; //두개의 요리에 들어갈 재료의 개수
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[N];
            pick(0, 0);
            sb.append("#" + (i + 1) + " ");
            sb.append(min);
            System.out.println(sb);

        }
    }

    public static void pick(int start, int cnt) {
        //2/N개 뽑혔다면 끝
        if (cnt == dishNum) {
            cook();
            return;
        }
        for (int i = start; i < N; i++) {
            visited[i] = true;
            pick(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    public static void cook() {
        int A = 0;
        int B = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    A += map[i][j] + map[j][i];
                }
                if (!visited[i] && !visited[j]) {
                    B += map[i][j] + map[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(A - B));
    }
}