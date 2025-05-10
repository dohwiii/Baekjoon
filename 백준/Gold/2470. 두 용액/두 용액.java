import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int minDiff = 2_000_000_000;
        int s = 0, e = N - 1;
        int[] liquid = new int[2];
        while (s < e) {
            int sum = arr[s] + arr[e];

            if (minDiff > Math.abs(sum)) {
                minDiff = Math.abs(sum);
                liquid[0] = arr[s];
                liquid[1] = arr[e];
            }
            if (sum < 0) {
                s++;
            } else if (sum == 0) {
                System.out.println(arr[s] + " " + arr[e]);
                return;
            } else {
                e--;
            }
        }
        System.out.println(liquid[0] + " " + liquid[1]);

    }
}