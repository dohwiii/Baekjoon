import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입력: BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 첫 번째 값을 읽어 초기화: dp의 시작 값 (prev)로 사용
        double prev = Double.parseDouble(br.readLine());
        double ans = prev;
        
        // 남은 값들을 입력받으면서 dp 계산 (한 번의 반복문으로)
        for (int i = 1; i < N; i++) {
            double x = Double.parseDouble(br.readLine());
            // 현재 값 x와 이전 누적 곱 prev*x 중 큰 값을 선택
            prev = Math.max(x, prev * x);
            // 전체 최대값 갱신
            ans = Math.max(ans, prev);
        }
        
        // 빠른 출력: System.out.printf 사용
        System.out.printf("%.3f", ans);
    }
}