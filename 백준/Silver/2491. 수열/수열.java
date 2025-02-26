import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int asc = 1, desc = 1;
        int ans = 1;
        //오름차순
        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1]) {
                asc++;
            }
            else {
                asc = 1;
            }
            if (arr[i] <= arr[i - 1]) {
                desc++;
            }
            else {
                desc = 1;
            }
            ans = Math.max(ans, Math.max(asc, desc));
        }
        System.out.println(ans);
    }
}
