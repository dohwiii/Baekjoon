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
        int total = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = arr[i + N] = Integer.parseInt(br.readLine());
            total += arr[i];
        }
        for (int i = 0; i < 2 * N; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
        int left = 0, right = 1;
        int maxDist = 0;

        while (left < N && right < N) {
            int clockwise = sum[right] - sum[left];
            if (clockwise <= total / 2) {   //이 길이가 더 짧은 거리
                right++;
                int counterclockwise = total - clockwise;   //반시계 방향
                maxDist = Math.max(maxDist, clockwise);
            }
            else {
                left++;
                int counterclockwise = total - clockwise;   //반시계 방향
                maxDist = Math.max(maxDist, counterclockwise);
            }

        }
        System.out.println(maxDist);



    }
}