import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());   //널빤지 길이
        int[][] puddles = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            puddles[i][0] = Integer.parseInt(st.nextToken());
            puddles[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 시작 위치 기준으로 정렬
        Arrays.sort(puddles, (o1, o2) -> o1[0] - o2[0]);
        
        int lastPos = -1;    // 널빤지가 덮는 마지막 위치 (초기값은 -1)
        int cnt = 0;
        
        for (int i = 0; i < N; i++) {
            int start = puddles[i][0];
            int end = puddles[i][1];
            
            if (lastPos < start) {
                // 새로운 널빤지가 필요한 경우
                int len = end - start;    // 웅덩이 길이
                int need = (len + L - 1) / L;    // 필요한 널빤지 개수 (올림 계산)
                lastPos = start + L * need - 1;  // 마지막 널빤지의 끝 위치
                cnt += need;
            } else if (lastPos < end - 1) {
                // 기존 널빤지로 일부만 덮이는 경우, 추가 널빤지 필요
                int uncoveredStart = lastPos + 1;  // 덮이지 않은 부분의 시작
                int len = end - uncoveredStart;    // 덮이지 않은 길이
                int need = (len + L - 1) / L;      // 필요한 널빤지 개수
                lastPos = uncoveredStart + L * need - 1;  // 마지막 널빤지의 끝 위치
                cnt += need;
            }
            // lastPos >= end - 1 인 경우, 이미 완전히 덮여있으므로 추가 널빤지 불필요
        }
        
        System.out.println(cnt);
    }
}