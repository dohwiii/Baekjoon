import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N * 2];
        long[] sum = new long[N * 2 + 1]; // 누적합 배열
        long total = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = arr[i + N] = Integer.parseInt(br.readLine()); // 원형이니까 2배로 복붙
            total += arr[i];
        }

        // 누적합
        for (int i = 0; i < 2 * N; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }

        int right = 0;
        long max = 0;

        for (int left = 0; left < N; left++) {
            while (right + 1 < left + N && sum[right + 1] - sum[left] <= total / 2) {
                right++;
            }
            long clockwise = sum[right] - sum[left];
            long counterclockwise = total - clockwise;
            max = Math.max(max, Math.min(clockwise, counterclockwise));
        }

        System.out.println(max);
    }
}