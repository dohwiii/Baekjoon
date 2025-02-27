import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 지름길 개수
        int D = Integer.parseInt(st.nextToken()); // 고속도로 길이

        // 지름길 정보를 저장 (시작 위치에서 [도착, 거리] 목록)
        List<int[]>[] shortcuts = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            shortcuts[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (end <= D) {
                shortcuts[start].add(new int[]{end, dist});
            }
        }
        
        // 1차원 dp 배열: dp[i] = 0번 지점에서 i번 지점까지의 최소 이동 거리
        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        // dp 업데이트: i번 지점에서 i+1로 이동하는 일반 도로와 지름길 고려
        for (int i = 0; i < D; i++) {
            // 일반 도로: i -> i+1
            if (dp[i] != Integer.MAX_VALUE && i + 1 <= D) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
            // 지름길: i에서 시작하는 모든 지름길 고려
            for (int[] shortcut : shortcuts[i]) {
                int end = shortcut[0];
                int dist = shortcut[1];
                if (dp[i] != Integer.MAX_VALUE) {
                    dp[end] = Math.min(dp[end], dp[i] + dist);
                }
            }
        }
        
        System.out.println(dp[D]);
    }
}