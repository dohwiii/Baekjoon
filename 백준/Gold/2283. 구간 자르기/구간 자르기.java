import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] lines = new int[1_000_001];
        int max = 0;
        int min = 1_000_000;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines[s]++;
            lines[e]--;
            min = Math.min(min, s);
            max = Math.max(max, e);
        }
        //누적합
        for (int i = min + 1; i <= max; i++) {
            lines[i] += lines[i - 1];
        }
        long sum = 0;
        int start = 0, end = min;
        while (end <= max) {
            if (sum == K) {
                System.out.println(start + " " + end);
                return;
            }
            else if (sum > K) {
                sum -= lines[start];
                start++;
            }
            else if (sum < K) {
                sum += lines[end];
                end++;
            }
        }
        System.out.println("0 0");
    }
}