import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, parent, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        parent = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(parent, -1);    //역추적용
        int len = 1;
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            int index = lowerBound(arr[i], len);
            dp[index] = i;

            if (index > 0) {
                parent[i] = dp[index - 1];
            }
            if (index == len) {
                len++;
            }

        }
        int[] answer = new int[len];
        int index = dp[len - 1];    //마지막 인덱스
        for (int i = len - 1; i >= 0; i--) {
            answer[i] = arr[index];
            index = parent[index];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(len + "\n");
        for (int i = 0; i < len; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    public static int lowerBound(int num, int len) {
        int left = 0, right = len;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[dp[mid]] >= num) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return right;
    }
}
