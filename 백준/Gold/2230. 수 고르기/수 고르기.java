
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(solve(arr, M));


    }

    public static long solve(int[] arr, int M) {
        int s = 0, e = 0;
        long minDiff = Long.MAX_VALUE;

        while (s < arr.length && e < arr.length) {
            long diff = arr[e] - arr[s];

            if (diff >= M) {
                minDiff = Math.min(minDiff, diff);
                s++;
            } else {
                e++;
            }
        }
        return minDiff;
    }


}