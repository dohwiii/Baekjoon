import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static long minDiff = 2_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        //(i, j)쌍 고정시키기
        a:
        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 3; j < N; j++) {
                snow(i, j, arr);
                if (minDiff == 0) {
                    break a;
                }
            }
        }

        System.out.println(minDiff);


    }

    public static void snow(int i, int j, int[] arr) {
        long comp = arr[i] + arr[j];
        int s = i + 1, e = j - 1;

        while (s < e) {
            long sum = arr[s] + arr[e];
            minDiff = Math.min(minDiff, Math.abs(comp - sum));

            if (sum < comp) {
                s++;
            } else if (sum > comp) {
                e--;
            } else {
                return;
            }
        }
    }
}