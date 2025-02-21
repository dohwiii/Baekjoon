import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] dp, parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        int index = dp[len - 1];    //마지막 인덱스
        ArrayList<Integer> lis = new ArrayList<>();
        while (index != -1) {
            lis.add(arr[index]);
            index = parent[index];
        }
        Collections.reverse(lis);  // 리스트를 뒤집어서 올바른 순서로 만들기
        bw.write(len + "\n");

        for (int num : lis) {
            bw.write(num + " ");
        }


        bw.flush();
        bw.close();
    }

    public static int lowerBound(long num, int len) {
        int left = 0, right = len;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
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
