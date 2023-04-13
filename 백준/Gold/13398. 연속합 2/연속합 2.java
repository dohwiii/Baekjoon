import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sumL = new int[N];
        int[] sumR = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sumR[0] = arr[0]; //10
        int result = sumR[0];
        for (int i = 1; i < N; i++) {
            sumR[i] = Math.max(arr[i], arr[i] + sumR[i - 1]);
            result = Math.max(result, sumR[i]);
        }
        sumL[N - 1] = arr[N - 1]; //-1
        for (int i = N - 2; i >= 0; i--) {
            sumL[i] = Math.max(arr[i], arr[i] + sumL[i + 1]);
        }
        for (int i = 1; i < N - 1; i++) {
            result = Math.max(result, sumR[i - 1] + sumL[i + 1]);
        }

        System.out.println(result);
    }
}