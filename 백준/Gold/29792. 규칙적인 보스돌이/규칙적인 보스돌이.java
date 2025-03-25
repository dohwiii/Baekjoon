import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 캐릭터 개수
        int M = Integer.parseInt(st.nextToken());   // 하루에 사용할 캐릭터 개수
        int K = Integer.parseInt(st.nextToken());   // 보스의 가짓수

        // 캐릭터 DPS (초당 데미지)
        long[] damage = new long[N];
        for (int i = 0; i < N; i++) {
            damage[i] = Long.parseLong(br.readLine());
        }

        // 보스 정보: 체력과 보상 메소
        long[] bossHP = new long[K];
        int[] bossReward = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bossHP[i] = Long.parseLong(st.nextToken());
            bossReward[i] = Integer.parseInt(st.nextToken());
        }

        // 각 캐릭터당 15분 = 900초 동안의 최대 보상 계산
        int TIME_LIMIT = 900;
        long[] maxReward = new long[N]; // 각 캐릭터별 최대 보상

        // 각 캐릭터마다 0/1 배낭 문제로 최대 보상 구하기
        for (int i = 0; i < N; i++) {
            // dp[t] = t초 사용 시 얻을 수 있는 최대 메소
            long[] dp = new long[TIME_LIMIT + 1];

            // 모든 보스에 대해 반복
            for (int j = 0; j < K; j++) {
                // 해당 캐릭터가 보스 j를 처치하는 데 필요한 초 계산 (올림 처리)
                long reqTime = (bossHP[j] + damage[i] - 1) / damage[i];
                if (reqTime > TIME_LIMIT) continue;  // 900초 내에 처치 불가능하면 건너뜀

                // 0/1 배낭: 뒤에서부터 순회하며 dp 업데이트
                for (int t = TIME_LIMIT; t >= reqTime; t--) {
                    dp[t] = Math.max(dp[t], dp[(int)(t - reqTime)] + bossReward[j]);
                }
            }

            // 해당 캐릭터가 900초 내에 얻을 수 있는 최대 보상
            long best = 0;
            for (int t = 0; t <= TIME_LIMIT; t++) {
                best = Math.max(best, dp[t]);
            }
            maxReward[i] = best;
        }

        // 여러 캐릭터 중 보상이 높은 M명 선택 (각 캐릭터의 계산은 독립적임)
        Arrays.sort(maxReward);
        long total = 0;
        for (int i = N - 1; i >= N - M; i--) {
            total += maxReward[i];
        }

        System.out.println(total);
    }
}