import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //지름길 개수
        int D = Integer.parseInt(st.nextToken());   //고속도로 길이
        int[][] dp = new int[D + 1][D + 1];
        for (int i = 0; i <= D; i++) {  //시작위치
            for (int j = 0; j <= D; j++) {  //도착위치
                dp[i][j] = j - i;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());   //시작 위치
            int E = Integer.parseInt(st.nextToken());   //도착 위치
            int dist = Integer.parseInt(st.nextToken());    //길이
            if (E > D) {
                continue;
            }
            dp[S][E] = Math.min(dp[S][E], dist);    //최소거리 저장
        }

        for (int i = 1; i <= D; i++) {
            int min = dp[0][i];
            for (int j = 1; j < i; j++) {   //시작위치
                int result = dp[0][j] + dp[j][i];   //0~j && j~i
                min = Math.min(min, result);
            }
            dp[0][i] = min;
        }
        System.out.println(dp[0][D]);


    }
}
