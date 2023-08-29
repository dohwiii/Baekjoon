import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] colors;
    static int[][] D;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colors = new int[N + 1][3];
        D = new int[N + 1][3];
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) { //집
            for (int j = 0; j < 3; j++) { //i번째 집의 빨, 초, 파
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < 3; k++) { //빨, 초, 파
                    if (j != k) {
                        min = Math.min(min, D[i - 1][k]); //이전의 비용 중 최소
                    }
                }
                D[i][j] = min + colors[i][j];

            }
        }
        for (int i = 0; i < 3; i++) { //마지막 행의 최솟값
            ans = Math.min(ans, D[N][i]);
        }
        System.out.println(ans);
    }
}
