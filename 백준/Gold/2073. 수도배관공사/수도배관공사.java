import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int D = Integer.parseInt(st.nextToken());  // 수도관 길이
        int P = Integer.parseInt(st.nextToken());  // 파이프 개수
        
        int[] dp = new int[D + 1];  // dp[i]: 길이 i를 만들 때 최대 용량 저장
        Arrays.fill(dp, -1);
        dp[0] = Integer.MAX_VALUE;  // 초기값: 빈 수도관의 경우 무한대 용량으로 설정
        
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());  // 파이프 길이
            int C = Integer.parseInt(st.nextToken());  // 파이프 용량
            
            // DP 배열 갱신 (완전 배낭 문제)
            for (int j = D; j >= L; j--) {
                if (dp[j - L] != -1) { // 이전 길이가 유효한 경우만 갱신
                    dp[j] = Math.max(dp[j], Math.min(dp[j - L], C));
                }
            }
        }
        
        // 정답 출력
        System.out.println(dp[D]);
    }
}