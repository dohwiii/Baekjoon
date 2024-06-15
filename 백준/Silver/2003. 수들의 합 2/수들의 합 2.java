
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, sum;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        sum = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve();
        System.out.println(cnt);

    }
    public static void solve() {
        int left = 0;
        int right = 0;
        int sum = 0;

        while (left < N && right < N) {
            sum += arr[right];

            if (sum <= M) {
                if (sum == M) {
                    cnt++;   //경우의 수 증가
                }
                right++;
            }
            else if (sum > M) {
                sum = sum - arr[left] - arr[right];
                left++;
            }

        }

    }

}