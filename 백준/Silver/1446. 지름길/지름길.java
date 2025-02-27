import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //지름길 개수
        int D = Integer.parseInt(st.nextToken());   //고속도로 길이
        int[] dp = new int[D + 1];

        for (int i = 1; i <= D; i++) {
            dp[i] = i;
        }
        List<int[]>[] shortcut = new List[D + 1];
        for (int i = 0; i <= D; i++) {
            shortcut[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());   //시작 위치
            int E = Integer.parseInt(st.nextToken());   //도착 위치
            int dist = Integer.parseInt(st.nextToken());    //길이
            if (S > D || E > D) {
                continue;
            }
            shortcut[S].add(new int[]{E, dist});
        }

        for (int i = 0; i <= D; i++) {  //시작위치
            if (i != 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            for (int[] fast : shortcut[i]) {    //해당 위치에서 갈 수 있는 지름길이 있다면
                int end = fast[0];  //도착위치
                int dist = fast[1]; //길이

                dp[end] = Math.min(dp[end], dp[i] + dist);
            }
        }
        System.out.println(dp[D]);




    }
}
