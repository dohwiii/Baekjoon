import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int good = 0;
        Arrays.sort(arr);
        for (int i = N - 1; i >= 0; i--) {
            int now = arr[i];
            int s = 0, e = N - 1;
            while (s < e) {
                if (s == i) {
                    s++;
                }
                if (e == i) {
                    e--;
                }
                if (s == e) {
                    break;
                }
                int sum = arr[s] + arr[e];
                if (sum == now) {
                    good++;
                    break;
                } else if (sum > now) {
                    e--;
                } else if (sum < now) {
                    s++;
                }
            }
        }
        System.out.println(good);




    }
}