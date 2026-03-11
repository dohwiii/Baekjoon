import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(binarySearch());



    }

    public static int binarySearch() {
        int l = 1;
        int r = arr[N - 1] - arr[0];
        int maxLen = 0;

        while (l <= r) {
            int wifi = 1;
            int mid = (l + r) / 2;  // 최소거리
            int s = arr[0];
            for (int i = 1; i < N; i++) {
                if (arr[i] - s < mid) {
                    continue;
                } else {
                    wifi++;
                    s = arr[i];
                }
            }
            if (wifi < C) {
                r = mid - 1;
            } else if (wifi >= C) {
                l = mid + 1;
                maxLen = Math.max(maxLen, mid);
            }

        }
        return maxLen;

    }

}