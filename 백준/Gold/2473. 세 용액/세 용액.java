import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] ans = solve();
        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);


    }

    public static int[] solve() {
        long min = Long.MAX_VALUE;
        int a = 0, b = 0, c = 0;

        for (int i = 0; i < N - 2; i++) {   //하나 고정
            int fix = arr[i];
            int s = i + 1;
            int e = N - 1;
            long sum = 0;

            while (s < e) {
                long s1 = (long) fix + arr[s] + arr[e];
                sum = Math.abs(s1);

                if (sum < min) {
                    min = sum;
                    a = fix;
                    b = arr[s];
                    c = arr[e];
                }
                if (s1 > 0) {
                    e--;
                } else {
                    s++;
                }

            }

        }
        return new int[]{a, b, c};
    }

}