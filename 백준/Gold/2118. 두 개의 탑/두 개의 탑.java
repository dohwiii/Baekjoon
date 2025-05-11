import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2 * N];
        int[] sum = new int[2 * N + 1];
        int total = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }
        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
        int maxDist = 0;
        int left = 0, right = 1;
        while (left < N && right < N) {
            int dist = sum[right] - sum[left];
            if (dist <= total / 2) {
                right++;
                maxDist = Math.max(maxDist, dist);
            }
            else {  //반시계 방향이 더 작음
                left++;
                maxDist = Math.max(maxDist, total - dist);
            }
        }
        System.out.println(maxDist);








    }
}