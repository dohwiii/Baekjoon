import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long ans = 0;

        for (int i = 0; i < N - 2; i++) {
            int fix = arr[i];
            ans += solve(i + 1, N - 1, fix, arr);
        }
        System.out.println(ans);
    }

    public static long solve(int s, int e, int fix, int[] arr) {
        long ans = 0;
        while (s < e) {
            long sum = fix + arr[s] + arr[e];

            if (sum == 0) {
                //중복값 처리
                if (arr[s] == arr[e]) {
                    int len = e - s + 1;
                    ans += (long) len * (len - 1) / 2;
                    break;
                }
                int countLeft = 1;
                int countRight = 1;

                while (s + 1 < e && arr[s] == arr[s + 1]) {
                    countLeft++;
                    s++;
                }
                while (e - 1 > s && arr[e] == arr[e - 1]) {
                    countRight++;
                    e--;
                }
                ans += (long) countLeft * countRight;
                s++;
                e--;
            }
            else if (sum > 0) {
                e--;
            }
            else {
                s++;
            }
        }
        return ans;
    }


}