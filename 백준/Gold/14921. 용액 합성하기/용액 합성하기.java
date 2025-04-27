import java.io.*;
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
        int s = 0, e = N - 1;
        int min = 200_000_001;
        int ans = 0;

        while (s < e) {
            int sum = arr[s] + arr[e];
            int abs = Math.abs(sum);
            if (min > abs) {
                ans = sum;
                min = abs;
            }
            if (sum == 0) {
                break;
            }
            else if (sum > 0) {
                e--;
            }
            else {
                s++;
            }

        }
        System.out.println(ans);
    }

}
