import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합
        long[] psum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            psum[i + 1] = psum[i] + a[i];
        }

        // 구간합 함수 q(l, r) = sum of a[l..r]
        // inclusive range
        // psum[r + 1] - psum[l]
        long ans = 0;
        int l = 1, r = n - 2; // 초기값

        for (int x = 0; x < n - 2; x++) {
            long A = psum[x + 1]; // 머리 sum(0..x)

            l = Math.max(l, x + 1);

            // r 줄이기: 배 <= 머리인 경우 제외
            while (r > 0 && psum[n] - psum[r + 1] <= A) {
                r--;
            }

            // l 늘리기: 가슴 <= 배인 경우 제외
            while (l < n && psum[l + 1] - psum[x + 1] <= psum[n] - psum[l + 1]) {
                l++;
            }

            if (r >= l) {
                ans += (r - l + 1);
            }
        }

        System.out.println(ans);
    }
}