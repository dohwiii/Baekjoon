import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 수열의 크기 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 수열 A 입력
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp 배열: dp[i]는 길이가 i+1인 증가하는 부분 수열의 마지막 원소의 최소값을 의미
        int[] dp = new int[N];
        int length = 0; // 현재까지 찾은 LIS의 길이
        
        for (int i = 0; i < N; i++) {
            int num = A[i];
            // 이분 탐색: dp[0, length) 구간에서 num의 삽입 위치를 찾음
            int pos = Arrays.binarySearch(dp, 0, length, num);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = num;
            // 만약 num이 현재 dp의 가장 큰 값보다 큰 경우, LIS 길이를 1 증가시킴
            if (pos == length) {
                length++;
            }
        }
        
        // 결과 출력: 가장 긴 증가하는 부분 수열의 길이
        System.out.println(length);
    }
}