import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        int[] trees = new int[N];
        int max = 0;  // ✅ 수정
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        
        System.out.println(binarySearch(0, max, M, trees));  // ✅ 0부터
    }
    
    private static int binarySearch(int a, int b, long M, int[] trees) {
        int result = 0;  // ✅ 답을 명시적으로 저장
        
        while (a <= b) {  // ✅ <= 사용 (더 안전)
            int avg = (a + b) / 2;
            long sum = 0;  // ✅ long 사용
            
            for (int tree : trees) {
                if (tree > avg) {
                    sum += (tree - avg);
                }
            }
            
            if (sum >= M) {  // 충분함 → 높이 올리기 가능
                result = avg;     // ✅ 현재 높이 저장
                a = avg + 1;      // 더 높은 높이 시도
            } else {  // 부족함 → 높이 낮춰야 함
                b = avg - 1;
            }
        }
        
        return result;  // ✅ 명확하게 답 반환
    }
}