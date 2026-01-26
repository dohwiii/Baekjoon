import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());   // 지방의 수
        int[] regions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            regions[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        Arrays.sort(regions);
        int max = regions[N - 1];   // 최대 예산액

        System.out.println(binarySearch(0, max, regions));


    }

    private static int binarySearch(int left, int right, int[] regions) {
        int limit = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < regions.length; i++) {
                if (regions[i] > mid) {
                    sum += mid;
                }
                else {
                    sum += regions[i];
                }
            }
            if (sum <= M) { // 총 예산을 다 사용할 수 있다면 -> 상한액 up
                limit = mid;
                left = mid + 1;
            }
            else {  // 상한액 down
                right = mid - 1;
            }
        }
        return limit;
    }

}