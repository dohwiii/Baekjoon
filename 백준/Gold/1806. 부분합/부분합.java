import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0;
        long sum = 0;
        int minLen = 100_000;

        while (e < N) {
            sum += arr[e];
            while (sum >= S) {
                int len = e - s + 1;
                minLen = Math.min(minLen, len); //합이 S이상이면서 최소길이
                sum -= arr[s];
                s++;
            }
            e++;
        }
        if (minLen == 100_000) {
            minLen = 0;
        }
        System.out.println(minLen);
    }
}