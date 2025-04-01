import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        System.out.println(solve());


    }

    public static int solve() {
        int s = 0;
        int e = N - 1;
        int cnt = 0;

        while (s < e) {
            int result = arr[s] + arr[e];

            if (result == X) {
                cnt++;
                s++;
                e--;
            } else if (result > X) {
                e--;
            } else {
                s++;
            }
        }
        return cnt;
    }
}