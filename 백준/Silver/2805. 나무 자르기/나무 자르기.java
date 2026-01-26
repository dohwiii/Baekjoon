import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int max = 0;
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        System.out.println(binarySearch(0, max, trees));





    }

    private static int binarySearch(int a, int b, int[] trees) {
        int result = 0;

        while (a <= b) {
            int mid = (a + b) / 2;
            long sum = 0;

            for (int i = 0; i < trees.length; i++) {
                if (trees[i] <= mid) {
                    continue;
                }
                sum += (trees[i] - mid);
            }
            if (sum >= M) { // 절단기 높이 up
                result = Math.max(result, mid);
                a = mid + 1;

            } else {  // 절단기 높이 down
                b = mid - 1;
            }
        }
        return result;
    }

}