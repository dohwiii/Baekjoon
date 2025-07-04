import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 4500;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[MOD][MOD];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken()) + 10000000;
            arr[k / MOD][k % MOD]++;
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[M];
        for (int i = 0; i < M; i++) {
            int c = Integer.parseInt(st.nextToken()) + 10000000;
            sb.append(arr[c / MOD][c % MOD]).append(" ");
        }

        System.out.println(sb);

    }

    //key보다 작은 구간의 끝
    private static int lowerBound(int key, int[] arr) {
        int s = 0, e = arr.length;
        while (s < e) {
            int mid = (s + e) / 2;

            if (arr[mid] < key) {
                s = mid + 1;
            }
            else if (arr[mid] >= key) {
                e = mid;
            }
        }
        return s;
    }

    //처음 > key 위치 찾기
    private static int upperBound(int key, int[] arr) {
        int s = 0, e = arr.length;
        while (s < e) {
            int mid = (s + e) / 2;

            if (arr[mid] <= key) {
                s = mid + 1;
            } else if (arr[mid] > key) {
                e = mid;
            }
        }
        return s;
    }
}