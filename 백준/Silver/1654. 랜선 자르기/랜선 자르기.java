
import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static int[] cables;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());   // 랜선 개수
        N = Integer.parseInt(st.nextToken());   // 필요한 랜선 개수
        cables = new int[N];

        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, cables[i]);
        }

        System.out.println(binarySearch());


    }

    private static long binarySearch() {
        long s = 1;
        long e = max;
        long maxDist = 0;

        while (s <= e) {
            long mid = (s + e) / 2;
            int sum = 0;

            for (int i = 0; i < K; i++) {
                long cnt = cables[i] / mid;
                sum += cnt;
            }
            if (sum >= N) {
                s = mid + 1;
                maxDist = mid;
            } else {
                e = mid - 1;
            }
        }
        return maxDist;
    }

}