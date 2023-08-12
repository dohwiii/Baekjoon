import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map;
    static int N;
    static boolean[] isSelected;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            isSelected = new boolean[N];
            map = new int[N][N];
            min = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            makeIngredient(0, 0);
            sb.append("#" + (i + 1)).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());

    }

    public static void findMin() {
        int A = 0;
        int B = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isSelected[i] && isSelected[j]) { //A 음식이라면
                    A += map[i][j] + map[j][i];
                }
                else if (!isSelected[i] && !isSelected[j]) { //B 음식
                    B += map[i][j] + map[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(A - B));
    }

    public static void makeIngredient(int start, int cnt) {
        if (cnt == N / 2) {
            findMin();
            return;

        }
        for (int i = start; i < N; i++) { //0,1,2,3
            if (isSelected[i]) {
                continue;
            }
            isSelected[i] = true;
            makeIngredient(i + 1, cnt + 1);
            isSelected[i] = false;
        }
    }
}