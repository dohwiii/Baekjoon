import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        long max = sum;

        for (int i = 1; i < N - K + 1; i++) {
            sum -= arr[i - 1];
            sum += arr[i + K - 1];
            max = Math.max(max, sum);
        }
        System.out.println(max);


    }

}