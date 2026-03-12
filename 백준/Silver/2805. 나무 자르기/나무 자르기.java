import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());    // 나무의 개수
        M = Integer.parseInt(st.nextToken());    // 챙겨갈 나무 높이
        arr = new int[N];   // 나무의 높이
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   // 오름차순

        int l = 1;
        int r = arr[N - 1];
        int ans = 0;

        while (l <= r) {
            int cutter = (l + r) / 2;  // 절단기 높이
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > cutter) {
                    sum += (arr[i] - cutter);
                }
            }
            if (sum >= M) {
                ans = cutter;
                l = cutter + 1;
            }
            else {
                r = cutter - 1;
            }
        }
        System.out.println(ans);



    }
}