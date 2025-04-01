import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] answer = solve(N, arr);
        Arrays.sort(answer);
        System.out.println(answer[0]+" "+answer[1]);

    }

    public static int[] solve(int N, int[] arr) {
        int s = 0;
        int e = N - 1;
        int a = 0, b = 0;
        long min = Long.MAX_VALUE;

        while (s < e) {
            long sum = arr[s] + arr[e];
            long result = Math.abs(sum);
            if (min > result) {
                min = result;
                a = arr[s];
                b = arr[e];
            }
            if (sum < 0) {
                s++;
            }
            else {
                e--;
            }

        }
        return new int[]{a, b};
    }

}