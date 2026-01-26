import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());   // 가진 랜선 개수
        int N = Integer.parseInt(st.nextToken());   // 필요한 랜선 개수
        
        long max = 0;  // ✅ long으로 변경
        int[] cables = new int[K];  // ✅ K로 변경!

        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, cables[i]);
        }
        
        System.out.println(binarySearch(1, max, cables, N));  // ✅ 1부터 시작
    }

    private static long binarySearch(long a, long b, int[] cables, int N) {
        long result = 0;  // ✅ length → result로 명확하게

        while (a <= b) {
            long mid = (a + b) / 2;
            long count = 0;  // ✅ sum → count (개수니까)

            for (int cable : cables) {  // ✅ 향상된 for문
                count += (cable / mid);
            }

            if (count >= N) {  // N개 이상 만들 수 있음
                result = mid;     // ✅ 현재 길이 저장
                a = mid + 1;      // 더 긴 길이 시도
            } else {  // N개 못 만듦
                b = mid - 1;      // 더 짧게 잘라야 함
            }
        }
        return result;
    }
}