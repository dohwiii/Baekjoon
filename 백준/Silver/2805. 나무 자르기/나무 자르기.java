
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] trees;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 간선 개수
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }


        int ans = binarySearch();
        System.out.println(ans);


    }

    private static int binarySearch() {
        int s = 0;
        int e = max;
        int maxCut = 0;

        while (s < e) {
            int mid = (s + e) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    sum += (trees[i] - mid);
                }
            }
            if (sum >= M) {
                s = mid + 1;
                maxCut = mid;
            } else {
                e = mid;
            }
        }
        return maxCut;
    }

}