import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static String[][] totalArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine()); //배열 크기
            map = new int[N][N];
            totalArr = new String[N][3];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            rotate(0, map);
            System.out.println("#" + (i + 1));
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(totalArr[j][k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void rotate(int count, int[][] temp) {
        int[][] temp2 = new int[N][N];
        if (count > 2) {
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp2[j][N - 1 - i] = temp[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            String s = "";
            for (int j = 0; j < N; j++) {
                String str = temp2[i][j] + "";
                s += str;
            }
            totalArr[i][count] = s;
        }
        rotate(count + 1, temp2);
    }
}