import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //주문
        int M = Integer.parseInt(st.nextToken());   //치즈버거
        int K = Integer.parseInt(st.nextToken());   //감자튀김
        int[][] orders = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            orders[i][0] = Integer.parseInt(st.nextToken());   //치즈버거
            orders[i][1] = Integer.parseInt(st.nextToken());   //감자튀김
        }
        int[][] dp = new int[M + 1][K + 1];

        for (int i = 0; i < N; i++) {
            int cheese = orders[i][0];
            int potato = orders[i][1];

            for (int j = M; j >= cheese; j--) {
                for (int k = K; k >= potato; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - cheese][k - potato]+1);

                }
            }

        }


        System.out.println(dp[M][K]);


    }
}
