import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N * 2 + 1]; //N=5라면 11까지
        int[] sum = new int[N * 2 + 1]; //N=5라면 11까지
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 2; i <= N + N; i++) {
            if (i >= N + 2) {
                sum[i] = sum[i - 1] + arr[(i - 1) % N];
                continue;
            }
            sum[i] = sum[i - 1] + arr[(i - 1)];
        }
        int maxDist = 0;
        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                //탑 i와 j를 세운다면
                int clockwise = sum[j] - sum[i];
                int counterclockwise = sum[i + N] - sum[j];
                maxDist = Math.max(maxDist, Math.min(clockwise, counterclockwise));
            }
        }
        System.out.println(maxDist);

    }
}