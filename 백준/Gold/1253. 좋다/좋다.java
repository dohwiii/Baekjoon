import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

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
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (solve(arr, N, arr[i], i)) {
//                System.out.println(arr[i]);
                ans++;
            }

        }
        System.out.println(ans);
    }

    public static boolean solve(int[] arr, int n, int target, int index) {
        int s = 0, e = n - 1;
        if (s == index) {
            s++;
        } else if (e == index) {
            e--;
        }

        while (s < e) {
            long re = arr[s] + arr[e];

            if (re == target) {
                return true;
            } else if (re < target) {
                s++;
            } else {
                e--;
            }
            if (s == index) {
                s++;
            }
            else if (e == index) {
                e--;
            }
        }
        return false;
    }

}