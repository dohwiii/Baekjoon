import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());   //시작 볼륨
        int M = Integer.parseInt(st.nextToken());   //최대 볼륨
        int[] volume = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N + 1][M + 1];
        int now = S;
        if (now + volume[1] <= M) { //볼륨 높이기
            dp[1][now + volume[1]] = true;
        }
        if (now - volume[1] >= 0) { //볼륨 낮추기
            dp[1][now - volume[1]] = true;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {
                    int value = j;
                    if (value + volume[i] <= M) {
                        dp[i][value + volume[i]] = true;
                    }
                    if (value - volume[i] >= 0) {
                        dp[i][value - volume[i]] = true;
                    }
                }
            }
        }
        int max = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                max = i;
                break;
            }
        }
        System.out.println(max);







    }
}
