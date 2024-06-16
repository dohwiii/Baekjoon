
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //전체 날짜 수
        K = Integer.parseInt(st.nextToken());   //연속 날짜 수
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        System.out.println(result);

    }
    public static void solve() {
        int left = 0;
        int right = 0;
        int sum = 0;
        int size = 0;

        while (left < N && right < N) {
            if (size >= K) {
                sum -= arr[left];
                left++;
                size--;
            }
            else if (size < K) {
                sum += arr[right];
                right++;
                size++;
            }
            if (size == K) {
                result = Math.max(result, sum);
            }
        }
    }

}