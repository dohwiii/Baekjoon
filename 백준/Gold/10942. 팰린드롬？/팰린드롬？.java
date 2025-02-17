import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;   //팰린드롬 true
        }
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }
        for (int i = 2; i < N; i++) {
            for (int j = 1; j + i <= N; j++) {
                int end = j + i;
                if (arr[j] == arr[end]) {
                    if (dp[j + 1][end - 1] == 1) {
                        dp[j][end] = 1;
                    }
                }
            }
        }
        int M = Integer.parseInt(br.readLine());    //질문 개수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            bw.write(dp[S][E] + "\n");
        }
        bw.flush();
        bw.close();


    }
}
