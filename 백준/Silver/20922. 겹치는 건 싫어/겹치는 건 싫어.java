
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(arr, K));
    }

    public static int solve(int[] arr, int K) {
        int s = 0, e = 0;
        int n = arr.length;
        int maxLength = 0;
        int[] cnt = new int[200001];    //숫자 등장 횟수

        while (s < n && e < n) {
            if (cnt[arr[e]] >= K) {  //이미 K 횟수 초과
                int length = e - s;
                maxLength = Math.max(maxLength, length);
                while (cnt[arr[e]] >= K) {  //길이 조정
                    cnt[arr[s]]--;
                    s++;
                }

            } else {
                cnt[arr[e]]++;
                e++;
            }

        }
        if (s <= arr.length && e <= arr.length) {
            maxLength = Math.max(maxLength, e - s);
        }
        return maxLength;
    }


}