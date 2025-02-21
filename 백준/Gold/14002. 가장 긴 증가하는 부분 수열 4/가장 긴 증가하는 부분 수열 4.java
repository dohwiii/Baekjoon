import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];  // LIS 배열
        int[] parent = new int[N];  // 역추적을 위한 배열
        int[] indexTracking = new int[N]; // LIS의 위치 저장
        int length = 0; // LIS 길이
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 찾기
        Arrays.fill(parent, -1); // 초기화 (역추적용)

        for (int i = 0; i < N; i++) {
            int pos = Arrays.binarySearch(dp, 0, length, arr[i]);
            if (pos < 0) pos = -(pos + 1); // 삽입 위치 찾기

            dp[pos] = arr[i];  // dp에 값 업데이트
            indexTracking[pos] = i;  // 위치 기록
            if (pos > 0) parent[i] = indexTracking[pos - 1]; // 이전 값 추적

            if (pos == length) length++; // LIS 길이 증가
        }

        // LIS 역추적
        Stack<Integer> stack = new Stack<>();
        int idx = indexTracking[length - 1]; // 마지막 요소부터 추적 시작
        while (idx != -1) {
            stack.push(arr[idx]);
            idx = parent[idx]; // 이전 값으로 이동
        }

        // 결과 출력
        System.out.println(length);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
