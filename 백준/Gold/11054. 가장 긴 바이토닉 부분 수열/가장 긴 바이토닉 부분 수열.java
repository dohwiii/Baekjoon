import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열 크기
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. LIS 구하기 (O(N log N))
        int[] lis = getLIS(arr);

        // 2. LDS 구하기 (O(N log N))
        int[] lds = getLIS(reverseArray(arr)); // 배열 뒤집어서 LIS 계산

        // 3. 최장 바이토닉 수열 길이 찾기
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, lis[i] + lds[N - i - 1] - 1);
        }

        System.out.println(maxLength);
    }

    // 🔹 LIS 구하는 함수 (O(N log N)) - 이분 탐색 직접 구현
    public static int[] getLIS(int[] arr) {
        int N = arr.length;
        int[] lisLength = new int[N]; // 각 원소의 LIS 길이를 저장
        int[] dp = new int[N]; // LIS를 저장하는 배열 (실제 길이만 유지)
        int length = 0; // LIS 길이
        
        for (int i = 0; i < N; i++) {
            int pos = lowerBound(dp, arr[i], length); // 직접 이분 탐색 구현
            dp[pos] = arr[i]; // 적절한 위치에 값 갱신
            
            if (pos == length) { // 새로운 원소를 LIS에 추가한 경우
                length++;
            }
            lisLength[i] = pos + 1; // 현재 LIS 길이 저장
        }
        return lisLength;
    }

    // 🔹 직접 구현한 lowerBound (이분 탐색)
    public static int lowerBound(int[] dp, int num, int len) {
        int left = 0, right = len;

        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] >= num) {  
                right = mid;  // num보다 크거나 같다면 왼쪽 범위로 이동
            } else {
                left = mid + 1;  // num보다 작다면 오른쪽으로 이동
            }
        }
        return left; // num 이상인 첫 번째 위치 반환
    }

    // 🔹 배열 뒤집기 함수
    public static int[] reverseArray(int[] arr) {
        int N = arr.length;
        int[] rev = new int[N];
        for (int i = 0; i < N; i++) {
            rev[i] = arr[N - i - 1];
        }
        return rev;
    }
}